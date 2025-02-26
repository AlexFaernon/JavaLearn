package Laba1;

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("день недели: ");
        String weekDay = in.nextLine();

        System.out.println("дата: ");
        int day = in.nextInt();

        System.out.println("месяц: ");
        int month = in.nextInt();

        System.out.printf("Today is %s.%s, %s", day, month, weekDay);
    }
}
