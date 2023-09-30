package org.example.Version3;

public abstract class OperationNode implements Node {

    protected Node left;
    protected Node right;
    public OperationNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
