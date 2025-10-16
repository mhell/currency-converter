package se.mattiashellman.lexicon;

import java.util.Scanner;
import static se.mattiashellman.lexicon.CurrencyConverter.Currency;

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
                System.out.println("\n" + handleInput(choice, amount));
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
            double result = Double.parseDouble(scanner.nextLine());
            if (result < 0) throw new Exception("negative amount");
            return result;
        } catch (NumberFormatException e) {
            throw new Exception("not a number");
        }
    }

    private static String handleInput(int choice, double amount) {
        String resultString = "%.2f %s converted to %s is: %.2f %s";
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


