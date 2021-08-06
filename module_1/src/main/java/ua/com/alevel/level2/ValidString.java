package ua.com.alevel.level2;

import java.util.Stack;

public class ValidString {

    public static boolean isStringValid(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char curElement = string.charAt(i);
            switch (curElement) {
                case '{':
                case '(':
                case '[':
                    stack.push(curElement);
                    break;
                case '}':
                case ')':
                case ']':
                    if (!stack.empty()) {
                        char elem = stack.pop();
                        if ((curElement == '}' && elem != '{') || (curElement == ')' && elem != '(') || (curElement == ']' && elem != '[')) {
                            return false;
                        }
                    } else return false;
                    break;
                default:
                    break;
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
