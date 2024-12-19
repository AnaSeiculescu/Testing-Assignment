package org.example;

public class Parser {

	public static boolean isFirstMinus = false;

	public static Expression parseExpression(String input) {
		Expression expression = new Expression();

		StringBuilder currentNumber = new StringBuilder();
		StringBuilder currentUnit = new StringBuilder();

		if (input == null) {
			return null;
		}

		String noWhiteSpacesInput = input.replaceAll("\\s", "");

		if (noWhiteSpacesInput.charAt(0) == '-') {
			isFirstMinus = true;
		}

		for (int i = 0; i < noWhiteSpacesInput.length(); i++) {
			char currentChar = noWhiteSpacesInput.charAt(i);

			if (Character.isDigit(currentChar) || currentChar == '.') {
				currentNumber.append(currentChar);
			} else if (Character.isLetter(currentChar)) {
				currentUnit.append(currentChar);
			} else if (currentChar == '+' || currentChar == '-') {

				//  when the iteration finds a "+" or a "-" packs the number and the letters that we suppose represent the unit measure
				//  and populate the expression's fields

				if (currentNumber.length() > 0 && currentUnit.length() > 0) {
					double value = Double.parseDouble(currentNumber.toString());
					MeasureUnit unit = MeasureUnit.valueOf(currentUnit.toString().toUpperCase());
					expression.addOperand(value, unit);
				}
				expression.addOperator(currentChar);

				currentNumber.setLength(0);
				currentUnit.setLength(0);
			}
		}

		//  after there are no operators left inside the input
		//  there is still one operand to collect

		if (currentNumber.length() > 0 && currentUnit.length() > 0) {
			double value = Double.parseDouble(currentNumber.toString());
			MeasureUnit unit = MeasureUnit.valueOf(currentUnit.toString().toUpperCase());
			expression.addOperand(value, unit);
		}

		return expression;
	}

}
