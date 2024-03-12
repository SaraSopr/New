package org.example;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {

    @Test
    void quandoHoInInputStringaVuotaRitorna0() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("0");
    }

    @Test
    void quandoHoInInput1Ritorna1() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("1");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("1");
    }

    @Test
    void quandoHoInInput99Ritorna99() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("99");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("99");
    }
}