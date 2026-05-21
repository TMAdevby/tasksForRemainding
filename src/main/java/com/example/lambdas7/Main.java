package com.example.lambdas7;
import java.util.function.Predicate;


public class Main {
    public static Predicate<String> getValidator(String ruleType) throws IllegalArgumentException{
        switch (ruleType) {
            case "email":
                return s -> s.contains("@") && s.contains(".");
            case "strong_pwd":
                return s -> s.length() >= 8;
            case "phone":
                return s -> s.matches("\\d{10,12}");
            default:
                throw new IllegalArgumentException("Unknown rule: " + ruleType);
        }
    }

    public static void main(String[] args) {
        Predicate<String> pr1 = Main.getValidator("email");
        Predicate<String> pr2 = Main.getValidator("strong_pwd");
        Predicate<String> pr3 = Main.getValidator("phone");

        boolean res1 = pr1.test("mtipun@mail.ru");
        System.out.println(res1);
        boolean res2 = pr1.test("mtipunmail.ru");
        System.out.println(res2);
        boolean res3 = pr2.test("qwertyuiop");
        System.out.println(res3);
        boolean res4 = pr2.test("qwerty");
        System.out.println(res4);
        boolean res5 = pr3.test("02323");
        System.out.println(res5);
        boolean res6 = pr3.test("000111222333");
        System.out.println(res6);
    }
}
