package org.example;

import com.sun.xml.internal.ws.util.StringUtils;

import java.math.BigDecimal;

public class StringCalculator {

    public static final String SEPARATOREVIRGOLA = ",";
    public static final String SEPARATORENEWLINES = "\n";
    public static final String SEPARATOREVIRGOLA_NEWLINES = ",\n";
    public static final String SEPARATORENEWLINES_VIRGOLA = "\n,";

    public String add(String number) {
        if (number.isEmpty())
            return "0";
        if (SEPARATOREVIRGOLA.charAt(0) == number.charAt(number.length() - 1)){
            return "Number expected but EOF found.";
        }
        if (number.contains(SEPARATOREVIRGOLA_NEWLINES)) {
            return getErrorMessage(number, SEPARATORENEWLINES, SEPARATOREVIRGOLA_NEWLINES);
        }
        if (number.contains(SEPARATORENEWLINES_VIRGOLA)){
            return getErrorMessage(number, SEPARATOREVIRGOLA, SEPARATORENEWLINES_VIRGOLA);
        }
        return getSum(number);
    }

    private static String getSum(String number) {
        String inputSenzaNewLines = number.replace(SEPARATORENEWLINES, SEPARATOREVIRGOLA);
        String[] arrayDiNumeri = inputSenzaNewLines.split(SEPARATOREVIRGOLA);

        BigDecimal sum = BigDecimal.ZERO;
        for (String s : arrayDiNumeri)
            sum = sum.add(new BigDecimal(s));
        return sum.toString();
    }

    private static String getErrorMessage(String number, String separatore, String separatoreErrato) {
        int posizioneErrore = number.indexOf(separatoreErrato)+1;
        return "Number expected but '" + separatore + "' found at position " + posizioneErrore + ".";
    }
}
