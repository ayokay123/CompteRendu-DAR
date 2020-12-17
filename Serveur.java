import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Serveur {

    static final int port = 1200;
    
    private static boolean premier(int a) {
        for (int i=2;i<a;i++) {
            if (a%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        int a = Integer.parseInt(inServer.readLine());
        List<Integer> c = new ArrayList<>();
        for (int i=2;i<=a;i++) {
            if (premier(i)) {
                c.add(i);
            }
        }
        System.out.println(c);
      
        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}
