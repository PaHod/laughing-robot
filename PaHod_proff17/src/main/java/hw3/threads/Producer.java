package hw3.threads;

/**
 * Created by PaHod on 22.05.2014.
 */
public class Producer extends Thread {
    @Override
    public void run() {


        while (!isInterrupted()) {

            if (Holder.checkRecived) {

                Holder.cell = (int) (Math.random() * 1000);
                Holder.checkRecived = false;

            }
        }


    }
}
