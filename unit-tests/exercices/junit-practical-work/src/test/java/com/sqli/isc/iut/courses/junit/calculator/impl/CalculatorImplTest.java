package com.sqli.isc.iut.courses.junit.calculator.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorImplTest {

    private final CalculatorImpl calculator = new CalculatorImpl();
	
	static Object[][] provideNumbersForSum() {
		return new Object[][] {
			{ 2, 3, 5 },
			{ 2, -3, -1 },
		};
	}

	@ParameterizedTest(name = "should return {2} when adding {0} and {1}")
    @MethodSource("provideNumbersForSum")
    public void should_return_correct_result_with_sum(int a, int b, int expected) {
        // GIVEN PARAMS
        // WHEN
        int result = calculator.sum(a, b);

        // SHOULD
        assertEquals(expected, result);
    }

    @Test
    public void should_return_5_when_adding_2_and_3() {
        // GIVEN
        int a = 2;
        int b = 3;

        // WHEN
        int result = calculator.sum(a, b);

        // SHOULD
        assertEquals(5, result);
    }

    @Test
    public void should_return_minus_1_when_adding_2_and_minus_3() {
        // GIVEN
        int a = 2;
        int b = -3;

        // WHEN
        int result = calculator.sum(a, b);

        // SHOULD
        assertEquals(-1, result);
    }

    @Test
    public void should_return_minus_1_when_subtracting_3_from_2() {
        // GIVEN
        int a = 2;
        int b = 3;

        // WHEN
        int result = calculator.substract(a, b);

        // SHOULD
        assertEquals(-1, result);
    }

    @Test
    public void should_return_5_when_subtracting_minus_3_from_2() {
        // GIVEN
        int a = 2;
        int b = -3;

        // WHEN
        int result = calculator.substract(a, b);

        // SHOULD
        assertEquals(5, result);
    }

    @Test
    public void should_return_5_when_dividing_10_by_2() {
        // GIVEN
        int a = 10;
        int b = 2;

        // WHEN
        int result = calculator.divide(a, b);

        // SHOULD
        assertEquals(5, result);
    }

    @Test
    public void should_throw_exception_when_dividing_by_0() {
        // GIVEN
        int a = 10;
        int b = 0;

        // WHEN + SHOULD
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    public void should_return_6_when_multiplying_2_by_3() {
        // GIVEN
        int a = 2;
        int b = 3;

        // WHEN
        int result = calculator.multiply(a, b);

        // SHOULD
        assertEquals(6, result);
    }

    @Test
    public void should_return_0_when_multiplying_2_by_0() {
        // GIVEN
        int a = 2;
        int b = 0;

        // WHEN
        int result = calculator.multiply(a, b);

        // SHOULD
        assertEquals(0, result);
    }
}
