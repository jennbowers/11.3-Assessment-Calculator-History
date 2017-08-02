package com.jennbowers.calculatorjpa.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WebCalculator")
public class WebCalculator {
    private long id;
    private String name;
    private double operand1;
    private String operator;
    private double operand2;
    private double solution;

    public WebCalculator() {
    }

    public WebCalculator(long id, String name, double operand1, String operator, double operand2, double solution) {
        this.id = id;
        this.name = name;
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
        this.solution = solution;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public double getSolution() {
        return solution;
    }

    public void setSolution(double solution) {
        this.solution = solution;
    }
}
