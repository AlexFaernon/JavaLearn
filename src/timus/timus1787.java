package timus;

import java.util.Scanner;

public class timus1787 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int t = 0;
        for (int i = 0; i < n; i++){
            int a = in.nextInt();
            t = t + a - k;
            if (t < 0){
                t = 0;
            }
        }
        System.out.println(t);
    }
}
