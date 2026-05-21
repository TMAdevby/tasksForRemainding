package com.example.lambdas6;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name; this.age = age; this.salary = salary;
    }
    @Override public String toString() {
        return name + " (возраст: " + age + ", з/п: " + (int)salary + ")";
    }
    // геттеры нужны для метод-ссылок (или делай поля public для простоты)
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
}
