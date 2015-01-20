package producerconsumer;


import java.util.Random;

public class Producer implements Runnable {

    private Storage storage;
    private Random rand;

    public Producer(final Storage storage) {
        this.storage = storage;
        rand = new Random();
    }

    @Override
    public void run() {

        while(true) {
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                return;
            }
            if (!Thread.currentThread().isInterrupted()) {
                if (storage.getSize() < 10) {
                    storage.putData(rand.nextInt(100));
                }
            } else {
                return;
            }
        }
    }
}
