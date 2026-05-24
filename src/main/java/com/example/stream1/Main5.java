package com.example.stream1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main5 {
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

        int[] arrayAges = users.stream().mapToInt(User::getAge).toArray();

        System.out.println(Arrays.toString(arrayAges));

        List<String> list = List.of("A", "B", "C");

        String[] arr = list.toArray(String[]::new);

        String[] arr2 = new String[]{"A", "B", "C"};

        List<String> list2 = new ArrayList<>(Arrays.asList(arr2));
    }
}
