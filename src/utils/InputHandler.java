package utils;

import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);
    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    public static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

}