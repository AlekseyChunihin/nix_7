package ua.com.alevel;

import ua.com.alevel.reverse_print_order.NumberPrinterThread;

public class Main {

    public static void main(String[] args) {
        Thread t2 = new Thread(new NumberPrinterThread());
        t2.start();


    }
}
