package com.example.fourth_stringMethds;

import java.nio.charset.StandardCharsets;

public class StringProcessorTest {
    public static void main(String[] args) {
        // 🔹 Тест 1: Базовые методы String
        System.out.println("=== String Methods Test ===");
        StringProcessor sp = new StringProcessor("  Hello World Java  ");

        System.out.println("Original: '" + sp.getOriginalText() + "'");
        System.out.println("Length: " + sp.getLength());  // 20
        System.out.println("Char at 0: '" + sp.getCharAt(0) + "'");  // ' '
        System.out.println("Substring [2,7]: '" + sp.getSubstring(2, 7) + "'");  // "Hello"
        System.out.println("Substring from 9: '" + sp.getSubstringFrom(9) + "'");  // "World Java  "

        // 🔹 Тест 2: Поиск
        System.out.println("\n=== Search Test ===");
        System.out.println("Index of 'World': " + sp.indexOf("World"));  // 9
        System.out.println("Last index of 'l': " + sp.lastIndexOf("l"));  // 10
        System.out.println("Contains 'Java': " + sp.contains("Java"));  // true
        System.out.println("Starts with '  He': " + sp.startsWith("  He"));  // true
        System.out.println("Ends with 'va  ': " + sp.endsWith("va  "));  // true

        // 🔹 Тест 3: Сравнение
        System.out.println("\n=== Comparison Test ===");
        System.out.println("Equals 'Hello': " + sp.equals("Hello"));  // false
        System.out.println("Equals ignore case '  HELLO WORLD JAVA  ': " +
                sp.equalsIgnoreCase("  HELLO WORLD JAVA  "));  // true
        System.out.println("CompareTo 'AAA': " + sp.compareTo("AAA"));  // > 0

        // 🔹 Тест 4: Трансформация
        System.out.println("\n=== Transformation Test ===");
        System.out.println("Upper: '" + sp.toUpperCase() + "'");
        System.out.println("Lower: '" + sp.toLowerCase() + "'");
        System.out.println("Trimmed: '" + sp.trim() + "'");
        System.out.println("Replace 'Java' with 'Programming': '" +
                sp.replaceAll("Java", "Programming") + "'");

        // 🔹 Тест 5: Split и Join
        System.out.println("\n=== Split/Join Test ===");
        String[] words = sp.trim().split(" ");
        System.out.print("Words: ");
        for (String w : words) System.out.print("[" + w + "] ");
        System.out.println();
        System.out.println("Joined with '-': " + String.join("-", words));

        // 🔹 Тест 6: Конвертации
        System.out.println("\n=== Conversions Test ===");
        char[] chars = sp.toCharArray();
        System.out.println("To char[]: " + new String(chars));
        byte[] bytes = sp.getBytes();
        System.out.println("To byte[] (UTF-8): length = " + bytes.length);
        System.out.println("ValueOf 42: '" + StringProcessor.valueOf(42) + "'");

        // 🔹 Тест 7: StringBuilder методы
        System.out.println("\n=== StringBuilder Test ===");
        StringProcessor sb = new StringProcessor("Hello");
        System.out.println("Start: '" + sb.getResult() + "'");

        sb.append(" World").append("!");
        System.out.println("After append: '" + sb.getResult() + "'");

        sb.insert(5, ",");
        System.out.println("After insert: '" + sb.getResult() + "'");

        sb.delete(5, 6);
        System.out.println("After delete: '" + sb.getResult() + "'");

        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt: '" + sb.getResult() + "'");

        sb.reverse();
        System.out.println("After reverse: '" + sb.getResult() + "'");

        sb.reset();
        System.out.println("After reset: '" + sb.getResult() + "'");

        // 🔹 Тест 8: Комплексные методы
        System.out.println("\n=== Complex Methods Test ===");
        StringProcessor complex = new StringProcessor("  Hello   World  ");
        System.out.println("Cleaned: '" + complex.cleanText() + "'");  // "hello world"

        System.out.println("Word count: " + complex.countWords());  // 2

        StringProcessor wordsRev = new StringProcessor("Hello World");
        System.out.println("Reverse each word: '" + wordsRev.reverseEachWord() + "'");  // "olleH dlroW"

        StringProcessor caesar = new StringProcessor("ABC");
        System.out.println("Caesar encode +1: '" + caesar.caesarEncode(1) + "'");  // "BCD"
        System.out.println("Caesar decode -1: '" + caesar.caesarDecode(1) + "'");  // "ABC"

        // 🔹 Тест 9: Инкапсуляция и цепочки вызовов
        System.out.println("\n=== Chain Calls Test ===");
        StringProcessor chain = new StringProcessor("test");
        String result = chain.append("123").append("XYZ").reverse().getResult();
        System.out.println("Chained result: '" + result + "'");  // "ZYX321tset"

        // 🔹 Тест 10: Ёмкость StringBuilder
        System.out.println("\n=== Capacity Test ===");
        StringProcessor cap = new StringProcessor("Hi");
        System.out.println("Initial length: " + cap.currentLength());
        System.out.println("Initial capacity: " + cap.capacity());
        cap.ensureCapacity(1000);
        System.out.println("After ensureCapacity(1000): " + cap.capacity());
    }
}
