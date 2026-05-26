package com.example.stream1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main9 {
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

        students.stream()
                .filter(s -> s.getAge() <= 30)
                .sorted((s1,s2) -> Double.compare(s2.getAvgGrade(), s1.getAvgGrade()))
                .limit(3)
                .map(s -> String.format("[%s] - балл: %.2f",s.getName(),s.getAvgGrade()))
                .forEach(System.out::println);

        List<Student> studentList = students.stream()
                .sorted(Comparator
                        .comparing(Student::getSex)
                        .thenComparingInt(Student::getAge)
                        .thenComparing(Student::getName))
                .collect(Collectors.toList());

        for (Student s : studentList){
            System.out.println(s);
        }




    }
}
