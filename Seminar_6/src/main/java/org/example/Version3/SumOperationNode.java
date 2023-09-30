package org.example.Version3;

public class SumOperationNode extends OperationNode {
    public SumOperationNode(Node left, Node right) {
        super(left, right);
    }
    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
