package session05;

import java.io.*;
import java.net.Socket;

/**
 * Created by PaHod on 19.05.2014.
 */
public class Client {
    public static void main(String[] args) throws IOException {


    Socket socket = new Socket("127.0.0.1", 1122);
//    PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//    pw.println("");
//    pw.flush();
//    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//    System.out.println(br.readLine());
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while(socket!=null) {

            pw.println(consoleReader.readLine());
            pw.flush();

             System.out.println(br.readLine());
         }





}
}
