package session07;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.05.14
 */
public class NumberProducer extends Thread {
    static Printer printer;

    public NumberProducer(Printer printer){
        this.printer = printer;
    }
    @Override
    public void run() {

        for (int i = 0; i < 200; i++) {
            String name = Thread.currentThread().getName();
            synchronized (printer) {
                this.printer.print(name + " " + i);
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        printer = new Printer();
        NumberProducer numberProducer1 = new NumberProducer(printer);
        NumberProducer numberProducer2 = new NumberProducer(printer);

        numberProducer1.start();
        numberProducer2.start();

    }
}
