package session07;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.05.14
 */
public class Printer {
    public synchronized void print(String message) {
//        try {
            System.out.print('[');
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(message);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(']');
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
