package se.mattiashellman.lexicon;

public class CurrencyConverter {
    public enum Currency {
        SEK,
        USD,
        EURO
    }

    /**
     *      SEK     USD     EURO
     * SEK  1.0     0.1057  0.0906
     * USD  9.4617  1.0     0.8576
     * EURO 11.0322 1.1660  1.0
     */
    private static final double[][] exchangeRates = {
            {1.0, 0.1057, 0.0906},
            {9.4617, 1.0, 0.8576},
            {11.0322, 1.1660, 1.0}
    };

    /**
     * Converts an amount from one currency to another and returns the result
     * @param from currency to convert from
     * @param to currency to convert to
     * @param amount amount to convert
     * @return the converted amount
     */
    public static Double convert(Currency from, Currency to, Double amount) {
        return exchangeRates[from.ordinal()][to.ordinal()] * amount;
    }
}


