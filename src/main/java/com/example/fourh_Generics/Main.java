package com.example.fourh_Generics;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SafeContainer<Integer>> containers = List.of(
                new SafeContainer<>(5),
                new SafeContainer<>(12),
                new SafeContainer<>(3)
        );

        System.out.println(containers.get(0).isGreater(containers.get(2))); // true (5 > 3)

        Integer max = SafeContainer.findMax(containers);
        System.out.println(max); // 12
    }
}
