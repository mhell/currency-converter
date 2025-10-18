package se.mattiashellman.lexicon;

import java.time.LocalDateTime;

public class CurrencyConverter {
    public enum Currency {
        SEK,
        USD,
        EURO
    }

    private static final double USDSEK = 9.4580, EURSEK = 11.0259, USDEUR = 0.8576;
    private static final LocalDateTime ratesDateStamp = LocalDateTime.of(2025, 10, 18, 10, 36);

    /**
     * Conversion lookup
     *       SEK      USD        EURO
     * SEK   1.0      1/USDSEK   1/EURSEK
     * USD   USDSEK   1.0        USDEUR
     * EURO  EURSEK   1/USDEUR   1.0
     */
    private static final double[][] exchangeRates = {
            {1.0,    1/USDSEK, 1/EURSEK},
            {USDSEK, 1.0,      USDEUR},
            {EURSEK, 1/USDEUR, 1.0}
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

    /**
     * Gets the date and time of the exchange rates
     * @return the rates timestamp
     */
    public static LocalDateTime getRatesDateStamp() {
        return ratesDateStamp;
    }
}


