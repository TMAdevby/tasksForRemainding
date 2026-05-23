package com.example.stream1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
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

        List<String> nameList = users.stream().map(user -> user.getName()).collect(Collectors.toList());

        nameList.stream().forEach(System.out::println);
    }
}
