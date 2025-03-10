package network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetAddessExample {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                if(inetAddresses.hasMoreElements()) {
                    System.out.println("Interface: " + networkInterface.getDisplayName());
                }
                while(inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("Inet: " + inetAddress.getHostAddress());
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        String domain = "google.com";
        try {
            InetAddress byName = InetAddress.getByName(domain);
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(byName);
            System.out.println(byInetAddress.getDisplayName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

    }
}
