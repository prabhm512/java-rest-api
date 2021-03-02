package io.github.prabhm512.mathsapi.model;

public class Math {
	
	private String num1;
	private String num2;
	private String operation;

    public Math(String num1, String num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    // Getters
    public int getNum1() {
        return Integer.parseInt(num1);
    }

    public int getNum2() {
        return Integer.parseInt(num2);
    }

    public String getOperation() {
        return operation;
    }

    // Setters
    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    // Get Result
    public int getResult() {
        if (getOperation() == "plus") {
            return getNum1() + getNum2(); 
        }
        else if (getOperation() == "minus") {
            return getNum1() - getNum2();
        }
        else if (getOperation() == "divide") {
            return getNum1() / getNum2();
        }
        else if (getOperation() == "multiply") {
            return getNum1() * getNum2();
        }
        else {
            return 0;
        }
    }
}