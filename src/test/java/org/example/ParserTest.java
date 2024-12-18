package org.example;

//import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParserTest {

	String input = "20dm + 5m - 2000mm + 80dm";
	Expression expression = Parser.parseExpression(input);
	MetricCalculator calculator = new MetricCalculator();

	@Test
	public void testParseExpression() {

		double result = calculator.calculate(expression);
		assertEquals(13.0, result, 0.000);

	}
}