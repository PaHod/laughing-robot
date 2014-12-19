package AsyncChat;

import java.io.IOException;

/**
 * Created by PaHod on 14.09.2014.
 */
public class ReceiveThread extends Thread {
    private ChatFrame chatFrame;

    public ReceiveThread() {
    }

    public ReceiveThread(ChatFrame chatFrame) {
        this.chatFrame = chatFrame;
    }

    @Override
    public void run() {

        while(chatFrame.getSocket()!=null){
            try {
                chatFrame.getChatArea().append("OtherName: " + chatFrame.getSocketReader().readLine() + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }

            chatFrame.getFrame().setVisible(true);

        }

    }
}
