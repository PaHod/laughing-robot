package okoshechko;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkoshechkoApp {
    public static void main(String[] args) {
        final Okoshechko ok = new Okoshechko();
        final Thread commandThread = new Thread(new Command(ok.getOutputField()));

        final StartBtn startbtn = ok.getStartBtn();
        final StopBtn stopbtn = ok.getStopBtn();

        startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandThread.start();
                startbtn.setEnabled(false);
            }
        });

        stopbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandThread.interrupt();
                stopbtn.setEnabled(false);
            }
        });
    }
}
