package Laba1;

import java.time.LocalDate;
import java.util.Scanner;

public class t5 {
    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear();

        Scanner in = new Scanner(System.in);

        System.out.println("год рождения: ");
        int birthYear = in.nextInt();

        int age = currentYear - birthYear;

        System.out.printf("Your age is %s-%s", age - 1, age);
    }
}
