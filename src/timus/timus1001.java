package timus;

import java.util.ArrayList;
import java.util.Scanner;

public class timus1001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Long> l = new ArrayList<>();

        while (in.hasNext()) {
            if (in.hasNextBigInteger()) {
                long a = in.nextLong();
                l.add(a);
            } else {
                in.next();
            }
        }

        in.close();

        for (int i = l.size() - 1; i >= 0; i--) {
            System.out.println(Math.sqrt(l.get(i)));
        }
    }
}
