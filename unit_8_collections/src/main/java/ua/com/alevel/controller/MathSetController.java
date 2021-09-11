package ua.com.alevel.controller;

import ua.com.alevel.entity.MathSet;

import java.util.Scanner;

public class MathSetController {

    Scanner scanChoice = new Scanner(System.in);
    MathSet mathSet;

    public void start() {
        menu();
    }

    public void menu() {
        mathSetCreationSelectionMenu();
        Scanner mainMenuChoice = new Scanner(System.in);
        while (true) {
            Scanner scanValue = new Scanner(System.in);
            printMenuText();
            String choice2 = mainMenuChoice.nextLine();
            switch (choice2) {
                case "1": {
                    System.out.println("Enter a number");
                    while (!scanValue.hasNextInt()) {
                        System.out.println("You have entered incorrect value, try again");
                        scanValue.next();
                    }
                    Integer number = scanValue.nextInt();
                    mathSet.add(number);
                    mathSet.print();
                }
                break;
                case "2": {
                    System.out.println("Enter how many numbers you want to add:");
                    int size = getSize();
                    Integer[] numbers = new Integer[size];
                    System.out.println("Enter numbers:");
                    for (int i = 0; i < numbers.length; i++) {
                        while (!scanValue.hasNextInt()) {
                            System.out.println("You have entered incorrect value, try again");
                            scanValue.next();
                        }
                        numbers[i] = scanValue.nextInt();
                    }
                    mathSet.add(numbers);
                    mathSet.print();
                }
                break;
                case "3": {
                    MathSet mathSet1 = new MathSet<Integer>();
                    System.out.println("Enter size of MathSet");
                    int size = getSize();
                    System.out.println("Enter elements of MathSet");
                    Integer[] numbers = new Integer[size];
                    for (int i = 0; i < numbers.length; i++) {
                        while (!scanValue.hasNextInt()) {
                            System.out.println("You have entered incorrect value, try again");
                            scanValue.next();
                        }
                        numbers[i] = scanValue.nextInt();
                    }
                    mathSet1.add(numbers);
                    mathSet.join(mathSet1);
                    mathSet.print();
                }
                break;
                case "4": {
                    System.out.println("Enter how many MathSets you want to create:");
                    int size = getSize();
                    MathSet[] mathSets = createArrayOfMathSets(size);
                    mathSet.join(mathSets);
                    mathSet.print();
                }
                break;
                case "5": {
                    System.out.println("Enter MathSet for intersection:");
                    MathSet mathSetForIntersection = createMathSet();
                    mathSet.intersection(mathSetForIntersection);
                    System.out.print("Intersection is: ");
                    if (mathSet.isEmpty()) System.out.println("empty");
                    else {
                        mathSet.print();
                    }
                }
                break;
                case "6": {
                    System.out.println("Enter how many MathSets you want to create for intersection:");
                    int size = getSize();
                    MathSet[] mathSets = createArrayOfMathSets(size);
                    mathSet.intersection(mathSets);
                    System.out.print("Intersection is: ");
                    if (mathSet.isEmpty()) System.out.println("empty");
                    else {
                        mathSet.print();
                    }
                }
                break;
                case "7": {
                    mathSet.sortDesc();
                    mathSet.print();
                }
                break;
                case "8": {
                    int firstIndex, lastIndex;
                    System.out.println("enter first index");
                    while (!scanValue.hasNextInt()) {
                        System.out.println("You have entered incorrect value, try again");
                        scanValue.next();
                    }
                    firstIndex = scanValue.nextInt();
                    System.out.println("enter last index");
                    while (!scanValue.hasNextInt()) {
                        System.out.println("You have entered incorrect value, try again");
                        scanValue.next();
                    }
                    lastIndex = scanValue.nextInt();
                    mathSet.sortDesc(firstIndex, lastIndex);
                    mathSet.print();
                }
                break;
                case "9": {
                    Integer value;
                    System.out.println("enter value");
                    while (!scanValue.hasNextInt()) {
                        System.out.println("You have entered incorrect value, try again");
                        scanValue.next();
                    }
                    value = scanValue.nextInt();
                    mathSet.sortDesc(value);
                    mathSet.print();
                }
                break;
                case "10": {
                    mathSet.sortAsc();
                    mathSet.print();
                }
                break;
                case "11": {
                    int firstIndex, lastIndex;
                    System.out.println("enter first index");
                    while (!scanValue.hasNextInt()) {
                        System.out.println("You have entered incorrect value, try again");
                        scanValue.next();
                    }
                    firstIndex = scanValue.nextInt();
                    System.out.println("enter last index");
                    while (!scanValue.hasNextInt()) {
                        System.out.println("You have entered incorrect value, try again");
                        scanValue.next();
                    }
                    lastIndex = scanValue.nextInt();
                    mathSet.sortAsc(firstIndex, lastIndex);
                    mathSet.print();
                }
                break;
                case "12": {
                    Integer value;
                    System.out.println("enter value");
                    while (!scanValue.hasNextInt()) {
                        System.out.println("You have entered incorrect value, try again");
                        scanValue.next();
                    }
                    value = scanValue.nextInt();
                    mathSet.sortAsc(value);
                    mathSet.print();
                }
                break;
                case "13": {
                    if (mathSet.isEmpty()) {
                        System.out.println("MathSet is empty");
                    } else {
                        mathSet.print();
                    }
                    System.out.println("mathSet size:" + mathSet.getSize() + "\n" + "mathSet capacity:" + mathSet.getCapacity());
                }
                break;
                case "14": {
                    if (!mathSet.isEmpty()) {
                        Number maxValue = mathSet.getMax();
                        System.out.println(maxValue);
                    } else {
                        System.out.println("MathSet is empty");
                    }
                }
                break;
                case "15": {
                    if (!mathSet.isEmpty()) {
                        Number minValue = mathSet.getMin();
                        System.out.println(minValue);
                    } else {
                        System.out.println("MathSet is empty");
                    }
                }
                break;
                case "16": {
                    if (!mathSet.isEmpty()) {
                        Number average = mathSet.getAverage();
                        System.out.println(average);
                    } else {
                        System.out.println("MathSet is empty");
                    }
                }
                break;
                case "17": {
                    if (!mathSet.isEmpty()) {
                        Number median = mathSet.getMedian();
                        System.out.println(median);
                    } else {
                        System.out.println("MathSet is empty");
                    }
                }
                break;
                case "18": {
                    if (!mathSet.isEmpty()) {
                        Number[] numbers = mathSet.toArray();
                        System.out.println("Array:");
                        for (Number number : numbers) {
                            System.out.print(number + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("MathSet is empty");
                    }
                }
                break;
                case "19": {
                    if (!mathSet.isEmpty()) {
                        int firstIndex, lastIndex;
                        System.out.println("enter first index");
                        while (!scanValue.hasNextInt()) {
                            System.out.println("You have entered incorrect value, try again");
                            scanValue.next();
                        }
                        firstIndex = scanValue.nextInt();
                        System.out.println("enter last index");
                        while (!scanValue.hasNextInt()) {
                            System.out.println("You have entered incorrect value, try again");
                            scanValue.next();
                        }
                        lastIndex = scanValue.nextInt();
                        Number[] numbers = mathSet.toArray(firstIndex, lastIndex);
                        if (numbers.length == 0) {
                            System.out.println("Incorrect indexes");
                        } else {
                            System.out.println("Array:");
                            for (Number number : numbers) {
                                System.out.print(number + " ");
                            }
                            System.out.println();
                        }
                    }
                }
                break;
                case "20": {
                    if (!mathSet.isEmpty()) {
                        int firstIndex, lastIndex;
                        System.out.println("enter first index");
                        while (!scanValue.hasNextInt()) {
                            System.out.println("You have entered incorrect value, try again");
                            scanValue.next();
                        }
                        firstIndex = scanValue.nextInt();
                        System.out.println("enter last index");
                        while (!scanValue.hasNextInt()) {
                            System.out.println("You have entered incorrect value, try again");
                            scanValue.next();
                        }
                        lastIndex = scanValue.nextInt();
                        MathSet truncatedMathSet = mathSet.cut(firstIndex, lastIndex);
                        if (truncatedMathSet.getSize() == 0) {
                            System.out.println("Incorrect indexes");
                        } else {
                            System.out.println("Truncated MathSet:");
                            truncatedMathSet.print();
                        }
                    }
                }
                break;
                case "21": {
                    mathSet.clear();
                    mathSet.print();
                }
                break;
                case "22": {
                    System.out.println("Enter how many numbers you want to clear");
                    int size = getSize();
                    System.out.println("Enter elements to clear from MathSet");
                    Integer[] numbers = new Integer[size];
                    for (int i = 0; i < numbers.length; i++) {
                        while (!scanValue.hasNextInt()) {
                            System.out.println("You have entered incorrect value, try again");
                            scanValue.next();
                        }
                        numbers[i] = scanValue.nextInt();
                    }
                    mathSet.clear(numbers);
                    mathSet.print();
                }
                break;
                case "23": {
                    int index;
                    System.out.println("enter index");
                    while (!scanValue.hasNextInt()) {
                        System.out.println("You have entered incorrect value, try again");
                        scanValue.next();
                    }
                    index = scanValue.nextInt();
                    if (index >= 0 && index < mathSet.getSize()) {
                        System.out.println(mathSet.get(index));
                    } else {
                        System.out.println("incorrect index");
                    }
                }
                break;
                case "0": {
                    return;
                }
                default:
                    System.out.println("You entered an invalid value. Enter again please");
                    break;
            }
        }
    }

    private void printMenuText() {
        System.out.println("\t\t\t\t\t\tMenu");
        System.out.println("Please, choose what you want to do(press the corresponding number):");
        System.out.println("\t1 - add(Number n)");
        System.out.println("\t2 - add(Number ... n)");
        System.out.println("\t3 - join(MathSet ms)");
        System.out.println("\t4 - join(MathSet ... ms)");
        System.out.println("\t5 - intersection(MathSet ms)");
        System.out.println("\t6 - intersection (MathSet ... ms)");
        System.out.println("\t7 - sortDesc()");
        System.out.println("\t8 - sortDesc(int firstIndex, int lastIndex)");
        System.out.println("\t9 - sortDesc(Number value)");
        System.out.println("\t10 - sortAsc()");
        System.out.println("\t11 - sortAsc(int firstIndex, int lastIndex)");
        System.out.println("\t12 - sortAsc(Number value)");
        System.out.println("\t13 - printMathSet()");
        System.out.println("\t14 - getMax()");
        System.out.println("\t15 - getMin()");
        System.out.println("\t16 - getAverage()");
        System.out.println("\t17 - getMedian()");
        System.out.println("\t18 - toArray()");
        System.out.println("\t19 - toArray(int firstIndex, int lastIndex)");
        System.out.println("\t20 - cut(int firstIndex, int lastIndex)");
        System.out.println("\t21 - clear()");
        System.out.println("\t22 - clear(Number[] numbers)");
        System.out.println("\t23 - get(int index)");
        System.out.println("\t0 - exit");
    }

    public void mathSetCreationSelectionMenu() {
        System.out.println("Choose how do you want to create MathSet?:(default create MathSet())");
        System.out.println("\t1 - create MathSet()");
        System.out.println("\t2 - create MathSet(int capacity)");
        System.out.println("\t3 - create MathSet(Number[] numbers)");
        System.out.println("\t4 - create MathSet(Number[] ... numbers)");
        System.out.println("\t5 - create MathSet(MathSet numbers)");
        System.out.println("\t6 - create MathSet(MathSet ... numbers)");
        String choice = scanChoice.nextLine();
        switch (choice) {
            case "1": {
                mathSet = new MathSet<Integer>();
            }
            break;
            case "2": {
                System.out.println("Enter capacity");
                int capacity = getSize();
                mathSet = new MathSet<>(capacity);
                System.out.println("mathSet size:" + mathSet.getSize() + "\n" + "mathSet capacity:" + mathSet.getCapacity());
            }
            break;
            case "3": {
                System.out.println("Enter size of array");
                Integer[] elements = createArrayForMathSet();
                mathSet = new MathSet<>(elements);
                mathSet.print();
                System.out.println("mathSet size:" + mathSet.getSize() + "\n" + "mathSet capacity:" + mathSet.getCapacity());
            }
            break;
            case "4": {
                System.out.println("Enter amount of arrays");
                Integer[][] arrs = createArraysForMathSet();
                mathSet = new MathSet<>(arrs);
                mathSet.print();
                System.out.println("mathSet size:" + mathSet.getSize() + "\n" + "mathSet capacity:" + mathSet.getCapacity());
            }
            break;
            case "5": {
                MathSet mathSetForConstructor = createMathSet();
                mathSet = new MathSet<>(mathSetForConstructor);
                mathSet.print();
                System.out.println("mathSet size:" + mathSet.getSize() + "\n" + "mathSet capacity:" + mathSet.getCapacity());
            }
            break;
            case "6": {
                System.out.println("Enter how many MathSets you want to create:");
                int size = getSize();
                MathSet[] mathSets = createArrayOfMathSets(size);
                mathSet = new MathSet(mathSets);
                mathSet.print();
                System.out.println("mathSet size:" + mathSet.getSize() + "\n" + "mathSet capacity:" + mathSet.getCapacity());
            }
            break;
            default:
                mathSet = new MathSet<Integer>();
                break;
        }
    }

    public int getSize() {
        int size;
        do {
            while (!scanChoice.hasNextInt()) {
                scanChoice.next();
                System.out.println("You have entered incorrect value, try again");
            }
            size = scanChoice.nextInt();
            if (size <= 0) {
                System.out.println("You have entered incorrect value, try again");
            }
        } while (size <= 0);
        return size;
    }

    public Integer[] createArrayForMathSet() {
        int size = getSize();
        Integer[] elements = new Integer[size];
        System.out.println("Enter elements");
        for (int i = 0; i < elements.length; i++) {
            while (!scanChoice.hasNextInt()) {
                System.out.println("You have entered incorrect value, try again");
                scanChoice.next();
            }
            elements[i] = scanChoice.nextInt();
        }
        return elements;
    }

    public Integer[][] createArraysForMathSet() {
        int size = getSize();
        Integer[][] arrs = new Integer[size][];
        int arrsReadyCounter = 0;
        while (arrsReadyCounter < size) {
            System.out.println("Enter size of " + (arrsReadyCounter + 1) + " array");
            int sizeArrs = getSize();
            arrs[arrsReadyCounter] = new Integer[sizeArrs];
            arrsReadyCounter++;
        }
        for (int i = 0; i < arrs.length; i++) {
            System.out.println("Enter elements for " + (i + 1) + " array");
            for (int j = 0; j < arrs[i].length; j++) {
                while (!scanChoice.hasNextInt()) {
                    System.out.println("You have entered incorrect value, try again");
                    scanChoice.next();
                }
                arrs[i][j] = scanChoice.nextInt();
            }
        }
        return arrs;
    }

    public MathSet createMathSet() {
        Scanner scanValue = new Scanner(System.in);
        System.out.println("1 - Create MathSet manually\n2 - Create random MathSet");
        String choice = scanValue.nextLine();
        MathSet mathSetForConstructor = new MathSet<Integer>();
        while (!(choice.equals("1") || choice.equals("2"))) {
            System.out.println("You have entered incorrect value, try again");
            choice = scanChoice.nextLine();
        }
        if (choice.equals("1")) {
            System.out.println("Enter size of MathSet");
            int size = getSize();
            System.out.println("Enter elements of MathSet");
            Integer[] numbers = new Integer[size];
            for (int i = 0; i < numbers.length; i++) {
                while (!scanChoice.hasNextInt()) {
                    System.out.println("You have entered incorrect value, try again");
                    scanChoice.next();
                }
                numbers[i] = scanChoice.nextInt();
            }
            mathSetForConstructor.add(numbers);
        } else {
            int size = (int) ((Math.random() * 20) + 1);
            Integer[] numbers = new Integer[size];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) ((Math.random() * 201) - 100);
            }
            mathSetForConstructor.add(numbers);
        }
        return mathSetForConstructor;
    }

    public MathSet[] createArrayOfMathSets(int size) {
        MathSet[] mathSets = new MathSet[size];
        for (int i = 0; i < size; i++) {
            mathSets[i] = new MathSet<Integer>();
        }
        int mathSetSize = 0;
        for (int i = 0; i < mathSets.length; i++) {
            System.out.println("Enter size of MathSet");
            do {
                while (!scanChoice.hasNextInt()) {
                    scanChoice.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                mathSetSize = scanChoice.nextInt();
                if (mathSetSize <= 0) {
                    System.out.println("You have entered incorrect value, try again");
                }
            } while (mathSetSize <= 0);
            System.out.println("Enter elements for " + (i + 1) + " MathSet");
            for (int j = 0; j < mathSetSize; j++) {
                while (!scanChoice.hasNextInt()) {
                    System.out.println("You have entered incorrect value, try again");
                    scanChoice.next();
                }
                mathSets[i].add(scanChoice.nextInt());
            }
        }
        return mathSets;
    }
}
