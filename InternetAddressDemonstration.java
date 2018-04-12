// Demonstrating ways to display the internet address of a host
import java.io.IOException;
import java.net.*;

public class InternetAddressDemonstration {
    public static void main(String[] argv) throws IOException {
        // Display our local host
        final InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("\nOur local host address is: " + localHost);

        // Using github.com as an example
        String hostName = "www.github.com";
        String networkAddress = "192.30.255.113";

        // Get the InetAddress by looking up a host by host name
        System.out.println("\nExample Host: " + hostName + ", IP Address: " + InetAddress.getByName(hostName).getHostAddress());

        // Look up a host by address
        System.out.println("The network address (ip) " + networkAddress + " is named " + InetAddress.getByName(networkAddress).getHostName());

        // Display the InetAddress from an open Socket
        Socket theOpenSocket = new Socket(hostName, 80);
        InetAddress remote = theOpenSocket.getInetAddress();
        System.out.printf("One InetAddress for %s is: %s%n", hostName, remote);

        //  InetAddress.getAllByName() returns an array of all the addresses the host resolves to
        System.out.println("\nList of all addresses " + hostName + " resolves to:");
        InetAddress allNames[] = InetAddress.getAllByName(hostName);
        for (int i = 0; i < allNames.length; i++) {
            System.out.println(allNames[i]);
        }

    }
}