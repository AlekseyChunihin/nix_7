package ua.com.alevel.task1;

public class Task1 {

    public static int conversionCharDigitToIntDigit(char symbol) {
        return symbol - '0';
    }

    public static int sumOfDigitsInString(String string) {
        int digitCode = 48, sum = 0;
        boolean IsNumberEntered = false;
        char zero = '0', nine = '9';
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= zero && string.charAt(i) <= nine) {
                IsNumberEntered = true;
                while (digitCode <= nine) {
                    if (string.charAt(i) == digitCode) {
                        sum += conversionCharDigitToIntDigit(string.charAt(i));
                        digitCode = zero;
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
