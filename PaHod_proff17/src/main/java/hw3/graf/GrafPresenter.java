package hw3.graf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PaHod on 22.05.2014.
 * Пользователь выбирает график функции (x*x, sin(x), x). Построить график выбранной функции звездочками в консоле, на промежутке 0-5.
 * Плавно строить график заданной функции пока пользователь не нажмет ентер.
 * <p/>
 * Класс задания:
 * hw3.graf.GrafPresenter
 */
public class GrafPresenter extends Thread {


    public static void main(String[] args) {
      //  GrafFrame frame = new GrafFrame();

        System.out.println("---------------------");
        grafBuilder(1, 0, 10);
        System.out.println("---------------------");
        grafBuilder(2, 0, 4);
        System.out.println("---------------------");
        grafBuilder(3, 0, 10);

    }

    public static void grafBuilder(int chooseFunc, double minX, double maxX  ) {
        double x = 0;
        double y = 0;
        while (x <= maxX) {
            for (x = minX; x <= maxX; x += 0.2) {
                if (chooseFunc == 1) {
                    y = Math.sin(x);
                } else if (chooseFunc == 2) {
                    y = Math.pow(x, 2);
                } else if (chooseFunc == 3) {
                    y = x;
                }
                for (double i = -1; i <= y; i += 0.1) {
                    System.out.print(" ");
                }
                System.out.println("*");

            }
        }
    }

}
