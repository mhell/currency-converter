package se.mattiashellman.lexicon;

public class CurrencyConverter {
    public enum Currency {
        SEK,
        USD,
        EURO
    }

    public static Double convert(Currency from, Currency to, Double amount) {
        return 100d;
    }
}


