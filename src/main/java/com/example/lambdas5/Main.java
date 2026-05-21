package com.example.lambdas5;
import org.w3c.dom.ls.LSOutput;

import java.util.function.Function;
public class Main {
    public static void main(String[] args) {
    Function<String, String> trim = String::trim;
    Function<String, String> upper = String::toUpperCase;
    Function<String, String> addTag = s -> s + " [OK]";

    Function<String, String> all = trim.andThen(upper).andThen(addTag);

    String result = all.apply("   hello java   ");
        System.out.println(result);
    }
}


