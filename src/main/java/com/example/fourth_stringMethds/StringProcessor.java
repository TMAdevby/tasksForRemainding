package com.example.fourth_stringMethds;

public class StringProcessor {
    private String originalText;  // Исходный текст
    private StringBuilder mutableText;  // Для модификаций

    // Конструктор
    public StringProcessor(String text) {
        this.originalText = text;
        this.mutableText = new StringBuilder(text);
    }

    // Геттеры
    public String getOriginalText() {
        return originalText; }
    public String getCurrentText() {
        return mutableText.toString(); }


    // Длина строки
    public int getLength() {
        // Вспомните: .length() для String
    }

    // Символ по индексу
    public char getCharAt(int index) {
        // Вспомните: .charAt(index)
    }

    // Подстрока [start, end)
    public String getSubstring(int start, int end) {
        // Вспомните: .substring(start, end)
    }

    // Подстрока от start до конца
    public String getSubstringFrom(int start) {
        // Вспомните: .substring(start)
    }

    // 🔹 ПОИСК

    // Индекс первого вхождения подстроки
    public int indexOf(String substring) {
        // Вспомните: .indexOf(substring)
    }

    // Индекс последнего вхождения
    public int lastIndexOf(String substring) {
        // Вспомните: .lastIndexOf(substring)
    }

    // Содержит ли строка подстроку
    public boolean contains(String substring) {
        // Вспомните: .contains(substring)
    }

    // Начинается ли с префикса
    public boolean startsWith(String prefix) {
        // Вспомните: .startsWith(prefix)
    }

    // Заканчивается ли на суффикс
    public boolean endsWith(String suffix) {
        // Вспомните: .endsWith(suffix)
    }

    // 🔹 СРАВНЕНИЕ

    // Равенство (учёт регистра)
    public boolean equals(String other) {
        // Вспомните: .equals(other) — не == !
    }

    // Равенство (без учёта регистра)
    public boolean equalsIgnoreCase(String other) {
        // Вспомните: .equalsIgnoreCase(other)
    }

    // Сравнение по алфавиту
    public int compareTo(String other) {
        // Вспомните: .compareTo(other) — отрицательное/0/положительное
    }

    // 🔹 ТРАНСФОРМАЦИЯ

    // В верхний регистр
    public String toUpperCase() {
        // Вспомните: .toUpperCase()
    }

    // В нижний регистр
    public String toLowerCase() {
        // Вспомните: .toLowerCase()
    }

    // Убрать пробелы по краям
    public String trim() {
        // Вспомните: .trim()
    }

    // Заменить все вхождения
    public String replaceAll(String target, String replacement) {
        // Вспомните: .replace(target, replacement) или .replaceAll(regex, repl)
    }

    // Заменить первое вхождение
    public String replaceFirst(String target, String replacement) {
        // Вспомните: .replaceFirst(regex, replacement)
    }

    // Разбить на массив по разделителю
    public String[] split(String delimiter) {
        // Вспомните: .split(delimiter) — delimiter это regex!
    }

    // 🔹 КОНКАТЕНАЦИЯ И ФОРМАТИРОВАНИЕ

    // Соединить с другой строкой
    public String concat(String other) {
        // Вспомните: .concat(other) или оператор +
    }

    // Форматированная строка (как printf)
    public static String format(String pattern, Object... args) {
        // Вспомните: String.format(pattern, args)
    }

    // Соединить массив строк с разделителем
    public static String join(String delimiter, String... parts) {
        // Вспомните: String.join(delimiter, parts)
    }

    // 🔹 КОНВЕРТАЦИИ

    // В массив символов
    public char[] toCharArray() {
        // Вспомните: .toCharArray()
    }

    // В массив байт (UTF-8)
    public byte[] getBytes() {
        // Вспомните: .getBytes(StandardCharsets.UTF_8)
    }

    // Из других типов в строку
    public static String valueOf(int value) {
        // Вспомните: String.valueOf(value)
    }





    public StringProcessor append(String text) {
        // Вспомните: mutableText.append(text)
        // Верните this для цепочки вызовов!
    }

