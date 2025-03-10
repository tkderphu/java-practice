package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private String name;
    private Socket socket;

    public Client(String name, String host, int port) throws IOException {
        socket = new Socket(host, port);
        this.name = name;
    }

    public void sendMessage(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        printWriter.println(name + " sent: " +message);
    }

    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int port = 65432;
        Scanner scanner = new Scanner(System.in);
        Client client = new Client("phu", hostname, port);
        while(!client.socket.isClosed()) {
            System.out.println("Nhap message: ");
            String message = scanner.nextLine();
            if(message.equals("q")) {
                client.socket.close();
            } else {
                client.sendMessage(message);
            }
        }
     }
}
