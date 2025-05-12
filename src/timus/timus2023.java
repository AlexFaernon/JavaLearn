package timus;

import java.util.Scanner;

public class timus2023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int cp = 1;
        int steps = 0;
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            int next;
            if (s.charAt(0) == 'A' || s.charAt(0) == 'P' || s.charAt(0) == 'O' || s.charAt(0) == 'R') {
                next = 1;
            } else if (s.charAt(0) == 'B' || s.charAt(0) == 'M' || s.charAt(0) == 'S') {
                next = 2;
            } else {
                next = 3;
            }
            steps += Math.abs(cp - next);
            cp = next;
        }
        System.out.println(steps);
    }
}
