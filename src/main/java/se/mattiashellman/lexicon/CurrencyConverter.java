package se.mattiashellman.lexicon;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main (String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("""
                    Currency Converter App:
                    1. Convert SEK to USD
                    2. Convert USD to SEK
                    3. Convert SEK to Euro
                    4. Convert Euro to SEK
                    0. Exit
                    Enter your choice:\s""");
        } while (!scanner.nextLine().equalsIgnoreCase("0"));
    }
}
