package ua.com.alevel.prime_number_counter;

public class PrimeNumberCounterThread extends Thread {

    private final ArrayListForMultithreading numbers;
    private final int startPosition;
    private final int endPosition;

    public PrimeNumberCounterThread(ArrayListForMultithreading numbers, int startPosition, int endPosition) {
        this.numbers = numbers;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    @Override
    public void run() {
        synchronized (numbers) {
            for (int i = startPosition; i < endPosition; i++) {
                if (isPrime(numbers.getNumbers().get(i))) {
                    System.out.println("found prime number: " + numbers.getNumbers().get(i) + ", current Thread that found number: " + Thread.currentThread().getName());
                    numbers.countPrimeNumbers++;
                }
            }
        }
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
