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
        return getOriginalText().length();
        // Вспомните: .length() для String
    }

    // Символ по индексу
    public char getCharAt(int index) {
        return getOriginalText().charAt(index);
        // Вспомните: .charAt(index)
    }

    // Подстрока [start, end)
    public String getSubstring(int start, int end) {
        return getOriginalText().substring(start,end);
        // Вспомните: .substring(start, end)
    }

    // Подстрока от start до конца
    public String getSubstringFrom(int start) {
        return getOriginalText().substring(start);
        // Вспомните: .substring(start)
    }

    // 🔹 ПОИСК

    // Индекс первого вхождения подстроки
    public int indexOf(String substring) {
        return getOriginalText().indexOf(substring);
        // Вспомните: .indexOf(substring)
    }

    // Индекс последнего вхождения
    public int lastIndexOf(String substring) {
        return getOriginalText().lastIndexOf(substring);
        // Вспомните: .lastIndexOf(substring)
    }

    // Содержит ли строка подстроку
    public boolean contains(String substring) {
        return getOriginalText().contains(substring);
        // Вспомните: .contains(substring)
    }

    // Начинается ли с префикса
    public boolean startsWith(String prefix) {
        return getOriginalText().startsWith(prefix);
        // Вспомните: .startsWith(prefix)
    }

    // Заканчивается ли на суффикс
    public boolean endsWith(String suffix) {
        return getOriginalText().endsWith(suffix);
        // Вспомните: .endsWith(suffix)
    }

    // 🔹 СРАВНЕНИЕ

    // Равенство (учёт регистра)
    public boolean equals(String other) {
        return getOriginalText().equals(other);
        // Вспомните: .equals(other) — не == !
    }

    // Равенство (без учёта регистра)
    public boolean equalsIgnoreCase(String other) {
        return getOriginalText().equalsIgnoreCase(other);
        // Вспомните: .equalsIgnoreCase(other)
    }

    // Сравнение по алфавиту
    public int compareTo(String other) {
        return getOriginalText().compareTo(other);
        // Вспомните: .compareTo(other) — отрицательное/0/положительное
    }

    // 🔹 ТРАНСФОРМАЦИЯ

    // В верхний регистр
    public String toUpperCase() {
        return getOriginalText().toUpperCase();
        // Вспомните: .toUpperCase()
    }

    // В нижний регистр
    public String toLowerCase() {
        return getOriginalText().toLowerCase();
        // Вспомните: .toLowerCase()
    }

    // Убрать пробелы по краям
    public String trim() {
        return getOriginalText().trim();
        // Вспомните: .trim()
    }

    // Заменить все вхождения
    public String replaceAll(String target, String replacement) {
        return getOriginalText().replaceAll(target, replacement);
        // Вспомните: .replace(target, replacement) или .replaceAll(regex, repl)
    }

    // Заменить первое вхождение
    public String replaceFirst(String target, String replacement) {
        return getOriginalText().replaceFirst(target,replacement);
        // Вспомните: .replaceFirst(regex, replacement)
    }

    // Разбить на массив по разделителю
    public String[] split(String delimiter) {
        return getOriginalText().split(delimiter);
        // Вспомните: .split(delimiter) — delimiter это regex!
    }

    // 🔹 КОНКАТЕНАЦИЯ И ФОРМАТИРОВАНИЕ

    // Соединить с другой строкой
    public String concat(String other) {
        return getOriginalText().concat(other);
        // Вспомните: .concat(other) или оператор +
    }

    // Форматированная строка (как printf)
    public static String format(String pattern, Object... args) {
        return String.format(pattern,args);
        // Вспомните: String.format(pattern, args)
    }

    // Соединить массив строк с разделителем
    public static String join(String delimiter, String... parts) {
        return String.join(delimiter,parts);
        // Вспомните: String.join(delimiter, parts)
    }

    // 🔹 КОНВЕРТАЦИИ

    // В массив символов
    public char[] toCharArray() {
        return getOriginalText().toCharArray();
        // Вспомните: .toCharArray()
    }

    // В массив байт (UTF-8)
    public byte[] getBytes() {
        return getOriginalText().getBytes();
        // Вспомните: .getBytes(StandardCharsets.UTF_8)
    }

    // Из других типов в строку
    public static String valueOf(int value) {
        return String.valueOf(value);
        // Вспомните: String.valueOf(value)
    }





    public StringProcessor append(String text) {
        mutableText.append(text);
        return this;
        // Вспомните: mutableText.append(text)
        // Верните this для цепочки вызовов!
    }


    // Добавить число
    public StringProcessor append(int number) {
        mutableText.append(number);
        return this;
        // Вспомните: .append(number) — авто-конвертация
    }

    // Вставить в позицию
    public StringProcessor insert(int offset, String text) {
        mutableText.insert(offset,text);
        return this;
        // Вспомните: .insert(offset, text)
    }

    // 🔹 УДАЛЕНИЕ

    // Удалить диапазон [start, end)
    public StringProcessor delete(int start, int end) {
        mutableText.delete(start,end);
        return this;
        // Вспомните: .delete(start, end)
    }

    // Удалить один символ
    public StringProcessor deleteCharAt(int index) {
        mutableText.deleteCharAt(index);
        return this;
        // Вспомните: .deleteCharAt(index)
    }

    // 🔹 ЗАМЕНА И МОДИФИКАЦИЯ

    // Заменить символ в позиции
    public StringProcessor setCharAt(int index, char ch) {
        mutableText.setCharAt(index,ch);
        return this;
        // Вспомните: .setCharAt(index, ch)
    }

    // Заменить диапазон [start, end) на новую строку
    public StringProcessor replace(int start, int end, String text) {
        mutableText.replace(start, end, text);
        return this;
        // Вспомните: .replace(start, end, text)
    }

    // Перевернуть строку
    public StringProcessor reverse() {
        mutableText.reverse();
        return this;
        // Вспомните: .reverse()
    }

    // Установить новую длину (обрежет или дополнит нулями)
    public StringProcessor setLength(int newLength) {
        mutableText.setLength(newLength);
        return this;
        // Вспомните: .setLength(newLength)
    }

    // 🔹 ИНФОРМАЦИЯ

    // Текущая длина
    public int currentLength() {
        return mutableText.length();
        // Вспомните: .length() для StringBuilder
    }

    // Ёмкость (сколько можно добавить без реаллокации)
    public int capacity() {
        return mutableText.capacity();
        // Вспомните: .capacity()
    }

    // Гарантировать минимальную ёмкость
    public StringProcessor ensureCapacity(int minCapacity) {
        mutableText.ensureCapacity(minCapacity);
        // Вспомните: .ensureCapacity(minCapacity)
    }

    // 🔹 ПОЛУЧЕНИЕ РЕЗУЛЬТАТА

