package com.pluralsight;

import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        runHomeScreen();
    }

    // ---------- Screens: a menu that repeats until the user picks the way out ----------

    public static void runHomeScreen() {
        String command;
        do {
            System.out.println();
            System.out.println("=== Home ===");
            System.out.println("W) Work out option");
            System.out.println("X) Exit");
            System.out.print("Enter a command: ");
            command = input.nextLine().trim().toUpperCase();

            switch (command) {
                case "W" -> runWorkoutsScreen();
                case "X" -> System.out.println("Goodbye!");
                default -> System.out.println("That isn't a command. Try again.");
            }
        } while (!command.equals("X"));
    }

    public static void runWorkoutsScreen() {
        String command;
        do {
            System.out.println();
            System.out.println("=== Browse Workouts ===");
            System.out.println("(A) Display all workouts");
            System.out.println("(Q) Display quick workouts");
            System.out.println("(S) Search Workout");
            System.out.println("(H) Home");
            System.out.print("Enter a command: ");
            command = input.nextLine().trim().toUpperCase();

            switch (command) {
                case "S" -> runSearchScreen();
                case "A" -> displayAllWorkouts();
                case "Q" -> displayQuickWorkouts();
                case "H" -> System.out.println("Back to Home");
                default -> System.out.println("That isn't a command. Try again.");
            }
        } while (!command.equals("H"));
    }

    public static void runSearchScreen() {
        String command;
        do {
            System.out.println();
            System.out.println("=== Search ===");
            System.out.println("0) Back");
            System.out.println("(1) Back to Search Menu");
            System.out.println("(2) Search by name");
            System.out.println("(3) Search by level");
            System.out.print("Enter a command: ");
            command = input.nextLine().trim().toUpperCase();

            switch (command) {
                case "0" -> System.out.println("Back to Home Menu");
                case "1" -> runSearchScreen();
                case "2" -> searchByTitle();
                case "3" -> searchByLevel();
                default -> System.out.println("That isn't a command. Try again.");
            }
        } while (!command.equals("0"));
    }

    // ---------- Actions: do one thing, wait for Enter, then return to the screen ----------

    public static void displayQuickWorkouts() {
        System.out.println("Displaying all quick workouts...");
        pressEnterToContinue();
    }

    public static void displayAllWorkouts() {
        System.out.println("Displaying all workouts...");
        pressEnterToContinue();
    }

    public static void searchByTitle() {
        System.out.print("Name of workout to search for: ");
        String title = input.nextLine();

        System.out.println("Displaying workout whose name matches " + title);
        pressEnterToContinue();
    }

    public static void searchByLevel() {
        System.out.print("Level of workout: ");
        String year = input.nextLine();

        System.out.println("Displaying workouts that are level " + year);
        pressEnterToContinue();
    }

    // the results stay on screen until the user is ready to see the menu again
    public static void pressEnterToContinue() {
        System.out.println();
        System.out.print("Press Enter to go back to the menu...");
        input.nextLine();
    }
}
