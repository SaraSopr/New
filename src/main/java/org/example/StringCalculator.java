package org.example;

import java.math.BigDecimal;

public class StringCalculator {

    public static final String SEPARATOREVIRGOLA = ",";
    public static final String SEPARATORENEWLINES = "\n";
    public static final String SEPARATOREVIRGOLA_NEWLINES = ",\n";
    public static final String SEPARATORENEWLINES_VIRGOLA = "\n,";

    public String add(String number) {
        if (number.isEmpty())
            return "0";
        if ((SEPARATOREVIRGOLA.charAt(0) == number.charAt(number.length() - 1)) || (SEPARATORENEWLINES.charAt(0) == number.charAt(number.length() - 1))){
            return "Number expected but EOF found.";
        }

        if (number.startsWith("//")) {
            int x = number.indexOf("\n");
            String customSeparator = number.substring(2, x);



            String numberSenzaCustomSeparator = number.substring(x+1, number.length());
            if (number.contains(SEPARATOREVIRGOLA))
                return getErrorMessage(customSeparator, numberSenzaCustomSeparator);
            String[] arrayDiNumeri = map(numberSenzaCustomSeparator, customSeparator);
            return getSum(arrayDiNumeri);
        }

        if (number.contains(SEPARATOREVIRGOLA_NEWLINES)) {
            return getErrorMessage(number, SEPARATORENEWLINES, SEPARATOREVIRGOLA_NEWLINES);
        }
        if (number.contains(SEPARATORENEWLINES_VIRGOLA)){
            return getErrorMessage(number, SEPARATOREVIRGOLA, SEPARATORENEWLINES_VIRGOLA);
        }

        String[] arrayDiNumeri = map(number, SEPARATORENEWLINES);

        return getSum(arrayDiNumeri);
    }

    private static String getErrorMessage(String customSeparator, String numberSenzaCustomSeparator) {
        return "'" + customSeparator + "' expected but '" + SEPARATOREVIRGOLA + "' found at position " + numberSenzaCustomSeparator.indexOf(SEPARATOREVIRGOLA) + ".";
    }

    private static String[] map(String number, String customSeparator) {

        String inputSenzaCustomSeparator = number.replace(customSeparator, SEPARATOREVIRGOLA);
        String[] arrayDiNumeri = inputSenzaCustomSeparator.split(SEPARATOREVIRGOLA);
        return arrayDiNumeri;
    }

    private static String getSum(String[] arrayDiNumeri) {
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
