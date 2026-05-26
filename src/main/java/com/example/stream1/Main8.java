package com.example.stream1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main8 {
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

        OptionalDouble marksSum = students.stream().filter(s -> s.getAge() <= 25 && s.getAvgGrade() >= 7)
                .mapToDouble(s -> s.getAvgGrade())
                .reduce((acc , s) -> acc + s);

        marksSum.ifPresent(s -> System.out.println(String.format("%.2f", s)));

        Optional<String> str = students.stream().filter(s -> s.getAge() <= 25 && s.getAvgGrade() >= 7)
                .map(s -> s.getName().toUpperCase())
                .reduce((acc , s) -> acc + ","+ s);

        String str2 = str.get();

        System.out.println(str2);

        Optional<Student> str3 = students.stream().filter(s -> s.getAge() <= 25 && s.getAvgGrade() >= 7)
                .reduce((acc, s) -> acc.getAvgGrade() >= s.getAvgGrade() ? acc : s);

        Student student = str3.get();

        System.out.println(student);
    }
}
