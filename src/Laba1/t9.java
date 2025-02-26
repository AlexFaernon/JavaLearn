package Laba1;

import java.util.Scanner;

public class t9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("число:");
        int a = in.nextInt();

        System.out.printf("""
                a - 1: %s
                a: %s
                a + 1: %s
                3a^2: %s
                """, a - 1, a, a + 1, Math.pow(3*a, 2));
    }
}
