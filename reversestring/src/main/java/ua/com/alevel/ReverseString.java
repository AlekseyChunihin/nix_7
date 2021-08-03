package ua.com.alevel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseString {

    public static String reverse(String str, boolean reverseEachWord) {
        String reverseString = "";
        char[] symbols = str.toCharArray();
        if (!reverseEachWord) {
            char tmp;
            for (int i = 0, j = symbols.length - 1; i < symbols.length / 2; i++, j--) {
                tmp = symbols[j];
                symbols[j] = symbols[i];
                symbols[i] = tmp;
            }
            reverseString = new String(symbols);
        } else if (reverseEachWord) {
            String[] words = str.split(" ");
            String reverseWord;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                reverseWord = reverse(words[i], false);
                if (i < words.length - 1) {
                    stringBuilder.append(reverseWord + " ");
                } else stringBuilder.append(reverseWord);
            }
            reverseString = stringBuilder.toString();
        }
        return reverseString;
    }

    public static String reverse(String str, String dest) {
        String result;
        Pattern pattern = Pattern.compile(dest);
        Matcher matcher = pattern.matcher(str);
        result = matcher.replaceAll(reverse(dest, false));
        return result;
    }

    public static String reverse(String str, int firstIndex, int lastIndex) {
        if (firstIndex > lastIndex) {
            return str;
        } else if (firstIndex >= str.length() || lastIndex >= str.length() || firstIndex < 0 || lastIndex < 0) {
            return str;
        }
        String dest = str.substring(firstIndex, lastIndex + 1);
        return reverse(str, dest);
    }

    public static String reverse(String str, char firstChar, char lastChar) {
        int firstIndex = str.indexOf(firstChar);
        int lastIndex = str.indexOf(lastChar);
        if (firstIndex == -1 || lastIndex == -1) {
            return str;
        }
        return reverse(str, firstIndex, lastIndex);
    }
}

