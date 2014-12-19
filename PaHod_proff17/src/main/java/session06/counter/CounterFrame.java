package session06.counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PaHod on 20.05.2014.
 */
public class CounterFrame extends JFrame {
    private JTextField counterFld;
    private JButton startBtn;
    private JButton stopBtn;
    private JButton pauseBtn;
    private ThreadCounter stTH = new ThreadCounter();
    private boolean flag = true;


    public CounterFrame(String title) {
        setTitle(title);
        setLayout(new FlowLayout());
        setBounds(500, 200, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

        private void initComponents() {
            counterFld = new JTextField();
            counterFld.setPreferredSize(new Dimension(100, 40));
            startBtn = new JButton("Start");
            stopBtn = new JButton("Stop");
            pauseBtn = new JButton("Pause");
            add(counterFld);
            add(startBtn);
            add(pauseBtn);
            add(stopBtn);


            startBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    stTH.start();
                    startBtn.setEnabled(false);
                }

            });
            pauseBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flag) {
                        flag = false;
                        pauseBtn.setText("Skip");
                    } else {
                        flag = true;
                        synchronized (counterFld) {
                            counterFld.notify();
                        }
                        pauseBtn.setText("Pause");
                    }

                }

            });
            stopBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    stTH.interrupt();
                    stopBtn.setEnabled(false);
                    pauseBtn.setEnabled(false);
                }
            });


        }

    class ThreadCounter extends Thread {
        int val = 1;

        @Override
        public void run() {

            while (!isInterrupted()) {
                if (this.isInterrupted()) return;
                synchronized (counterFld) {
                    while (!flag) {
                        try {
                            counterFld.wait(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                counterFld.setText(String.valueOf(val++));
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    interrupt();
                }
            }

        }

    }


    public static void main(String[] args) {
        new CounterFrame("Counter");
    }
}
