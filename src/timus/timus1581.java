package timus;

import java.util.ArrayList;
import java.util.Scanner;

public class timus1581 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.nextLine();

        int k = 1;
        ArrayList<String> l2 = new ArrayList<>();

        String[] l = (in.nextLine() + " -").split(" ");
        for (int i = 0; i < l.length - 1; i++) {
            if (l[i].equals(l[i + 1])) {
                k++;
            } else {
                l2.add(String.valueOf(k));
                l2.add(l[i]);
                k = 1;
            }
        }

        System.out.println(String.join(" ", l2));
    }
}
