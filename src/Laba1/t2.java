package Laba1;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("имя: ");
        String name = in.nextLine();

        System.out.println("возраст: ");
        int height = in.nextInt();

        System.out.printf("Name: %s, Age: %s", name, height);
    }
}
