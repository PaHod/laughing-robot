package session05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by PaHod on 19.05.2014.
 */
public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(1122);
        Socket inputSocket = ss.accept();
        System.out.println("Conected " + inputSocket.getLocalAddress() + ":" + inputSocket.getLocalPort());

        BufferedReader inBr = new BufferedReader(new InputStreamReader(inputSocket.getInputStream()));
        while (inputSocket != null) {

            System.out.println(inBr.readLine());
        }

    }
}
