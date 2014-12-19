package AsyncChat;

/**
 * Created by PaHod on 14.09.2014.
 */
public class ConnectThread extends Thread {
    @Override
    public void run(){
        System.out.println("Waits for connect from Client");
//        try {
//            ServerSocket serverSocket = new ServerSocket(Integer.valueOf(portFld.getText() ));
//            socket = serverSocket.accept();
//            System.out.println("Connected to Server: ip: " + socket.getLocalAddress()+ ", port: "+ socket.getLocalPort());
//        } catch (IOException e2) {
//            System.out.println("Open port error ");
//        }

    }
}
