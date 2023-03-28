package org.example;

import java.util.Arrays;

public class MyStack<T> {
    private Object[] elems;
    private int logLen;
    public MyStack() {
        elems = new Object[4];
        logLen = 0;
    }
    public void push(T elem) {
        // resize and copy elements to another array
        if (logLen == elems.length) {
            int doubleLen = 2 * elems.length;
            elems = Arrays.copyOf(elems, doubleLen);
        }
        elems[logLen] = elem;
        logLen++;
    }

    public T pop() {
        if (logLen == 0) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        logLen--;
        T res = (T)elems[logLen];
        elems[logLen] = null;
        return res;
    }

    public int size() {
        return logLen;
    }
}
