package com.example.lambdas6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Иван", 28, 9000));
        staff.add(new Employee("Мария", 25, 8500));
        staff.add(new Employee("Алексей", 22, 7000));
        staff.add(new Employee("Елена", 28, 9500));
        staff.add(new Employee("Дмитрий", 22, 6500));

        Comparator<Employee> salaryComp = (e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary());

        staff.sort(salaryComp);
        System.out.println(staff);
    }
}


