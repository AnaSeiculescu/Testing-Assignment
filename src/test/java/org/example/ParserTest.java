package org.example;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.example.MeasureUnit.*;
import static org.junit.Assert.assertEquals;

public class ParserTest {

	private String input;

	List<Double> expectedOperands = new ArrayList<>();
	List<MeasureUnit> expectedUnits = new ArrayList<>();
	List<Character> expectedOperators = new ArrayList<>();

	@Test
	public void testParseExpressionNoInput() {
		// prepare

		//execute
		Expression actualResult = Parser.parseExpression(input);
		Expression expectedResult = null;

		//verify
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testParseExpressionOperands() {

		// prepare
		input = "20dm + 5m - 4000mm + 80dm";

		//execute
		Expression expression = Parser.parseExpression(input);
		List<Double> expectedOperands = List.of(new Double[] {20.0, 5.0, 4000.0, 80.0});
		List<Double> actualOperands = expression.getOperands();

		//verify
		assertEquals(expectedOperands, actualOperands);
	}

	@Test
	public void testParseExpressionUnits() {

		// prepare
		input = "20dm + 5m - 4000mm + 80dm";

		//execute
		Expression expression1 = Parser.parseExpression(input);
		List<MeasureUnit> expectedUnits = List.of(new MeasureUnit[] {DM, M, MM, DM});
		List<MeasureUnit> actualUnits = expression1.getUnits();

		//verify
//		String myOperands = expression.getOperands().toString();
		assertEquals(expectedUnits, actualUnits);
	}

	@Test
	public void testParseExpressionOperators() {

		// prepare
		input = "20dm + 5m - 4000mm + 80dm";

		//execute
		Expression expression2 = Parser.parseExpression(input);
		List<Character> expectedOperators = List.of(new Character[] {'+', '-', '+'});
		List<Character> actualOperators = expression2.getOperators();

		//verify
		assertEquals(expectedOperators, actualOperators);
	}

	@Test
	public void testParseExpressionWithShortInput() {
		// prepare
		input = "20dm";

		//execute
		Expression actualResult = Parser.parseExpression(input);

		expectedOperands = List.of(new Double[]{20.0});
		expectedUnits = List.of(new MeasureUnit[]{DM});
		expectedOperators = List.of(new Character[]{});

		Expression expectedResult = new Expression(
				expectedOperands, expectedUnits, expectedOperators
		);

		//verify
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testParseExpressionWithLongerInput() {
		// prepare
		input = "- 20dm + 5m - 4000mm + 80dm";

		//execute
		Expression actualResult = Parser.parseExpression(input);

		expectedOperands = List.of(new Double[]{20.0, 5.0, 4000.0, 80.0});
		expectedUnits = List.of(new MeasureUnit[]{DM, M, MM, DM});
		expectedOperators = List.of(new Character[]{'-', '+', '-', '+'});

		Expression expectedResult = new Expression(
				expectedOperands, expectedUnits, expectedOperators
		);

		//verify
		assertEquals(expectedResult, actualResult);
	}

}