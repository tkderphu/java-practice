package concurrent.webSocket;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class WebSocketServer {

    private static final int PORT = 8080;
    private static final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private static final ConcurrentHashMap<String, Set<ClientHandler>> subscribers = new ConcurrentHashMap<>();
    public static void main(String[] args) throws IOException {
        System.out.println("WebSocket server started on port " + PORT);
        ServerSocket serverSocket = new ServerSocket(PORT);
        Thread tester = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("============Send message to client===========: ");
                String message =  scanner.nextLine();
                clients.forEach(client -> {
                    client.broadcast(message);
                });
            }
        });

        tester.start();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            pool.submit(new ClientHandler(clientSocket));
        }
    }


    public static ClientHandler getClient(Socket socket) {
        return clients.stream()
                .filter(handler -> handler.socket.equals(socket))
                .findFirst().orElse(null);
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private InputStream in;
        private OutputStream out;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();

                if (!handshake()) return;

                clients.add(this);
                while (true) {
                    String message = readMessage();
                    if (message == null) break;
                    System.out.println("Received: " + message);
                    broadcast(message);
                }

            } catch (Exception e) {
                System.out.println("Connection closed.");
            } finally {
                clients.remove(this);
                try {
                    socket.close();
                } catch (IOException ignored) {}
            }
        }

        private boolean handshake() throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            String key = null;

            while (!(line = reader.readLine()).isEmpty()) {
                if (line.startsWith("Sec-WebSocket-Key: ")) {
                    key = line.substring(19);
                }
            }

            if (key == null) return false;

            String acceptKey = generateAcceptKey(key);
            String response = "HTTP/1.1 101 Switching Protocols\r\n"
                    + "Upgrade: websocket\r\n"
                    + "Connection: Upgrade\r\n"
                    + "Sec-WebSocket-Accept: " + acceptKey + "\r\n\r\n";

            out.write(response.getBytes());
            return true;
        }

        private String generateAcceptKey(String key) throws Exception {
            String magic = key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] hash = sha1.digest(magic.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        }

        private String readMessage() throws IOException {
            int b1 = in.read();
            if (b1 == -1) return null;

            int b2 = in.read();
            int len = b2 & 0x7F;

            if (len == 126) {
                len = (in.read() << 8) + in.read();
            }

            byte[] mask = in.readNBytes(4);
            byte[] payload = in.readNBytes(len);

            for (int i = 0; i < payload.length; i++) {
                payload[i] ^= mask[i % 4];
            }
            String message = new String(payload);
            if(message.startsWith("=>subscribe<=")) {
                String topic = message.split(":")[1];
                Set<ClientHandler> members = subscribers.getOrDefault(topic, new HashSet<>());
                members.add(this);
            }
            return message;
        }




        private void sendMessage(String message) {
            try {
                byte[] data = message.getBytes();
                int len = data.length;

                ByteArrayOutputStream frame = new ByteArrayOutputStream();
                frame.write(0x81); // FIN + text frame
                if (len <= 125) {
                    frame.write(len);
                } else if (len <= 65535) {
                    frame.write(126);
                    frame.write((len >> 8) & 0xFF);
                    frame.write(len & 0xFF);
                } else {
                    // Not handling >65535 bytes in this example
                    return;
                }
                frame.write(data);
                out.write(frame.toByteArray());
            } catch (IOException e) {
                clients.remove(this);
            }
        }

        public void broadcast(String topic, String message) {
            for(ClientHandler client : subscribers.getOrDefault(topic, new HashSet<>())) {
                client.sendMessage(message);
            }
        }

        private void broadcast(String message) {
            for (ClientHandler client : clients) {
                client.sendMessage(message);
            }
        }
    }
}
