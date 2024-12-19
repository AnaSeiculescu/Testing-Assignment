package org.example;

import java.util.List;

public class MetricCalculator {

	private Expression expression;

	public static double calculate(Expression expression) {

		List<Double> operands = expression.getOperands();
		List<MeasureUnit> units = expression.getUnits();
		List<Character> operators = expression.getOperators();

		double result = convertToMeters(operands.get(0), units.get(0));

		for (int i = 1; i < operands.size(); i++) {
			double valueInMeters = convertToMeters(operands.get(i), units.get(i));
			char operator = operators.get(i - 1);

			if (operator == '+') {
				result += valueInMeters;
			} else {
				result -= valueInMeters;
			}
		}

		return result;
	}

	private static double convertToMeters(Double value, MeasureUnit unit) {
		return value * unit.getToMeters();
	}
}