package ua.com.alevel.task2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static char[] getLetters(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");//а-яА-ЯЁёїі a-zA-Z
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            stringBuilder.append(matcher.group());
        }
        char[] letters = new char[stringBuilder.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = stringBuilder.charAt(i);
        }
        return letters;
    }

    public static void charactersOccurrences(String string) {
        char[] letters = getLetters(string);
        if (letters.length == 0) {
            System.out.println("There are no Latin / Cyrillic characters in your string");
            return;
        }
        int count = 1, k = 0;
        Arrays.sort(letters);
        int ind = 1;
        for (int i = k + 1; i < letters.length; i++) {
            if (letters[i] == letters[k]) {
                count++;
            } else {
                System.out.print(ind++ + ". ");
                System.out.println(letters[k] + "  - " + count);
                k = i;
                count = 1;
            }
        }
        System.out.print(ind + ". ");
        System.out.println(letters[k] + "  - " + count);
    }
}
