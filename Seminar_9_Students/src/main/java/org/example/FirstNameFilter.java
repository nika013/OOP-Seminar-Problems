package org.example;

public class FirstNameFilter implements Filter{

    private String compare;

    public FirstNameFilter(String compare) {
        this.compare = compare;
    }
    @Override
    public boolean contains(Student s) {
        return s.getFirstName().contains(compare);
    }
}
