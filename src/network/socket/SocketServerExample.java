package network.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Start");
            while(true) {
                Socket clientSocket = serverSocket.accept();

                BufferedInputStream bif = new BufferedInputStream(clientSocket.getInputStream());
                BufferedOutputStream bof = new BufferedOutputStream(clientSocket.getOutputStream());

                System.out.println("Client access is: " + clientSocket.getInetAddress().getHostAddress());
            
                byte[] bytes = bif.readAllBytes();
                String receivMessage = String.valueOf(bytes);
                System.out.println("Server received message: " + receivMessage);

                bof.write(String.format("Ban da gui tin nhan: %s", receivMessage).getBytes());
                bof.flush();
//                clientSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
