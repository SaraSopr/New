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
        String[] temp = number.split(",");
        BigDecimal sum = BigDecimal.ZERO;
        for (String s : temp)
            sum = sum.add(new BigDecimal(s));
        return sum.toString();
    }
}
