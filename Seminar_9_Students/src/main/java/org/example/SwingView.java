package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SwingView {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField yearField;
    private JFrame frame;
    private JTextField firstNameFilter;
    private JTextField lastNameFilter;
    private JTextField yearFilter;
    private JButton create;
    private JButton filter;
    private StudentTable studentTable;
    private StudentStore store;

    public SwingView() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        store = new StudentStore();

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel, BorderLayout.NORTH);

        JPanel createPanel = new JPanel(new GridLayout(2, 4));

        initialize(createPanel);

        mainPanel.add(createPanel, BorderLayout.NORTH);
        displayTable(mainPanel);

        frame.add(mainPanel);
        addEventListeners();
    }

    private void displayTable(JPanel mainPanel) {
        studentTable = new StudentTable();
        JTable table = new JTable();

        table.setModel(studentTable);
        mainPanel.add(table, BorderLayout.CENTER);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(table, BorderLayout.CENTER);

        mainPanel.add(tablePanel);
        studentTable.setStudents(store.getStudents());
    }

    private void initialize(JPanel createPanel) {
        firstNameField = new JTextField("first name");
        lastNameField = new JTextField("last name");
        yearField = new JTextField("year");
        create = new JButton("create");

        firstNameFilter = new JTextField("Filter name");
        lastNameFilter = new JTextField("Filter last name");
        yearFilter = new JTextField("Fitler year");
        filter = new JButton("filter");

        createPanel.add(firstNameField);
        createPanel.add(lastNameField);
        createPanel.add(yearField);
        createPanel.add(create);

        createPanel.add(firstNameFilter);
        createPanel.add(lastNameFilter);
//        createPanel.add(yearFilter);
        createPanel.add(filter);
    }

    private void addEventListeners() {
        createListener();
        filterListener();
    }

    private void filterListener() {
        filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameFilter.getText();
                String lastName = lastNameFilter.getText();
                firstNameFilter.setText("");
                lastNameFilter.setText("");
                AndFilter filters = new AndFilter();
                if (!firstName.isEmpty()) filters.addFilter(new FirstNameFilter(firstName));
                if (!lastName.isEmpty()) filters.addFilter(new LastNameFilter(lastName));
                studentTable.setStudents(store.filter(filters));
            }
        });
    }

    private void createListener() {
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String year = yearField.getText();
                if (validate(firstName, lastName, year)) {
                    Student newStudent = new Student(firstName, lastName, Integer.parseInt(year));
                    store.addStudent(newStudent);
                    studentTable.setStudents(store.getStudents());
                }
            }
        });
    }

    private boolean validate(String firstName, String lastName, String year) {
        return !firstName.isEmpty() && !lastName.isEmpty()
                && !year.isEmpty() && year.matches("\\d+");
    }

    public void show() {
        frame.setVisible(true);
    }
}
