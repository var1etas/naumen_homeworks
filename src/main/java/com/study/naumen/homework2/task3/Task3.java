package com.study.naumen.homework2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task3 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee("Alex", 20, "IT",90000.0);
        Employee employee2 = new Employee("Sergey", 25, "IT",150000.0);
        Employee employee3 = new Employee("Veronika", 23, "Economic",80000.0);
        Employee employee4 = new Employee("Petya", 27, "Jurisprudence",110000.0);
        Employee employee5 = new Employee("Anya", 24, "Jurisprudence",120000.0);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);

        String department = "IT";
        Double sum = employeeList.stream().filter(e -> Objects.equals(e.getDepartment(), department)).mapToDouble(Employee::getSalary).sum() /
                employeeList.stream().filter(e -> Objects.equals(e.getDepartment(), department)).toList().size();
        System.out.println(sum);
    }
}
