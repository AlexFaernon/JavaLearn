package timus;

import java.util.Scanner;

public class timus1263 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] l = new int[n];

        for (int i = 0; i < m; i++) {
            int index = sc.nextInt() - 1;
            l[index]++;
        }

        int s = 0;
        for (int count : l) {
            s += count;
        }

        for (int count : l) {
            double percent = (double) count / s * 100;
            System.out.printf("%.2f%%\n", percent);
        }
    }
}
