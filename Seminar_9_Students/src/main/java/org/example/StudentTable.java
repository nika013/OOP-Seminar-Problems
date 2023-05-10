package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTable extends AbstractTableModel {
    private List<Student> students;
    private String[] headerNames = { "First Name", "Last Name", "Year" };


    public StudentTable() {
        students = new ArrayList<>();
    }
    @Override
    public String getColumnName(int column){
        return headerNames[column];
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return headerNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        try {
//            Student s = students.get(rowIndex);
//            if (columnIndex == 0) {
//                return s.getFirstName();
//            } else if (columnIndex == 1) {
//                return s.getLastName();
//            } else if (columnIndex == 2) {
//                return s.getYear();
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println();
//        }
//        return null;
        Student s = students.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> s.getFirstName();
            case 1 -> s.getLastName();
            case 2 -> s.getYear();
            default -> throw new ArrayIndexOutOfBoundsException("columnIndex is incorrect");
        };
    }
}
