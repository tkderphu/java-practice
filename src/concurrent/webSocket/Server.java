package concurrent.webSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 8080;
        ExecutorService executorService = new ExecutorService(
                5, 2
        );

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running at port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                executorService.submit(() -> handleHttpRequest(socket));
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static void handleHttpRequest(Socket socket) {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            OutputStream outputStream = socket.getOutputStream();
            String requestLine = bufferedReader.readLine();
            if(requestLine == null || requestLine.isEmpty()) return;

//            System.out.println("Server received request: " + requestLine);


            String[] parts = requestLine.split(" ");
            String path = parts[1];

            if(path.equals("/api/hello")) {
                String body = String.format( """
                            {
                                'name': 'Phu',
                                'age': 21,
                                'major': IT,
                                'currentThread: %s
                            }
                        """, Thread.currentThread().getName());
//                System.out.println("body: " + body);
                Thread.sleep(10_000);
                sendResponse(outputStream, "200", "application/json", body.getBytes());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sendResponse(OutputStream output, String status, String contentType, byte[] body) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
        writer.write("HTTP/1.1 " + status + "\r\n");
        writer.write("Content-Type: " + contentType + "\r\n");
        writer.write("Content-Length: " + body.length + "\r\n");
        writer.write("Connection: close\r\n");
        writer.write("\r\n");
        writer.flush();

        output.write(body);
        output.flush();
    }


}
