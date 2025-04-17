package timus;

import java.util.Scanner;

public class timus1313 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] l = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                l[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n * 2 - 2; i++) {
            if (i < n){
                int x = i;
                int y = 0;
                while (x >= 0){
                    System.out.print(l[x][y] + " ");
                    x -= 1;
                    y += 1;
                }
            }
            else {
                int x = n - 1;
                int y = i - n + 1;
                while (y < n){
                    System.out.print(l[x][y] + " ");
                    x -= 1;
                    y += 1;
                }
            }
        }

        System.out.print(l[n-1][n-1]);
    }
}
