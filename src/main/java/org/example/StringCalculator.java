package org.example;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringCalculator {

    public static final String SEPARATOREVIRGOLA = ",";
    public static final String SEPARATORENEWLINES = "\n";
    public static final String SEPARATOREVIRGOLA_NEWLINES = ",\n";

    public String add(String number) {
        if (number.isEmpty())
            return "0";
        return getSum(number);
    }

    private static String getSum(String number) {
        if (number.contains(SEPARATOREVIRGOLA_NEWLINES)) {
            int posizioneErrore = number.indexOf(SEPARATOREVIRGOLA_NEWLINES)+1;
            return "Number expected but '\n' found at position "+ posizioneErrore +".";
        }
        String inputSenzaNewLines = number.replace(SEPARATORENEWLINES, SEPARATOREVIRGOLA);
        String[] arrayDiNumeri = inputSenzaNewLines.split(SEPARATOREVIRGOLA);

        BigDecimal sum = BigDecimal.ZERO;
        for (String s : arrayDiNumeri)
            sum = sum.add(new BigDecimal(s));
        return sum.toString();
    }
}
