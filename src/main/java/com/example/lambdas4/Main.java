package com.example.lambdas4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "lambda", "code", "spring", "api");
        List<String> words2 = new ArrayList<>(words);

        Predicate<String> predicate = s -> s.length() <= 4;
        Function<String, String> function = s -> s.toUpperCase();
        Consumer<String> consumer = s -> System.out.println("Префикс " + s);

        Iterator<String> iterator = words2.iterator();

        while (iterator.hasNext()) {
            String word = iterator.next();

            if (predicate.test(word)) {
                continue;
            }
            String transformed = function.apply(word);

            consumer.accept(transformed);
        }
}
}
