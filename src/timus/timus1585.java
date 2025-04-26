package timus;

import java.util.HashMap;
import java.util.Scanner;

public class timus1585 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String m ="Emperor Penguin";
        HashMap<String, Integer> d = new HashMap<>();
        d.put("Emperor Penguin", 0);
        d.put("Macaroni Penguin", 0);
        d.put("Little Penguin", 0);
        for (int i = 0; i < n; i++){
            String a = in.nextLine();
            d.put(a, d.get(a) + 1);
            if (d.get(a) > d.get(m)){
                m = a;
            }
        }

        System.out.println(m);
    }
}
