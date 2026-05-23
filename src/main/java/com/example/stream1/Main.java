package com.example.stream1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 25, 50000, "Moscow", true),
                new User("Bob", 30, 75000, "SPb", false),
                new User("Charlie", 25, 60000, "Moscow", true),
                new User("Diana", 40, 120000, "Kazan", true),
                new User("Eve", 22, 45000, "SPb", true),
                new User("Frank", 35, 80000, "Moscow", false),
                new User("Grace", 28, 95000, "Kazan", true)
        );
    }
}
