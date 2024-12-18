package org.example;

import org.junit.Test;
//import java.util.List;
import static org.junit.Assert.assertEquals;

public class ParserTest {

	String input = "20dm + 5m - 4000mm + 80dm";
	Expression expression = Parser.parseExpression(input);
	MetricCalculator calculator = new MetricCalculator();

	@Test
	public void testParseExpression() {

		String myOperands = expression.getOperands().toString();
		assertEquals("[20.0, 5.0, 4000.0, 80.0]", myOperands);

	}


	@Test
	public void testCalculateExpression() {

		double result = calculator.calculate(expression);
		assertEquals(11.0, result, 0.000);

	}
}