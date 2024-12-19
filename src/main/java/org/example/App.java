package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        String input = "- 2km + 3500m - 500m";
        Expression expression = Parser.parseExpression(input);

        System.out.println(expression.getOperands());
        System.out.println(expression);

        List<Double> operands = expression.getOperands();
        System.out.println("primul operand este: " + operands.get(0));

        MetricCalculator calculator = new MetricCalculator();
        double resultInMeters = calculator.calculate(expression);

        System.out.println(resultInMeters);

    }
}
