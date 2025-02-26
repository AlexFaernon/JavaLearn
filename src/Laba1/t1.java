package Laba1;

import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("фамилия: ");
        String lastName = in.nextLine();

        System.out.println("имя: ");
        String firstName = in.nextLine();

        System.out.println("отчество: ");
        String surname = in.nextLine();

        System.out.printf("Hello %s %s %s", lastName, firstName, surname);
    }
}
