package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        String input = "2km + 500m - 5000dm";
        Expression expression = Parser.parseExpression(input);

        System.out.println(expression.getOperands());
        System.out.println(expression);

        MetricCalculator calculator = new MetricCalculator();
        double resultInMeters = calculator.calculate(expression);

        System.out.println(resultInMeters);

    }
}
