package se.mattiashellman.lexicon;

public class CurrencyConverter {
    public enum Currency {
        SEK,
        USD,
        EURO
    }

    /**
     *      SEK   USD   EURO
     * SEK  1.0   0.11  0.91
     * USD  9.46  1.0   0.86
     * EURO 11.03 1.17  1.0
     */
    private static final double[][] exchangeRates = {
            {1.0, 0.11, 0.91},
            {9.46, 1.0, 0.86},
            {11.03, 1.17, 1.0}
    };

    public static Double convert(Currency from, Currency to, Double amount) {
        return exchangeRates[from.ordinal()][to.ordinal()];
    }
}


