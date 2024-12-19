package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expression {
	private List<Double> operands = new ArrayList<>();
	private List<MeasureUnit> units = new ArrayList<>();
	private List<Character> operators = new ArrayList<>();

	public Expression() {
	}

	public Expression(List<Double> operands, List<MeasureUnit> units, List<Character> operators) {
		this.operands = operands;
		this.units = units;
		this.operators = operators;
	}

	public void addOperand(double operand, MeasureUnit unit) {
		operands.add(operand);
		units.add(unit);
	}

	public void addOperator(char operator) {
		operators.add(operator);
	}

	public List<Double> getOperands() {
		return operands;
	}

	public List<MeasureUnit> getUnits() {
		return units;
	}

	public List<Character> getOperators() {
		return operators;
	}

	@Override
	public String toString() {
		return "Expression{" +
				"operands=" + operands +
				", units=" + units +
				", operators=" + operators +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Expression other = (Expression) o;
		return Objects.equals(getOperands(), other.getOperands()) && Objects.equals(getUnits(), other.getUnits()) && Objects.equals(getOperators(), other.getOperators());
	}

}
