package org.example;

public interface CalcBrain extends InputListener {
    void pushDigit(String digit);
    void pushOperation(String operation);
    void evaluate();
    void registerDisplayListener(DisplayListener displayListener);
}