//    // Вернуть как String
//    public String toString() {
//        return getResult();
//        // Вспомните: .toString() для StringBuilder
//        // ⚠️ Не переопределяйте метод, если хотите использовать как обычный!
//        // Лучше: public String getResult()
//    }

    public String getResult() {
        return mutableText.toString();
    }

    // Сбросить к исходному тексту
    public StringProcessor reset() {
        mutableText = new StringBuilder(originalText);
        return this;
    }





        // Очистить текст: привести к нижнему регистру, убрать пробелы по краям, заменить множественные пробелы на один
        public String cleanText() {
            return mutableText.toString().
                        toLowerCase().
                        trim().
                        replaceAll("\\s+", " ");

            // 1. toLowerCase()
            // 2. trim()
            // 3. replaceAll(" +", " ") — regex: один или более пробелов
        }

        // Подсчитать количество слов (разделитель — пробел)
        public int countWords() {
            String[] arr = mutableText.toString().trim().split("\\s+");
            return arr.length;
            // 1. trim()
            // 2. split("\\s+") — regex: один или более пробельных символов
            // 3. Вернуть длину массива (или 0 если пустая строка)
        }

        // Перевернуть каждое слово в тексте (но не порядок слов!)
        // "Hello World" → "olleH dlroW"
        public String reverseEachWord() {
            String[] arr = mutableText.toString().split(" ");
            String result = "";
            for (int i = 0; i < arr.length; i++) {
                result += new StringBuilder(arr[i]).reverse();
            }
            return result;
            // 1. split(" ") → массив слов
            // 2. Для каждого слова: new StringBuilder(word).reverse().toString()
            // 3. String.join(" ", reversedWords)
        }

        // Закодировать: сдвинуть каждый символ на +1 (простой шифр Цезаря)
        public String caesarEncode(int shift) {
            char[] chars = mutableText.toString().toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];

                // Обрабатываем только буквы
                if (Character.isLetter(c)) {
                    // Определяем базу: 'A' для заглавных, 'a' для строчных
                    char base = Character.isUpperCase(c) ? 'A' : 'a';

                    // Формула с зацикливанием:
                    // 1. (c - base) → номер буквы в алфавите (0–25)
                    // 2. + shift → применяем сдвиг
                    // 3. + 26 → гарантируем положительное число (для отрицательных shift)
                    // 4. % 26 → зацикливаем в диапазоне 0–25
                    // 5. + base → возвращаем код символа нужного регистра
                    chars[i] = (char) ((c - base + shift + 26) % 26 + base);
                }
                // Небуквенные символы остаются без изменений
            }

            return new String(chars);
        }

        // Декодировать: сдвинуть на -shift
        public String caesarDecode(int shift) {
            return caesarEncode(-shift);
        }




        // Проверить, является ли строка палиндромом (игнорируя регистр и пробелы)
        public boolean isPalindrome() {
        return mutableText.equals(mutableText.reverse()) ? true : false;
        }

        // Подсчитать количество цифр в строке
        public int countDigits() {
        String text = getOriginalText();
        int count = 0;
            for (int i = 0; i < text.length() ; i++) {
               char c = text.charAt(i);
               if(Character.isDigit(c)){
                   count++;
               }
            }
            return count;
        }

        // Извлечь все цифры из строки в новую строку
        public String extractDigits() { ... }

        // Закодировать строку в Base64 и декодировать обратно
// (используйте java.util.Base64)
        public String encodeBase64() { ... }
        public String decodeBase64(String encoded) { ... }
    }