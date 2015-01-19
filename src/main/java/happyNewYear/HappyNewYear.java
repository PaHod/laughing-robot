package happyNewYear;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;

/**
 * Created by PaHod on 31.12.2014.
 */
public class HappyNewYear extends JPanel {
    public JFrame frame;
    public Image fon;
//    public AudioClip whenImSixtyFour;

    public HappyNewYear() {
    this.frame = new JFrame("С Новым Годом");
        frame.setLayout(new FlowLayout());
        frame.setBounds(100, 100, 1100, 600);
        frame.setVisible(true);
        JPanel jPanel = new JPanel();
//playBeathles();

    }
/*
public void playBeathles(){


    whenImSixtyFour.play();

}*/

    public static void main(String[] args) {
HappyNewYear happyNewYear = new HappyNewYear();
    }
}
