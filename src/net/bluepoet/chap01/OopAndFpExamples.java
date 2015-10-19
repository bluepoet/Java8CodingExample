package net.bluepoet.chap01;

/**
 * Created by Mac on 2015. 9. 26..
 */
public class OopAndFpExamples {
    public static void main(String[] args) {
        final CalculationService calculatorService = new CalculationService(new Addition());
        final int result = calculatorService.calculate(11, 4);
        System.out.println(result);

        final int subtractionResult = calculatorService.calculate(11, 1);
        System.out.println(subtractionResult);

        final int multiplicationResult = calculatorService.calculate(11, 2);
        System.out.println(multiplicationResult);

        final int divisionResult = calculatorService.calculate(20, 4);
        System.out.println(divisionResult);

        final FpCalculatorService fpCalculatorService = new FpCalculatorService();
        System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 + i2, 11, 4));
        System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 - i2, 11, 1));
        System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 * i2, 11, 2));
        System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 / i2, 20, 4));
        System.out.println(fpCalculatorService.calculate((i1, i2) -> ((i1 + i2) * 2) / i2, 20, 4));
    }
}

interface Calculation {
    int calculate(int num1, int num2);
}

class Addition implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Multiplition implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

class Division implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}

class Subtraction implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class CalculationService {
    private final Calculation calculation;

    public CalculationService(final Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2) {
        if (num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1 : " + num1 + ", num2 : " + num2);
        }
    }
}

class FpCalculatorService {
    public int calculate(Calculation calculation, int num1, int num2) {
        if (num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1 : " + num1 + ", num2 : " + num2);
        }
    }
}