package se.mattiashellman.lexicon;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    \nCurrency Converter App:
                    1. Convert SEK to USD
                    2. Convert USD to SEK
                    3. Convert SEK to Euro
                    4. Convert Euro to SEK
                    0. Exit
                    Enter your choice:\s""");
            try {
                int choice = getChoice(scanner);
                if (choice == 0) break;
                System.out.print("Enter amount: ");
                double amount = getAmount(scanner);
                handleInput(choice, amount);
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            }
        }
    }

    private static int getChoice(Scanner scanner) throws Exception {
        try {
            int result = Integer.parseInt(scanner.nextLine());
            if (result > 4) throw new Exception("Incorrect input");
            return result;
        } catch (NumberFormatException e) {
            throw new Exception("incorrect input");
        }
    }

    private static double getAmount(Scanner scanner) throws Exception {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new Exception("incorrect number");
        }
    }

    private static void handleInput(int choice, double amount) {
    }
}


