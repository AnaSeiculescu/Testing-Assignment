package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetricCalculatorTest extends TestCase {

	private String input;
	Expression expression = Parser.parseExpression(input);
	MetricCalculator calculator = new MetricCalculator();

	@Test
	public void testCalculate() {
		input = "-20dm + 5m - 4000mm + 80dm";
		double result = calculator.calculate(expression);
		assertEquals(7.0, result, 0.000);
	}

}