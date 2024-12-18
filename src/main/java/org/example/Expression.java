package org.example;

import java.util.ArrayList;
import java.util.List;

public class Expression {
	private final List<Double> operands = new ArrayList<>();
	private final List<String> units = new ArrayList<>();
	private final List<Character> operators = new ArrayList<>();

	public void addOperand(double operand, String unit) {
		operands.add(operand);
		units.add(unit);
	}

	public void addOperator(char operator) {
		operators.add(operator);
	}

	public List<Double> getOperands() {
		return operands;
	}

	public List<String> getUnits() {
		return units;
	}

	public List<Character> getOperators() {
		return operators;
	}
}