    // Добавить число
    public StringProcessor append(int number) {
        // Вспомните: .append(number) — авто-конвертация
    }

    // Вставить в позицию
    public StringProcessor insert(int offset, String text) {
        // Вспомните: .insert(offset, text)
    }

    // 🔹 УДАЛЕНИЕ

    // Удалить диапазон [start, end)
    public StringProcessor delete(int start, int end) {
        // Вспомните: .delete(start, end)
    }

    // Удалить один символ
    public StringProcessor deleteCharAt(int index) {
        // Вспомните: .deleteCharAt(index)
    }

    // 🔹 ЗАМЕНА И МОДИФИКАЦИЯ

    // Заменить символ в позиции
    public StringProcessor setCharAt(int index, char ch) {
        // Вспомните: .setCharAt(index, ch)
    }

    // Заменить диапазон [start, end) на новую строку
    public StringProcessor replace(int start, int end, String text) {
        // Вспомните: .replace(start, end, text)
    }

    // Перевернуть строку
    public StringProcessor reverse() {
        // Вспомните: .reverse()
    }

    // Установить новую длину (обрежет или дополнит нулями)
    public StringProcessor setLength(int newLength) {
        // Вспомните: .setLength(newLength)
    }

    // 🔹 ИНФОРМАЦИЯ

    // Текущая длина
    public int currentLength() {
        // Вспомните: .length() для StringBuilder
    }

    // Ёмкость (сколько можно добавить без реаллокации)
    public int capacity() {
        // Вспомните: .capacity()
    }

    // Гарантировать минимальную ёмкость
    public StringProcessor ensureCapacity(int minCapacity) {
        // Вспомните: .ensureCapacity(minCapacity)
    }

    // 🔹 ПОЛУЧЕНИЕ РЕЗУЛЬТАТА

    // Вернуть как String
    public String toString() {
        // Вспомните: .toString() для StringBuilder
        // ⚠️ Не переопределяйте метод, если хотите использовать как обычный!
        // Лучше: public String getResult()
    }

    public String getResult() {
        return mutableText.toString();
    }

    // Сбросить к исходному тексту
    public StringProcessor reset() {
        mutableText = new StringBuilder(originalText);
        return this;
    }




    public class StringProcessor {
        // ... предыдущие методы ...

        // 🔹 КОМПЛЕКСНЫЕ ОПЕРАЦИИ

        // Очистить текст: привести к нижнему регистру, убрать пробелы по краям, заменить множественные пробелы на один
        public String cleanText() {
            // 1. toLowerCase()
            // 2. trim()
            // 3. replaceAll(" +", " ") — regex: один или более пробелов
        }

        // Подсчитать количество слов (разделитель — пробел)
        public int countWords() {
            // 1. trim()
            // 2. split("\\s+") — regex: один или более пробельных символов
            // 3. Вернуть длину массива (или 0 если пустая строка)
        }

        // Перевернуть каждое слово в тексте (но не порядок слов!)
        // "Hello World" → "olleH dlroW"
        public String reverseEachWord() {
            // 1. split(" ") → массив слов
            // 2. Для каждого слова: new StringBuilder(word).reverse().toString()
            // 3. String.join(" ", reversedWords)
        }

        // Закодировать: сдвинуть каждый символ на +1 (простой шифр Цезаря)
        public String caesarEncode(int shift) {
            // 1. toCharArray()
            // 2. Для каждого символа: (char)(c + shift)
            // 3. new String(modifiedChars)
        }

        // Декодировать: сдвинуть на -shift
        public String caesarDecode(int shift) {
            // Тот же метод, но с отрицательным сдвигом
        }




        // Проверить, является ли строка палиндромом (игнорируя регистр и пробелы)
        public boolean isPalindrome() { ... }

        // Подсчитать количество цифр в строке
        public int countDigits() { ... }

        // Извлечь все цифры из строки в новую строку
        public String extractDigits() { ... }

        // Закодировать строку в Base64 и декодировать обратно
// (используйте java.util.Base64)
        public String encodeBase64() { ... }
        public String decodeBase64(String encoded) { ... }
    }
}
