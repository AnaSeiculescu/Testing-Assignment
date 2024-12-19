package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetricCalculatorTest extends TestCase {

	private String input;
	MetricCalculator calculator = new MetricCalculator();

	@Test
	public void testCalculate() {
		input = "20dm + 5m - 4000mm + 80dm";

		Expression expression = Parser.parseExpression(input);
		double expectedResult = 11.0;
		double actualResult = calculator.calculate(expression);

		assertEquals(expectedResult, actualResult, 0.000);
	}

}