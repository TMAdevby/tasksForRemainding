package com.example.stream1;

import java.util.*;
import java.util.stream.Collectors;

public class Main6 {
    public static void main(String[] args) {
        List<String> cities = List.of("Moscow", "Kazan", "SPb", "Moscow", "Kazan");
        List<Double> salaries = List.of(50000.0, 75000.0, 60000.0, 120000.0, 45000.0);

// 1. Преобразуй `salaries` в примитивный массив `double[]`
        double[] salaryArray = salaries.stream().mapToDouble(Double::doubleValue).toArray();

// 2. Преобразуй `cities` в **изменяемый** список (чтобы можно было вызвать `.add("Novosibirsk")`)
        List<String> mutableCities = new ArrayList<>(cities);

// 3. Получи массив `String[]` из `cities`, а затем создай из него список-обёртку.
//    Попробуй заменить элемент по индексу и проверь, изменился ли исходный массив.
        String[] cityArr = cities.toArray(String[]::new);;
        List<String> cityView = new ArrayList<>(Arrays.asList(cityArr));
        cityView.set(0, "NEW_CITY");
        System.out.println(cityArr[0]); // Что выведет?

// 4. Собери уникальные города в `Set<String>` (два способа: через конструктор и через Stream)
        Set<String> uniqueCities1 = cities.stream().collect(Collectors.toSet());
        Set<String> uniqueCities2 = new HashSet<>(cities);
    }
}
