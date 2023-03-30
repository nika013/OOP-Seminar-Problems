package org.example;

public interface Filter {
    // Returns total number of objects.
    int size();

    // returns true if object is present at passed index
    boolean isPresent(int index);

    // Marks object with given index as present.
    void add(int index);

    // Removes object with given index from filter.
    void remove(int index);
}

