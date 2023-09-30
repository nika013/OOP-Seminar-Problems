package employees;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class EmployeeCatalog {
    List<Employee> employees;
    public EmployeeCatalog(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee findEmployeeWithHighestSalary() {
        AtomicInteger maxSal = new AtomicInteger(Integer.MIN_VALUE);
        AtomicReference<Employee> maxEmp = null;
        employees.stream().map((emp) -> {
            if (emp.getSalary() > maxSal.get()) {
                maxSal.set(emp.getSalary());
                maxEmp.set(emp);
            }
            return emp;
        });
        return maxEmp.get();
    }
    public Employee findEmployeeWithHighestSalaryV2(List<Employee> emps) {
        return emps.stream().reduce(null, (maxSalEmp, employee) -> {
            if (maxSalEmp == null) return employee;
            if (maxSalEmp.getSalary() < employee.getSalary()) {
                return employee;
            }
            return maxSalEmp;
        });
    }

    public int getSalaryGapInDepartment(Employee.Department department) {
        List<Employee> depEmps = employees.stream()
                .filter((emp) -> emp.getDepartment() == department)
                .toList();
        int maxSal = findEmployeeWithHighestSalaryV2(depEmps).getSalary();
        int minSal = employees.stream().reduce(null, (minSalEmp, employee) -> {
            if (minSalEmp == null) return employee;
            if (minSalEmp.getSalary() > employee.getSalary()) {
                return employee;
            }
            return minSalEmp;
        }).getSalary();
        return maxSal - minSal;
    }

    private class DepSal {
        private Employee.Department depNum;
        private int sal;
        public DepSal(Employee.Department depNum) {
            this.depNum = depNum;
        }
        public int add(int sal, int nextSal) {
            return sal += nextSal;
        }

        public Employee.Department getDepNum() {
            return depNum;
        }
    }

    public Employee.Department findDepartmentWithHighestCumulativeSalary() {
        Stream<Employee> stream = employees.stream();
        stream.map((emp) -> {
            DepSal depSal = new DepSal(emp.getDepartment());
            Employee blob = new Employee("asd", "asd",
                    depSal.getDepNum(), 0);
            int sal = stream.filter((emp2) -> depSal.getDepNum() == emp2.getDepartment())
                    .reduce(blob, (a, b) -> a.getSalary() + b.getSalary());
            depSal.sal = sal;
            return depSal;
        });

        return null;
    }
}