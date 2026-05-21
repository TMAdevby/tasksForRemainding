package com.example.lambdas3;

public class Main {
    static int coefficient = 5;

    private static void applyModification(int baseValue, NumberModifier modifier){
        int result = modifier.modify(baseValue);
        System.out.printf("База: %d → Результат: %d", baseValue,result);
    }

    public static void main(String[] args) {
        Main.applyModification(4, n -> n * coefficient + 10);
    }
}

interface NumberModifier{
    int modify(int n);
}
