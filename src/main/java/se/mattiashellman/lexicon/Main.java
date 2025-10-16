package se.mattiashellman.lexicon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static se.mattiashellman.lexicon.CurrencyConverter.Currency;

public class Main {
    public static void main (String[] args) {
        showMenu();
    }

    /**
     * Displays a menu in console
     */
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
                System.out.println("\n" + handleInput(choice, amount));
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            }
        }
    }

    /**
     * Gets user menu choice from console
     * @param scanner the text scanner
     * @return the choice
     * @throws Exception if the input is not a valid menu item
     */
    private static int getChoice(Scanner scanner) throws Exception {
        try {
            int result = Integer.parseInt(scanner.nextLine());
            if (result > 4 || result < 0) throw new Exception("Incorrect input");
            return result;
        } catch (NumberFormatException e) {
            throw new Exception("incorrect input");
        }
    }

    /**
     * Gets the amount to convert from console
     * @param scanner the text scanner
     * @return the amount
     * @throws Exception if amount is nan or a negative number
     */
    private static double getAmount(Scanner scanner) throws Exception {
        try {
            double result = Double.parseDouble(scanner.nextLine());
            if (result < 0) throw new Exception("negative amount");
            return result;
        } catch (NumberFormatException e) {
            throw new Exception("not a number");
        }
    }

    /**
     * Handles the user input by calling CurrencyConverter with the inputs and returns the result
     * @param choice a valid menu choice
     * @param amount an amount to be converted
     * @return a string describing the result with accompanying date and time of conversion
     */
    private static String handleInput(int choice, double amount) {
        String time = LocalDateTime.of(2025, 10, 16, 11, 48).format(DateTimeFormatter.ofPattern("EEEE d MMMM H:mm"));
        String resultString = "%.2f %s converted to %s is: %.2f %s at " + time;
        double resultAmount;
        switch (choice) {
            case 1:
                resultAmount = CurrencyConverter.convert(Currency.SEK, Currency.USD, amount);
                resultString = String.format(resultString, amount, Currency.SEK, Currency.USD, resultAmount, Currency.USD);
                break;
            case 2:
                resultAmount = CurrencyConverter.convert(Currency.USD, Currency.SEK, amount);
                resultString = String.format(resultString, amount, Currency.USD, Currency.SEK, resultAmount, Currency.SEK);
                break;
            case 3:
                resultAmount = CurrencyConverter.convert(Currency.SEK, Currency.EURO, amount);
                resultString = String.format(resultString, amount, Currency.SEK, Currency.EURO, resultAmount, Currency.EURO);
                break;
            case 4:
                resultAmount = CurrencyConverter.convert(Currency.EURO, Currency.SEK, amount);
                resultString = String.format(resultString, amount, Currency.EURO, Currency.SEK, resultAmount, Currency.SEK);
                break;
            case 0:
                System.exit(0);
        }
        return resultString;
    }
}


