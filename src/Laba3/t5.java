package Laba3;

import java.util.HashMap;
import java.util.Scanner;

public class t5 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var map = new HashMap<Integer, String>();
        for (var i = 0; i < 10; i++){
            map.put(in.nextInt(), in.nextLine());
        }
        System.out.println("Key > 5");
        for (var key: map.keySet()){
            if (key > 5){
                System.out.println(map.get(key));
            }
        }
        System.out.println("String len > 5");
        var result = 1;
        for (var key: map.keySet()){
            var str = map.get(key);
            if (str.length() > 5){
                result *= key;
            }
        }
        System.out.println(result);
    }
}
