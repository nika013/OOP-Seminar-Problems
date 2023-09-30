package org.example.Version2;

public class OperationNode implements Node {
    private final char operation;
    private Node left;
    private Node right;
    public OperationNode(char operation, Node left, Node right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public OperationNode(char operation, double lVal, double rVal) {
        this.operation = operation;
        this.left = new ValueNode(lVal);
        this.right = new ValueNode(rVal);
    }

    @Override
    public double evaluate() {
        double result = 1.0;
        switch (operation) {
            case '*': result = left.evaluate() * right.evaluate(); break;
            case '-': result = left.evaluate() * right.evaluate(); break;
            case '+': result =  left.evaluate() * right.evaluate(); break;
            case '/': result = left.evaluate() * right.evaluate(); break;
            default:
                System.out.println("Error in opration");
        }
        return result;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + operation + right.toString() + ")";
    }

}
