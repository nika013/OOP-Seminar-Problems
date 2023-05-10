package org.example;

public class LastNameFilter implements Filter {
    private String compare;

    public LastNameFilter(String lastName) {
        compare = lastName;
    }

    public void setComp(String compare) {
        this.compare = compare;
    }
    @Override
    public boolean contains(Student s) {
        return s.getLastName().contains(compare);
    }
}
