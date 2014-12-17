package producerconsumer;

public class Consumer implements Runnable {

    private Storage storage;

    public Consumer(final Storage storage) {
        this.storage = storage;
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
                if (storage.getSize() > 0) {
                    System.out.println(storage.getData());
                }
            } else {
                return;
            }
        }
    }
}
