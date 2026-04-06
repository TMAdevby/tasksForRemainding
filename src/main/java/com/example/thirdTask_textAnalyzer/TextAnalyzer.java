import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TextAnalyzer {
    // 🔹 Объявите поля (private для инкапсуляции)
    private String originalText;
    private char[] chars;
    private byte[] bytes;
    private String[] words;

    // 🔹 Конструктор
    public TextAnalyzer(String text) {
        this.originalText = text;
        // Конвертируйте String → char[]
        this.chars = text.toCharArray();
        // Конвертируйте String → byte[] (UTF-8)
        this.bytes = text.getBytes();
        // Разбейте текст на слова: "привет мир" → ["привет", "мир"]
        this.words = text.split(" ");
        // Вспомните: .split(" ")
    }

    // 🔹 Геттеры (возвращают копии массивов!)
    public String getOriginalText() {
        return originalText;
    }

    public char[] getChars() {
        // Верните КОПИЮ массива, а не ссылку!
        return Arrays.copyOf(chars,chars.length);
        // Вспомните: Arrays.copyOf()

    }

    public byte[] getBytes() {
        return Arrays.copyOf(bytes,bytes.length);
    }

    public String[] getWords() {
        return Arrays.copyOf(words, words.length);
    }

    // 🔹 Методы анализа

    // Длина текста в символах
    public int getLength() {
        // Вспомните: .length для массивов, .length() для String
        return originalText.length();
    }

    // Длина текста в байтах
    public int getByteLength() {
        return bytes.length;
    }

    // Количество слов
    public int getWordCount() {
        return words.length;
    }

    // Самый частый символ (без пробелов)
    public char getMostFrequentChar() {
        // 1. Пройдитесь по массиву chars
        int max = 0;
        int match = 0;
        int index = -1;
        for(int i = 0; i < chars.length; i++){
            for (int j = i + 1; j < chars.length ; j++) {
                if(chars[i] == chars[j]){
                    match++;
                }
            }
            if (max < match) {
                max = match;
                index = i;
            }
        }

        return chars[index];
        // 2. Посчитайте частоту каждого символа (можно через массив int[256] или HashMap)
        // 3. Верните символ с максимальной частотой
        // Подсказка: для простоты можно использовать массив int[128] для ASCII
    }

    // Самое длинное слово
    public String getLongestWord() {
        // 1. Пройдитесь по массиву words
        int length = 0;
        int maxLength = 0;
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            length = words[i].length();
            if(maxLength < length){
                maxLength = length;
                index = i;
            }
        }
         return words[index];
        // 2. Найдите слово с максимальной длиной
        // 3. Верните его
    }

    // Текст задом наперёд
    public String reverseText() {
        // 1. Создайте копию массива chars
        char[] copyChars = Arrays.copyOf(chars,chars.length);
        // 2. Переверните массив (первый ↔ последний)
        for (int i = 0; i < chars.length; i++) {
            copyChars[i] = chars[chars.length - 1 - i];
        }
        return new String(copyChars);
        // 3. Конвертируйте обратно в String
        // Вспомните: new String(char[])
    }

    // 🔹 Метод для вывода статистики
    public void printStatistics() {
        System.out.println("=== Text Statistics ===");
        System.out.println("Original: " + originalText);
        System.out.println("Length (chars): " + getLength());
        System.out.println("Length (bytes): " + getByteLength());
        System.out.println("Word count: " + getWordCount());
        System.out.println("Most frequent char: '" + getMostFrequentChar() + "'");
        System.out.println("Longest word: " + getLongestWord());
        System.out.println("Reversed: " + reverseText());
    }
}