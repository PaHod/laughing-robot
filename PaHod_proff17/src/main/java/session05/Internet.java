package session05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by PaHod on 19.05.2014.
 * написать синхоронный чат
 */
public class Internet {

    public static void main(String[] args) throws IOException {

       Socket socket = new Socket("192.168.1.152", 30000);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        pw.println("PaHod: Hi=)");
        pw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());



    }
}
