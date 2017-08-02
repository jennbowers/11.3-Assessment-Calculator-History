package com.jennbowers.calculatorjpa.helpers;

public class Calculations {
    public static double calculator(Double firstOperand, String operator, Double secondOperand) {
        double result= 0;
        switch(operator) {
            case "+":
                result = firstOperand + secondOperand;
                System.out.println(firstOperand + operator + secondOperand);
                System.out.println(result);
                break;
            case "-":
                result = firstOperand - secondOperand;
                System.out.println(firstOperand + operator + secondOperand);
                System.out.println(result);
                break;
            case "*":
                result = firstOperand * secondOperand;
                System.out.println(firstOperand + operator + secondOperand);
                System.out.println(result);
                break;
            case "/":
                result = firstOperand / secondOperand;
                System.out.println(firstOperand + operator + secondOperand);
                System.out.println(result);
                break;
            default:
                break;
        }
        return result;
    }
}
