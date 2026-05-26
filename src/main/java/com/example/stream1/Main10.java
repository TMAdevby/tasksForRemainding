package com.example.stream1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main10 {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        List<String> stList = students.stream()
                .filter(e -> e.getSex() == 'f')
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println(stList);

        students.stream()
                .sorted((e1,e2) -> Double.compare(e2.getAvgGrade(), e1.getAvgGrade()))
                .limit(3)
                .map(e -> String.format("%s gr : %.2f", e.getName(), e.getAvgGrade()) )
                .forEach(System.out::println);





    }
}
