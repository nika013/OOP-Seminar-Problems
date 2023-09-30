package org.example.Version3;

public class MultiplyNode extends OperationNode {
    public MultiplyNode(Node left, Node right) {
        super(left, right);
    }
    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
