package timus;

import java.util.ArrayList;
import java.util.Scanner;

public class timus1910 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++){
            l.add(in.nextInt());
        }
        int s = 0;
        int p = 0;
        for (int i = 0; i < n - 2; i++){
            int current = l.get(i) + l.get(i + 1) + l.get(i + 2);
            if (current > s){
                s = current;
                p = i + 2;
            }
        }
        System.out.print(s + " " + p);
    }
}
