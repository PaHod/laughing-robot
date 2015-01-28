package okoshechko;


import javax.swing.*;
import java.awt.*;

public class Okoshechko extends JFrame {

    private StartBtn startBtn;
    private StopBtn stopBtn;
    private OutputField outputField;

    private JPanel mainPanel;



    public Okoshechko() {
        super();
        startBtn = new StartBtn();
        stopBtn = new StopBtn();
        outputField = new OutputField();
        mainPanel = new JPanel();

        mainPanel.add(startBtn, BorderLayout.CENTER);
        mainPanel.add(stopBtn, BorderLayout.CENTER);
        mainPanel.add(outputField, BorderLayout.CENTER);


        setTitle("Counter frame");
        setBounds(400, 400, 300, 100);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public StartBtn getStartBtn() {
        return startBtn;
    }

    public StopBtn getStopBtn() {
        return stopBtn;
    }

    public OutputField getOutputField() {
        return outputField;
    }
}
