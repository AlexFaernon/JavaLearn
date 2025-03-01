package timus;

import java.util.Scanner;

public class timus2100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int t = 2;
        for (int i = 0; i < n; i++){
            String a = in.nextLine();
            t++;
            if (a.endsWith("+one")){
                t++;
            }
        }

        if (t == 13){
            t++;
        }

        System.out.println(t*100);
    }
}