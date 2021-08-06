package ua.com.alevel.level1.uniqueSymbols;

import java.util.Arrays;

public class UniqueSymbols {

    public static int uniqueSymbolsCount(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int amountOfUniqueSymbols = 1;
        Arrays.sort(arr);
        for (int curSymbolIndex = 0, i = curSymbolIndex + 1; i < arr.length; i++) {
            if (arr[i] != arr[curSymbolIndex]) {
                amountOfUniqueSymbols++;
                curSymbolIndex = i;
            }
        }
        return amountOfUniqueSymbols;
    }
}
