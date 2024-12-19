package org.example;

public class Parser {

	public static Expression parseExpression(String input) {
		Expression expression = new Expression();

		StringBuilder currentNumber = new StringBuilder();
		StringBuilder currentUnit = new StringBuilder();

		if (input == null) {
			return null;
		}

		String noSpacesInput = input.replaceAll("\\s", "");
		String refactorizedInput = noSpacesInput;

		if (noSpacesInput.charAt(0) == '-') {
			currentNumber.append(noSpacesInput.charAt(0));
			refactorizedInput = noSpacesInput.substring(1);
		}

		for (int i = 0; i < refactorizedInput.length(); i++) {
			char currentChar = refactorizedInput.charAt(i);

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
