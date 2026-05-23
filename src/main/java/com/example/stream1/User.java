package com.example.stream1;

class User {
    String name;
    int age;
    double salary;
    String city;
    boolean active;

    User(String name, int age, double salary, String city, boolean active) {
        this.name = name; this.age = age; this.salary = salary;
        this.city = city; this.active = active;
    }
    // геттеры...
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getCity() { return city; }
    public boolean isActive() { return active; }

    @Override public String toString() { return name; }
}
