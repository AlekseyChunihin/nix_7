package ua.com.alevel.entity;

public class MathSet<T extends Number & Comparable<T>> {

    private T[] numbers;
    private int current;
    private int capacity = 10;

    public MathSet() {
        numbers = (T[]) new Number[capacity];
        current = 0;
    }

    public MathSet(int capacity) {
        this.capacity = capacity;
        numbers = (T[]) new Number[capacity];
        current = 0;
    }

    public MathSet(T[] elements) {
        capacity += elements.length;
        numbers = (T[]) new Number[capacity];
        current = elements.length;
        for (int i = 0; i < current; i++) {
            numbers[i] = elements[i];
        }
        deleteDuplicates();
    }

    @SafeVarargs
    public MathSet(T[]... elements) {
        int totalLength = 0;
        for (int i = 0; i < elements.length; i++) {
            totalLength = totalLength + elements[i].length;
        }
        current = totalLength;
        capacity += totalLength;
        numbers = (T[]) new Number[capacity];
        int k = 0;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                numbers[k] = elements[i][j];
                k++;
            }
        }
        deleteDuplicates();
    }

    public MathSet(MathSet elements) {
        capacity = elements.getCapacity();
        current = elements.getSize();
        numbers = (T[]) new Number[capacity];
        for (int i = 0; i < elements.getSize(); i++) {
            numbers[i] = (T) elements.get(i);
        }
    }

    public MathSet(MathSet... elements) {
        int totalLength = 0;
        for (int i = 0; i < elements.length; i++) {
            totalLength = totalLength + elements[i].getSize();
        }
        current = totalLength;
        capacity = capacity + totalLength;
        numbers = (T[]) new Number[capacity];
        int k = 0;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].getSize(); j++) {
                numbers[k] = (T) elements[i].get(j);
                k++;
            }
        }
        deleteDuplicates();
    }

    public void add(T number) {
        if (current == capacity - 1) {
            capacity = capacity * 2;
            T[] newNumbers = (T[]) new Number[capacity];
            for (int i = 0; i < numbers.length; i++) {
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        if (!isDuplicate(number)) {
            numbers[current] = number;
            current++;
        }
    }

    public void add(T... number) {
        if (number.length >= capacity - current) {
            capacity = capacity * 2 + number.length;
            T[] newNumbers = (T[]) new Number[capacity];
            for (int i = 0; i < numbers.length; i++) {
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        for (int i = 0; i < number.length; i++) {
            add(number[i]);
        }
    }

    public void deleteDuplicates() {
        for (int i = 0; i < current; i++)
            for (int j = 0; j < current; j++)
                if (i != j) {
                    if (numbers[i].equals(numbers[j])) {
                        for (int k = j; k < current; k++)
                            numbers[k] = numbers[k + 1];
                        current--;
                    }
                }
    }

    public boolean isDuplicate(T number) {
        for (int i = 0; i < current; i++)
            if (numbers[i].equals(number)) {
                return true;
            }
        return false;
    }

    public void join(MathSet ms) {
        if (ms.getSize() >= capacity - current) {
            capacity = capacity * 2 + ms.getSize();
            T[] newNumbers = (T[]) new Number[capacity];
            for (int i = 0; i < numbers.length; i++) {
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        for (int i = 0; i < ms.getSize(); i++) {
            numbers[current] = (T) ms.get(i);
            current++;
        }
        deleteDuplicates();
        sortAsc();
    }

    public void join(MathSet... ms) {
        int totalLength = 0;
        for (MathSet m : ms) {
            totalLength = totalLength + m.getSize();
        }
        if (totalLength >= capacity - current) {
            capacity = capacity * 2 + totalLength;
            T[] newNumbers = (T[]) new Number[capacity];
            for (int i = 0; i < numbers.length; i++) {
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        for (int i = 0; i < ms.length; i++) {
            for (int j = 0; j < ms[i].getSize(); j++) {
                numbers[current] = (T) ms[i].get(j);
                current++;
            }
        }
        deleteDuplicates();
        sortAsc();
    }

    public void intersection(MathSet ms) {
        if (ms.getSize() >= capacity - current) {
            capacity = capacity * 2 + ms.getSize();
            T[] newNumbers = (T[]) new Number[capacity];
            for (int i = 0; i < numbers.length; i++) {
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        T[] intersectionNumbers = (T[]) new Number[capacity];
        int k = 0;
        for (int i = 0; i < current; i++) {
            for (int j = 0; j < ms.getSize(); j++) {
                if (numbers[i].equals(ms.get(j))) {
                    intersectionNumbers[k] = numbers[i];
                    k++;
                    break;
                }
            }
        }
        numbers = intersectionNumbers;
        current = k;
    }

    public void intersection(MathSet... ms) {
        for (int i = 0; i < ms.length; i++) {
            intersection(ms[i]);
        }
    }

    public T getMax() {
        T maxNumber = numbers[0];
        for (int i = 0; i < current; i++) {
            if (numbers[i].compareTo(maxNumber) > 0) {
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }

    public T getMin() {
        T maxNumber = numbers[0];
        for (int i = 0; i < current; i++) {
            if (numbers[i].compareTo(maxNumber) < 0) {
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }

    public void sortAsc() {
        int in, out;
        T tmp;
        for (out = 1; out < current; out++) {
            tmp = numbers[out];
            in = out;
            while (in > 0 && (numbers[in - 1].compareTo(tmp)) >= 0) {
                numbers[in] = numbers[in - 1];
                --in;
            }
            numbers[in] = tmp;
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if (firstIndex >= current || lastIndex >= current || firstIndex < 0 || lastIndex < 0 || firstIndex > lastIndex) {
            System.out.println("Incorrect indexes");
        } else {
            int in, out;
            T tmp;
            for (out = firstIndex; out <= lastIndex; out++) {
                tmp = numbers[out];
                in = out;
                while (in > firstIndex && (numbers[in - 1].compareTo(tmp)) >= 0) {
                    numbers[in] = numbers[in - 1];
                    --in;
                }
                numbers[in] = tmp;
            }
        }
    }

    public void sortAsc(T value) {
        int index = contains(value);
        if (index == -1) {
            System.out.println("MathSet does not contains this value");
        } else {
            int in, out;
            T tmp;
            for (out = index + 1; out < current; out++) {
                tmp = numbers[out];
                in = out;
                while (in > index && (numbers[in - 1].compareTo(tmp)) >= 0) {
                    numbers[in] = numbers[in - 1];
                    --in;
                }
                numbers[in] = tmp;
            }
        }
    }

    public void sortDesc() {
        int in, out;
        T tmp;
        for (out = 1; out < current; out++) {
            tmp = numbers[out];
            in = out;
            while (in > 0 && (numbers[in - 1].compareTo(tmp)) <= 0) {
                numbers[in] = numbers[in - 1];
                --in;
            }
            numbers[in] = tmp;
        }
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if (firstIndex >= current || lastIndex >= current || firstIndex < 0 || lastIndex < 0 || firstIndex > lastIndex) {
            System.out.println("Incorrect indexes");
        } else {
            int in, out;
            T tmp;
            for (out = firstIndex; out <= lastIndex; out++) {
                tmp = numbers[out];
                in = out;
                while (in > firstIndex && (numbers[in - 1].compareTo(tmp)) <= 0) {
                    numbers[in] = numbers[in - 1];
                    --in;
                }
                numbers[in] = tmp;
            }
        }
    }

    public void sortDesc(T value) {
        int index = contains(value);
        if (index == -1) {
            System.out.println("MathSet does not contains this value");
        } else {
            int in, out;
            T tmp;
            for (out = index + 1; out < current; out++) {
                tmp = numbers[out];
                in = out;
                while (in > index && (numbers[in - 1].compareTo(tmp)) <= 0) {
                    numbers[in] = numbers[in - 1];
                    --in;
                }
                numbers[in] = tmp;
            }
        }
    }

    public Double getAverage() {
        Double sumNumbers = 0.0;
        Double amountNumbers = 0.0;
        for (int i = 0; i < current; i++) {
            sumNumbers += (double) numbers[i].intValue();
            amountNumbers++;
        }
        return sumNumbers / amountNumbers;
    }

    public Integer getMedian() {
        sortAsc();
        if (current % 2 == 0) {
            return ((Integer) numbers[(current / 2) - 1] + (Integer) numbers[current / 2]) / 2;
        } else {
            return (Integer) numbers[current / 2];
        }
    }

    public Number[] toArray() {
        T[] numbersArray = (T[]) new Number[current];
        for (int i = 0; i < current; i++) {
            numbersArray[i] = numbers[i];
        }
        return numbersArray;
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        T[] numbersArray = (T[]) new Number[0];
        if (firstIndex >= current || lastIndex >= current || firstIndex < 0 || lastIndex < 0 || firstIndex > lastIndex) {
            return numbersArray;
        } else {
            numbersArray = (T[]) new Number[lastIndex - firstIndex];
            for (int i = firstIndex, k = 0; i < lastIndex; i++, k++) {
                numbersArray[k] = numbers[i];
            }
        }
        return numbersArray;
    }

    public MathSet cut(int firstIndex, int lastIndex) {
        MathSet truncatedMathSet = new MathSet();
        if (firstIndex >= current || lastIndex >= current || firstIndex < 0 || lastIndex < 0 || firstIndex > lastIndex) {
            return truncatedMathSet;
        } else {
            truncatedMathSet = new MathSet(capacity);
            for (int i = firstIndex; i <= lastIndex; i++) {
                truncatedMathSet.add(numbers[i]);
            }
        }
        return truncatedMathSet;
    }

    public void clear() {
        capacity = 10;
        numbers = (T[]) new Number[capacity];
        current = 0;
    }

    public void clear(T[] elements) {
        for (int i = 0; i < current; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (numbers[i].equals(elements[j])) {
                    delete(numbers[i]);
                }
            }
        }
    }

    public void delete(T elem) {
        int i;
        for (i = 0; i < current; i++) {
            if (numbers[i].equals(elem)) {
                break;
            }
        }
        for (int j = i; j < current; j++) {
            numbers[j] = numbers[j + 1];
        }
        current--;
    }

    public void print() {
        for (int i = 0; i < current; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return current == 0;
    }

    public int contains(T value) {
        for (int i = 0; i < current; i++) {
            if (numbers[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int i) {
        return numbers[i];
    }

    public int getSize() {
        return current;
    }

    public int getCapacity() {
        return capacity;
    }
}
