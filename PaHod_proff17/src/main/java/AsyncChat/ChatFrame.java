package AsyncChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by PaHod on 18.09.2014.
 */
public class ChatFrame extends JFrame {
    private ChatFrame chatFrame;
    private JFrame frame;
    private JTextField ipAdressFld;
    private JTextField portFld;
    private JButton connectBtn;
    private JTextArea chatArea;
    private JTextArea messageArea;
    private JButton sendBtn;
    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader socketReader;
    private ReceiveThread receiveThread ;


    public ChatFrame(){

    }
    public ChatFrame(String title){
        initComponents(title);
        frame.setVisible(true);
        System.out.println("frame create and visible");
        initActionListeners();
        chatFrame=this;
    }

    private void initComponents(String title) {
        frame = new JFrame(title);
        frame.setLayout(new FlowLayout());
        frame.setBounds(600, 300, 550, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ipAdressFld = new JTextField("localhost");
        ipAdressFld.setPreferredSize(new Dimension(100, 25));
        portFld = new JTextField("1122");
        portFld.setPreferredSize(new Dimension(70, 25));
        connectBtn = new JButton("Connect");
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setPreferredSize(new Dimension(500, 100));
        messageArea = new JTextArea();
        messageArea.setPreferredSize(new Dimension(500, 60));
        sendBtn = new JButton("Send");
        sendBtn.setEnabled(false);
        frame.add(new JLabel("IP Adress: "));
        frame.add(ipAdressFld);
        frame.add(new JLabel("Port:"));
        frame.add(portFld);
        frame.add(connectBtn);
        frame.add(chatArea);
        frame.add(new JLabel("Your message:"));
        frame.add(messageArea);
        frame.add(sendBtn);

    }
    private void initActionListeners() {
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    socket = new Socket(ipAdressFld.getText(), Integer.valueOf(portFld.getText()));
                    chatArea.append("This is Client!" + '\n');
                    frame.setTitle("AsyncChat Client");
                    chatArea.append("Connected to Server: ip: " + socket.getLocalAddress() + ", port: "
                            + socket.getLocalPort() + '\n');
                } catch (IOException e1) {
                    chatArea.append("This is the Server." + '\n');
                    frame.setTitle("AsyncChat Server");
                    chatArea.append("Waits for connect from Client..." + '\n');
//                  chatArea.setVisible(true);
//                    frame.setVisible(true);
                    try {
                        ServerSocket serverSocket = new ServerSocket(Integer.valueOf(portFld.getText()));
                        socket = serverSocket.accept();
                        chatArea.append("Connected to Server: ip: " + socket.getLocalAddress() + ", port: "
                                + socket.getLocalPort() + '\n');
                    } catch (IOException e2) {
                        chatArea.append("Open port error " + '\n');
                    }
                }
                if (socket != null) {
                    try {
                        printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                        socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
                connectBtn.setEnabled(false);
                sendBtn.setEnabled(true);
                receiveThread = new ReceiveThread(chatFrame);
                receiveThread.start();


            }
        });

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                chatArea.append("myName: " + messageArea.getText() + '\n');
                printWriter.println(messageArea.getText());
                printWriter.flush();
                messageArea.setText("");
            }

        });

    }

    public Socket getSocket() {
        return socket;
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    public BufferedReader getSocketReader() {
        return socketReader;
    }

    public JFrame getFrame() {
        return frame;
    }


//
//    public JTextField getPortFld() {
//        return portFld;
//    }
//
//    public void setPortFld(JTextField portFld) {
//        this.portFld = portFld;
//    }
//
//    public JTextField getIpAdressFld() {
//        return ipAdressFld;
//    }
//
//    public void setIpAdressFld(JTextField ipAdressFld) {
//        this.ipAdressFld = ipAdressFld;
//    }
//

}
