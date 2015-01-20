package producerconsumer;

import java.util.Scanner;

public class Programm {

    public static void main(String[] args) {
        Storage storage = new Storage();


        Thread producerT = new Thread(new Producer(storage));
        Thread consumerT = new Thread(new Consumer(storage));

        producerT.start();
        consumerT.start();

        Scanner scanner = new Scanner(System.in);
        while (!scanner.nextLine().equals("exit")) {

        }
        producerT.interrupt();
        consumerT.interrupt();
    }
}
