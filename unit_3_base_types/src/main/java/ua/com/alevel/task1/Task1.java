package ua.com.alevel.task1;

public class Task1 {

    public static int conversionCharDigitToIntDigit(char symbol) {
        return symbol - '0';
    }

    public static int sumOfDigitsInString(String string) {
        int digitCode = 48, sum = 0;
        boolean IsNumberEntered = false;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                IsNumberEntered = true;
                while (digitCode <= '9') {
                    if (string.charAt(i) == digitCode) {
                        sum += conversionCharDigitToIntDigit(string.charAt(i));
                        digitCode = '0';
                        break;
                    }
                    digitCode++;
                }
            }
        }
        if (!IsNumberEntered) {
            return -1;
        } else {
            return sum;
        }
    }
}
