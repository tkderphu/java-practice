package socket;

import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket = null;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public static void main(String[] args) {
        int port = 65432;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");
                    InputStream input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    String text;

                    while ((text = reader.readLine()) != null) {
                        System.out.println("Received: " + text);
                        writer.println("Hello, client!");
                    }
                } catch (IOException e) {
                    System.out.println("Server exception: " + e.getMessage());
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            e.printStackTrace();
        }
    }
}
