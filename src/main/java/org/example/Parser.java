package org.example;

public class Parser {

	public static Expression parseExpression(String input) {
		Expression expression = new Expression();

		StringBuilder currentNumber = new StringBuilder();
		StringBuilder currentUnit = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);

			if (Character.isWhitespace(currentChar)) {
				continue;
			} else if (Character.isDigit(currentChar) || currentChar == '.') {
				currentNumber.append(currentChar);
			} else if (Character.isLetter(currentChar)) {
				currentUnit.append(currentChar);
			} else if (currentChar == '+' || currentChar == '-') {

				if (currentNumber.length() > 0 && currentUnit.length() > 0) {
					double value = Double.parseDouble(currentNumber.toString());
					expression.addOperand(value, currentUnit.toString());
				}
				expression.addOperator(currentChar);

				currentNumber.setLength(0);
				currentUnit.setLength(0);
			}
		}
		if (currentNumber.length() > 0 && currentUnit.length() > 0) {
			double value = Double.parseDouble(currentNumber.toString());
			expression.addOperand(value, currentUnit.toString());
		}

		return expression;
	}

}
