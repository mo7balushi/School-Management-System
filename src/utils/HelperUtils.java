package utils;

import java.util.List;

public class HelperUtils {

    private static int counter = 1;

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
    public static boolean isValidString(String s) {
        return !isEmpty(s);
    }

    public static boolean isValidString(String s, int minLength) {
        return !isEmpty(s) && s.trim().length() >= minLength;
    }

    public static boolean isValidString(String s, int min, int max) {
        return !isEmpty(s)
                && s.trim().length() >= min
                && s.trim().length() <= max;
    }
    public static boolean isPositive(double number) {
        return number > 0;
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }
    public static boolean isValidNumber(int n, int min, int max) {
        return n >= min && n <= max;
    }

    public static boolean isValidNumber(double n, double min, double max) {
        return n >= min && n <= max;
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }
    public static String generateId() {
        return "ID-" + (counter++);
    }

}