package org.example;
import org.example.Inheritances.*;

public class Main {
    public static void main(String[] args) {
        Parent pP = new Parent();
        Child chCh = new Child();
        Parent pCh = new Child();
        Parent pBCh = new BetterChild(); // polymorphism can be done like this
        // Child chP = new Parent(); // this cannot be done
        Test.invoke(pP);
        Test.invoke(chCh);
        Test.invoke(pCh);
        Test.invoke(pBCh);
        // Test.invoke((Child) pP); this cannot be done
        Test.invoke((Parent) chCh); // still prints go method in child class
    }
}