package org.example;

public class Main {
    public static void main(String[] args) {
        CalcBrain brain = new ArithmeticBrain();
        CalcView view = new SwingView();
        CalcController controller = new CalcController(brain, view);
        controller.start();
    }
}