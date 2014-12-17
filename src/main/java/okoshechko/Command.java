package okoshechko;


import javax.swing.*;

public class Command implements Runnable {

    private JLabel componentToUpdate;

    public Command(JLabel component) {
        componentToUpdate = component;
    }

    @Override
    public void run() {
        for (int cnt = 0; cnt < 10; cnt++) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            try {
                Thread.currentThread().sleep(1000);
                componentToUpdate.setText("cnt: " + cnt);
            } catch (InterruptedException e) {
                return;
            }

        }
    }
}
