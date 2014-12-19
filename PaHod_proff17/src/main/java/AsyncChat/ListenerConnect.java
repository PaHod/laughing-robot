package AsyncChat;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PaHod on 18.09.2014.
 */
public class ListenerConnect implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
//        try {
//            socket = new Socket(ipAdressFld.getText(), Integer.valueOf(portFld.getText()));
//            chatArea.append("This is Client!" + '\n');
//            frame.setTitle("AsyncChat Client");
//            chatArea.append("Connected to Server: ip: " + socket.getLocalAddress() + ", port: "
//                    + socket.getLocalPort() + '\n');
//        } catch (IOException e1) {
//            chatArea.append("This is the Server." + '\n');
//            frame.setTitle("AsyncChat Server");
//            chatArea.append("Waits for connect from Client..." + '\n');
//            try {
//                ServerSocket serverSocket = new ServerSocket(Integer.valueOf(portFld.getText()));
//                socket = serverSocket.accept();
//                chatArea.append("Connected to Server: ip: " + socket.getLocalAddress() + ", port: "
//                        + socket.getLocalPort() + '\n');
//            } catch (IOException e2) {
//                chatArea.append("Open port error " + '\n');
//            }
//        }
//        if (socket != null) {
//            try {
//                printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//                socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//
//        }
    }
}
