package network.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            Socket socket = new Socket("localhost", 8080);
//            socket.connect(new InetSocketAddress(8080));
            System.out.println("Coonect to server");
            System.out.println("Enter your message: ");
            BufferedInputStream bif = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bof = new BufferedOutputStream(socket.getOutputStream());
           while(true) {
               String msg = "dsdsd";
               bof.write(msg.getBytes());
               bof.flush();
               Thread.sleep(2000);
           }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
