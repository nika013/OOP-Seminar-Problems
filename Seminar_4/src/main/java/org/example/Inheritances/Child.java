package org.example.Inheritances;

public class Child extends Parent {
    @Override
    public void go() {
        System.out.println("go method in Child class");
    }

    public void run() {
        System.out.println("Child is running");
    }

}
