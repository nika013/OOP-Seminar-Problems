package org.example.Version3;

public class Main {
    public static void main(String[] args) {
        Node mult = new MultiplyNode(new ValueNode(5.0), new ValueNode(2));
        System.out.println(mult.evaluate());
        Node sum = new SumOperationNode(new ValueNode(10.0), new ValueNode(13));
        System.out.println(sum.evaluate());
    }
}