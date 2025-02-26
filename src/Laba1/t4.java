package Laba1;

import java.util.Scanner;

public class t4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("месяц: ");
        String month = in.nextLine();

        System.out.println("колличество дней: ");
        int dayCount = in.nextInt();

        System.out.printf("There is %s days in %s (maybe)", dayCount, month);
    }
}
