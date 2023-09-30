package org.example;

public class ArithmeticBrain implements CalcBrain{

    private String numberOne;
    private String numberTwo;
    private char operation;
    private DisplayListener displayListener;

    public ArithmeticBrain() {
        numberOne = "";
        numberTwo = "";
    }
    @Override
    public void pushDigit(String digit) {

    }

    @Override
    public void pushOperation(String operation) {

    }

    @Override
    public void evaluate() {

    }

    @Override
    public void registerDisplayListener(DisplayListener displayListener) {

    }

    @Override
    public void inputReceived(String input) {

    }
}
