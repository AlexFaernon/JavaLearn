package timus;

import java.util.Scanner;

public class timus1607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if (a > c) {
            System.out.println(a);
            return;
        }

        while (true) {
            if (a + b >= c) {
                System.out.println(c);
                break;
            } else {
                a += b;
            }
            if (c - d <= a) {
                System.out.println(a);
                break;
            } else {
                c -= d;
            }
        }
    }
}
