package com.example.secondTask_string_char_byte;

import com.example.thirdTask_textAnalyzer.TextAnalyzer;

import java.nio.charset.StandardCharsets;

public class TextAnalyzerTest {
    public static void main(String[] args) {
        // 1. Создайте анализатор с тестовым текстом
        String testText = "Hello World Java Programming is awesome";
        TextAnalyzer analyzer = new TextAnalyzer(testText);

        // 2. Выведите статистику
        analyzer.printStatistics();

        // 3. Проверьте конвертации
        System.out.println("\n=== Conversions ===");

        // String → char[] → String
        char[] chars = analyzer.getChars();
        String restored1 = new String(chars);
        System.out.println("String → char[] → String: " + restored1.equals(testText));

        // String → byte[] → String
        byte[] bytes = analyzer.getBytes();
        String restored2 = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("String → byte[] → String: " + restored2.equals(testText));

        // 4. Проверьте массив слов
        System.out.println("\n=== Words ===");
        String[] words = analyzer.getWords();
        System.out.println("Total words: " + words.length);
        System.out.print("All words: ");
        for (String word : words) {
            System.out.print("[" + word + "] ");
        }
        System.out.println();

        // 5. Проверьте поиск самого частого символа
        System.out.println("\n=== Most Frequent Char ===");
        char frequent = analyzer.getMostFrequentChar();
        System.out.println("Most frequent: '" + frequent + "'");

        // 6. Проверьте поиск самого длинного слова
        System.out.println("\n=== Longest Word ===");
        String longest = analyzer.getLongestWord();
        System.out.println("Longest word: " + longest + " (length: " + longest.length() + ")");

        // 7. Проверьте реверс текста
        System.out.println("\n=== Reversed Text ===");
        String reversed = analyzer.reverseText();
        System.out.println("Original:  " + testText);
        System.out.println("Reversed:  " + reversed);

        // 8. Проверьте инкапсуляцию (геттеры возвращают копии)
        System.out.println("\n=== Encapsulation Check ===");
        char[] charsCopy1 = analyzer.getChars();
        char[] charsCopy2 = analyzer.getChars();
        System.out.println("Different array objects: " + (charsCopy1 != charsCopy2));

        // Измените копию — оригинал не должен измениться
        if (charsCopy1.length > 0) {
            charsCopy1[0] = 'X';
            char[] originalChars = analyzer.getChars();
            System.out.println("Original unchanged: " + (originalChars[0] != 'X'));
        }

        // 9. Тест с русским текстом (UTF-8)
        System.out.println("\n=== UTF-8 Test ===");
        TextAnalyzer ruAnalyzer = new TextAnalyzer("Привет мир");
        System.out.println("Original: " + ruAnalyzer.getOriginalText());
        System.out.println("Byte length: " + ruAnalyzer.getByteLength());
        System.out.println("Restored: " + new String(ruAnalyzer.getBytes(), StandardCharsets.UTF_8));
    }
}
