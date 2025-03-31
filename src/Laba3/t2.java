package Laba3;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var a = in.nextInt();
        DecToBin(a);
    }

    static void DecToBin(int dec){
        if (dec / 2 > 1){
            DecToBin(dec / 2);
        }
        else {
            System.out.print(dec / 2);
        }
        System.out.print(dec % 2);
    }
}
