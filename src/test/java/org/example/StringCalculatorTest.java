package org.example;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

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

    @Test
    void quandoHoInInputUnSoloNumeroRitornaIlNumero() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            String input = String.valueOf(rand.nextDouble());
            //Act: azione che cosa sto testando
            String actual = stringCalculator.add(input);
            //Assert: asserire l'output vedere se è quello atteso
            assertThat(actual).isEqualTo(input);
        }
    }

    @Test
    void quandoHoInInputArrayNumeriDecimaliRitornaSomma() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("1.1,2.2");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("3.3");
    }

    @Test
    void quandoHoInInput6numeriRitornaSomma() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("1,1.1,2.2,2,3.4,3");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("12.7");
    }

    @Test
    void quandoHoInInputnumeriSeparatiDaNewLinesRitornaSomma() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("1\n2,3");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("6");
    }

    @Test
    void quandoHoInInputnumeriSeparatiDaVirgolaENewLinesRitornaErrore() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("175.2,\n35");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("Number expected but '\n' found at position 6.");
    }

    @Test
    void quandoHoInInputnumeriSeparatiDaNewLinesEVirgolaRitornaErrore() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("175.2\n,35");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("Number expected but ',' found at position 6.");
    }

    @Test
    void quandoHoUnSeparatoreVirgolaAllaFineRitornaErrore() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("1,3,");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("Number expected but EOF found.");
    }

    @Test
    void quandoHoUnSeparatoreNewLinesAllaFineRitornaErrore() {
        //Arrange: costruendo la parte di test
        StringCalculator stringCalculator = new StringCalculator();
        //Act: azione che cosa sto testando
        String actual = stringCalculator.add("1,3\n");
        //Assert: asserire l'output vedere se è quello atteso
        assertThat(actual).isEqualTo("Number expected but EOF found.");
    }

}