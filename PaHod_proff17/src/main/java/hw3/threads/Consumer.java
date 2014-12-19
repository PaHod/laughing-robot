package hw3.threads;


/**
 * Created by PaHod on 22.05.2014.
 * Один поток генерирует числа второй выводит на экран используя промежуточное хранилище.

 * Классы задания:

 * hw3.threads.Producer
 * hw3.threads.Consumer
 * hw3.threads.Holder
 */
public class Consumer extends Thread {

    @Override
    public void run() {


        while (!isInterrupted()) {

            if (!Holder.checkRecived) {
                System.out.println(Holder.cell);

                Holder.checkRecived = true;

                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    interrupt();
                }
            }
        }

    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
          //  interrupt();
        }
        producer.interrupt();
        consumer.interrupt();
    }
}
