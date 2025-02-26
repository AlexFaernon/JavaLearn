package Laba1;

import java.time.LocalDate;
import java.util.Scanner;

public class t7 {
    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear();

        Scanner in = new Scanner(System.in);

        System.out.println("возраст: ");
        int age = in.nextInt();

        int birthYear = currentYear - age;

        System.out.printf("Your birth year is %s-%s", birthYear, birthYear + 1);
    }
}
