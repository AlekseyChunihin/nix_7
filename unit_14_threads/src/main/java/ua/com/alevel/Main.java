package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.prime_number_counter.ArrayListForMultithreading;
import ua.com.alevel.prime_number_counter.PrimeNumberCounterThread;
import ua.com.alevel.reverse_print_order.NumberPrinterThread;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the task:");
        System.out.println("1 - Task 1");
        System.out.println("2 - Task 2");
        String taskChoice = scanner.nextLine();
        switch (taskChoice) {
            case "1": {
                Thread t2 = new Thread(new NumberPrinterThread());
                t2.start();
            }
            break;
            case "2": {
                ArrayList<Integer> numbers = fill();
                ArrayListForMultithreading list = new ArrayListForMultithreading(numbers);
                PrimeNumberCounterThread thread1 = new PrimeNumberCounterThread(list, 0, list.getNumbers().size() / 2);
                PrimeNumberCounterThread thread2 = new PrimeNumberCounterThread(list, list.getNumbers().size() / 2, list.getNumbers().size());
                thread1.start();
                thread2.start();
                try {
                    thread1.join();
                    thread2.join();
                    System.out.println("Total amount of prime numbers: " + list.getCountPrimeNumbers());
                } catch (InterruptedException e) {
                    log.error("Thread was interrupted");
                    throw new RuntimeException(e);
                }
            }
            break;
            default:
                System.out.println("You entered an incorrect value");
        }
    }

    public static ArrayList<Integer> fill() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
