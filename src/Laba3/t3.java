package Laba3;

import java.util.ArrayList;
import java.util.Scanner;

public class t3 {
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.print("Size: ");
        var n = in.nextInt();
        System.out.printf("%s numbers: ", n);
        System.out.println(InputArray(n, 0));
    }

    static ArrayList<Integer> InputArray(int size, int step){
        var result = new ArrayList<Integer>();
        result.add(in.nextInt());
        if (step < size - 1){
            result.addAll(InputArray(size, step + 1));
        }
        return result;
    }
}
