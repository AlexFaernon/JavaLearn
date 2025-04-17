package timus;

import java.util.Scanner;

public class timus1924 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        for (int i = 1; i <= n; i++) {
            a += i;
        }

        if (a % 2 == 0){
            System.out.print("black");
        }
        else {
            System.out.print("grimy");
        }
    }
}
