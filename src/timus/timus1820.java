package timus;

import java.util.Scanner;

public class timus1820 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (n > k) {
            if (2 * n % k == 0) {
                System.out.println(n * 2 / k);
            }
            else {
                System.out.println(n * 2 / k + 1);
            }
        }
        else {
            System.out.println(2);
        }
    }
}
