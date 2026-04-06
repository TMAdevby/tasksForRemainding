package com.example.secondTask_string_char_byte;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ValidProfile {
    // 🔹 Объявите поля (private для инкапсуляции)
    private String username;
    private char[] passwordChars;
    private byte[] passwordBytes;

    // 🔹 Конструктор
    public ValidProfile(String username, String password) {
        this.username = username;
        this.passwordChars = password.toCharArray(); // Конвертируйте String password в char[] и byte[]
        this.passwordBytes = password.getBytes(StandardCharsets.UTF_8);// Вспомните методы: .toCharArray() и .getBytes()
    }

    // 🔹 Геттеры и сеттеры для username
    public String getUsername() {
         return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // 🔹 Геттеры для паролей (возвращают копии массивов!)
    public char[] getPasswordChars() {
        return Arrays.copyOf(passwordChars,passwordChars.length);
    }
    public byte[] getPasswordBytes() {
        return Arrays.copyOf(passwordBytes, passwordBytes.length);
    }

    // 🔹 Метод для получения пароля как String (для проверки)
    public String getPasswordAsString() {
        // Конвертируйте char[] обратно в String
        // Вспомните: new String(char[])
        return new String(passwordChars);
    }

    // 🔹 Метод шифрования (XOR с ключом)
    public byte[] encryptPassword(int key) {
        byte[] encrypted = new byte[passwordBytes.length];
        for (int i = 0; i < passwordBytes.length; i++) {
            // Явное приведение к byte + скобки для приоритета операций
            encrypted[i] = (byte) (passwordBytes[i] ^ key);
        }
        return encrypted; //  Возвращаем результат!
    }

    // 🔹 Метод дешифрования (тот же XOR)
    public byte[] decryptPassword(int key) {
        byte[] decrypted = new byte[passwordBytes.length];
        for (int i = 0; i < passwordBytes.length; i++) {
            // Одно применение XOR + приведение типа
            decrypted[i] = (byte) (passwordBytes[i] ^ key);
        }
        return decrypted;
    }

    // 🔹 Метод для вывода информации о профиле
    public void printProfileInfo() {
        // Выведите username
        // Выведите длину пароля в символах и байтах
        // Вспомните: .length для массивов, .length() для String
        String str = String.format("Username = %s" , username);
        String str2 = String.format("Length in char = %d \n Length in bytes = %d", passwordChars.length, passwordBytes.length );
        System.out.println(str + "\n " + str2);
    }
}
