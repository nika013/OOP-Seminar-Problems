package org.example;

public interface Filter {
    int size();
    boolean isPresent(int index);
    void add(int index);
    void remove(int index);
}

