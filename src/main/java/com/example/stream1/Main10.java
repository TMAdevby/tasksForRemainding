package com.example.stream1;

import java.util.*;
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

        Map<Integer, Double> avgByCourse = students.stream()
                .collect(Collectors.groupingBy(Student::getCourse,Collectors.averagingDouble(Student::getAvgGrade)));

        System.out.println(avgByCourse);

        Student st = students.stream()
                .max(Comparator.comparingDouble(Student::getAvgGrade))
                .orElse(null);

        System.out.println("Max : " + st.getName() + " " + st.getAvgGrade());

        boolean isGreater  = students.stream()
                .anyMatch(s -> s.getAvgGrade() > 9.0);

        System.out.println(isGreater);

        boolean allYanger  = students.stream()
                .allMatch(s -> s.getAge() < 40);

        System.out.println(allYanger);

        String names = students.stream()
                .filter(s -> s.getAvgGrade() >= 7.0)
                .sorted(Comparator.comparing(Student::getName))
                .skip(1)
                .map(s -> s.getName())
                .reduce((acc, s) -> acc + " | " + s).get();

        System.out.println(names);

    }
}
