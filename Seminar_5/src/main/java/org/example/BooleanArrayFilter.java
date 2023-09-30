package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BooleanArrayFilter implements Filter{
    /** Representation invariant:
     * if i-th element is present array[i] = true
     * Abstraction function:
     * Represents set of present elements
     */
    private boolean[] array;
    private final int DEFAULT_SIZE = 4;
    public BooleanArrayFilter(int size) {
        array = new boolean[size];
    }

    public BooleanArrayFilter() {
        array = new boolean[DEFAULT_SIZE];
    }
    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isPresent(int index) {
        if (index >= array.length || index < 0) {
            return false;
        }
        return array[index];
    }

    @Override
    public void add(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = true;
    }

    @Override
    public void remove(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = false;
    }

    private void grow(int newSize) {
        boolean[] temp = new boolean[newSize];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }
}
