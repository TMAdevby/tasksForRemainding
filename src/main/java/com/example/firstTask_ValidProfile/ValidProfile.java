package com.example.firstTask_ValidProfile;


import java.time.LocalDate;
import java.util.Scanner;

public class ValidProfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;
        String email;

        int yearOfBorn;
        LocalDate now = LocalDate.now();

        System.out.println("Enter your name. Conditions: not empty, can contains from 2 to 50 symbols");
        name = scanner.nextLine();
        boolean valid1 = true;
        if(name.isEmpty()||name.isBlank()||name.length() < 2 || name.length()>50){
            valid1 = false;
        }

        System.out.println("Enter your age. Conditions: age must be from 18 and to 100");
        age = scanner.nextInt();
        scanner.nextLine();
        boolean valid2 = true;
        if(age < 18 || age > 100){
            valid2 = false;
        }
        yearOfBorn = now.getYear() - age;
        String yourYear = yearOfBorn - 1 + " or " + yearOfBorn;

        System.out.println("Enter your email. Conditions: email must contains '@.' but not starts with it and not ends with it ");
        email = scanner.nextLine();
        boolean valid3 = true;
        if(!email.contains("@") || !email.contains(".") ||
                email.indexOf('@') > email.indexOf('.') ||
                email.startsWith("@") || email.endsWith(".")){
            valid3 = false;
        }

        StringBuilder emailCh = new StringBuilder(email);

        if(email.contains("@.")){
            int numOfD = email.indexOf('@');
            String z = "*";
            StringBuilder zz = new StringBuilder();
            for (int i = 1; i < numOfD; i++) {
                zz = zz.append(z);
            }
            emailCh = emailCh.replace(1, numOfD,zz.toString());

        }

        if(valid1 && valid2 && valid3){
            String output = String.format("The profile is valid: \n Name : %s \n Age : %s \n Email : %s " ,name.toUpperCase(), yourYear,emailCh);
            System.out.println(output);
        }
        else {
            System.out.println("Mistakes:");
            if(!valid1) System.out.println("• Name: not empty, can contains from 2 to 50 symbols");
            if(!valid2) System.out.println("• Age: age must be from 18 and to 100");
            if(!valid3) System.out.println("• Email: must contains '@.' but not starts with it and not ends with it\"");
        }
        scanner.close();
    }
}