package org.example.Inheritances;

public class Test {
    public static void invoke(Parent obj) {
        obj.go();
    }

    public static void invoke(Child obj) {
        obj.go();
    }
}
