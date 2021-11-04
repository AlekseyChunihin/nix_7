package ua.com.alevel.prime_number_counter;

import java.util.ArrayList;

public class ArrayListForMultithreading {

    ArrayList<Integer> numbers;
    public int countPrimeNumbers = 0;

    public ArrayListForMultithreading(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getCountPrimeNumbers() {
        return countPrimeNumbers;
    }

    public void setCountPrimeNumbers(int countPrimeNumbers) {
        this.countPrimeNumbers = countPrimeNumbers;
    }
}