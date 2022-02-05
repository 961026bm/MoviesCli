package com.careerdevs;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString (String question) {
        while (true) {
            System.out.println("\n" + question + "\nInput: ");
            String inputString = scanner.nextLine();

            if ( !inputString.trim().equals("") ) {
                return inputString.trim();
            }
            System.out.println("You must enter something");

            }

        }

    public static int readInt (String question, int min, int max) {}

    public static boolean yesOrNo (String question) {
        while (true) {
            System.out.println("\n" + question + "\ny/n: ");
            String rawInputString = scanner.nextLine();
            char cleanInput = rawInputString.toLowerCase(Locale.ROOT).trim().charAt(0);

            if (cleanInput == 'y') {
                return true;
            } else if (cleanInput == 'n') {
                return false;
            }

            System.out.println("Input must be Y or N");

        }
    }

}
