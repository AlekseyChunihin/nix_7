package ua.com.alevel.reverse_print_order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberPrinterThread implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(NumberPrinterThread.class);

    private static int threadCounter = 1;
    private static final int THREADS_COUNT = 49;

    @Override
    public void run() {
        Thread.currentThread().setName("thread " + threadCounter);
        if (threadCounter <= THREADS_COUNT) {
            Thread reverse = new Thread(new NumberPrinterThread());
            reverse.setName("Thread " + threadCounter);
            threadCounter++;
            reverse.start();
            try {
                reverse.join();
            } catch (InterruptedException e) {
                log.error("Thread {} was interrupted", threadCounter);
                throw new RuntimeException(e);
            }
        }
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
