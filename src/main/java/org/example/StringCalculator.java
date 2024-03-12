package org.example;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringCalculator {
    public String add(String number) {
        if (number.isEmpty())
            return "0";
        return getSum(number);
    }

    private static String getSum(String number) {
        if (number.contains(",\n")) {
            int posizioneErrore = number.indexOf((",\n"))+1;
            return "Number expected but '\n' found at position "+ posizioneErrore +".";
        }
        String inputSenzaNewLines = number.replace("\n", ",");
        String[] arrayDiNumeri = inputSenzaNewLines.split(",");

        BigDecimal sum = BigDecimal.ZERO;
        for (String s : arrayDiNumeri)
            sum = sum.add(new BigDecimal(s));
        return sum.toString();
    }
}
