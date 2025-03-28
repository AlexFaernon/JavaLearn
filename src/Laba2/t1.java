package Laba2;

import java.util.ArrayList;
import java.util.Random;

public class t1 {
    public static void main(String[] args) {
        final var size = 10;
        var nums = new int[size][size];
        var rand = new Random();
        var max = 0;
        var indexes = new ArrayList<String>();
        for (var i = 0; i < size; i++){
            for (var j = 0; j < size; j++){
                var current = rand.nextInt(10);
                nums[i][j] = current;
                System.out.print(current + " ");

                if (current > max){
                    max = current;
                    indexes.clear();
                }

                if (current == max){
                    indexes.add(i + " " + j);
                }
            }
            System.out.println();
        }

        System.out.printf("Largest number is %s, indexes are %s", max, indexes);
    }
}
