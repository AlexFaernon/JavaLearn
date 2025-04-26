package timus;

import java.util.Scanner;

public class timus2056 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = 0;
        for (int i = 0; i < n; i++){
            int a = in.nextInt();
            if (a == 3){
                System.out.print("None");
                return;
            }
            s += a;
        }
        float avg = (float) s / n;
        if (avg == 5){
            System.out.print("Named");
        }
        else if (avg >= 4.5){
            System.out.print("High");
        }
        else {
            System.out.print("Common");
        }
    }
}