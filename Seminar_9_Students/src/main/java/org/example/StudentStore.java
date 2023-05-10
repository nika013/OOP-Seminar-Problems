package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentStore {
    private List<Student> students;

    public StudentStore(List<Student> students) {
        this.students = students;
    }

    public StudentStore() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> filter(AndFilter filters) {
        List<Student> filtered = new ArrayList<>();
        for (Student student : students) {
            if (filters.contains(student)) {
                filtered.add(student);
            }
        }
        return filtered;
    }

    private boolean checkYear(int studYear, int filtYear) {
        return filtYear != -1 && studYear == filtYear;
    }

    private boolean containsString(String studName, String filterName) {
        return studName.contains(filterName);
    }
}
