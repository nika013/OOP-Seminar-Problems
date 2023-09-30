package org.example.Version1;

import java.nio.charset.CharacterCodingException;

public class Node {
    private double value;
    private boolean isOperation;
    private char op;
    private Node left;
    private Node right;

    public Node(double value) {
        this.value = value;
        isOperation = false;
        left = null;
        right = null;
    }

    public Node(char op, Node left, Node right) {
        this.op = op;
        isOperation = true;
        this.left = left;
        this.right = right;
    }

    public Node(char op, double lVal, double rVal, char op1) {
        this(op, new Node(lVal), new Node(rVal));
    }

    public double evaluate() {
        double result = 1.0;
        if (isOperation) {
            try {
                result = compute();
            } catch (CharacterCodingException e) {
                System.out.println("Not valid operation character");
            }
        } else {
            return value;
        }
        return result;
    }

    private double compute() throws CharacterCodingException {
        if (op == '+') {
            return left.evaluate() + right.evaluate();
        } else if (op == '-') {
            return left.evaluate() - right.evaluate();
        } else if (op == '*') {
            return left.evaluate() * right.evaluate();
        } else if (op == '/') {
            return left.evaluate() * right.evaluate();
        } else {
            throw new CharacterCodingException();
        }
    }

    @Override
    public String toString() {
        if (isOperation) {
            return "(" + left.toString()
                    + op + right.toString() + ")";
        }
        return null;
    }
}
