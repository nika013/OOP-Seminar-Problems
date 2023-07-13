package org.example.Interfaces;

public class Mobile extends Phone {
    @Override
    public void makeCall(String number) {
        System.out.println("calling: " + number);
    }

    @Override
    public void plugin() {
        System.out.println("Is plugged");
    }

    @Override
    public void on() {
        System.out.println("On");
    }

    @Override
    public void off() {
        System.out.println("Off");
    }
}
