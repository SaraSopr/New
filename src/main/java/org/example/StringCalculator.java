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
            String customSeparator = String.valueOf(number.charAt(2));
            String numberSenzaCustomSeparator = number.substring(5, number.length());
            return getSum(numberSenzaCustomSeparator, customSeparator);
        }

        if (number.contains(SEPARATOREVIRGOLA_NEWLINES)) {
            return getErrorMessage(number, SEPARATORENEWLINES, SEPARATOREVIRGOLA_NEWLINES);
        }
        if (number.contains(SEPARATORENEWLINES_VIRGOLA)){
            return getErrorMessage(number, SEPARATOREVIRGOLA, SEPARATORENEWLINES_VIRGOLA);
        }
        return getSum(number, SEPARATOREVIRGOLA);
    }

    private static String getSum(String number, String customSeparator) {
        String inputSenzaCustomSeparator = number.replace(customSeparator, SEPARATOREVIRGOLA);
        String inputSenzaNewLinesECostomSeparator = inputSenzaCustomSeparator.replace(SEPARATORENEWLINES, SEPARATOREVIRGOLA);
        String[] arrayDiNumeri = inputSenzaNewLinesECostomSeparator.split(SEPARATOREVIRGOLA);

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
