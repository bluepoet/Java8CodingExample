package net.bluepoet.chap01;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Mac on 2015. 9. 26..
 */
public class CalculationTest {

    @Test
    public void testCalculateAddition() throws Exception {
        Calculation calculation = (i1, i2) -> i1 + i2;
        final int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void testCalculateSubtraction() throws Exception {
        Calculation calculation = new Subtraction();
        final int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testCalculateMultiplation() throws Exception {
        Calculation calculation = new Multiplition();
        final int actual = calculation.calculate(2, 2);

        assertThat(actual).isEqualTo(4);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculateDivision() throws Exception {
        Calculation calculation = new Division();
        final int actual = calculation.calculate(8, 0);

        assertThat(actual).isEqualTo(2);
    }
}
