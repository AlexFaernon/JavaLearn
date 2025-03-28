package Laba2;

import java.util.function.Predicate;

public class t2 {
    public static void main(String[] args) {
        final var size = 10;
        var count = 0;
        var nums = new int[size][size];
        for (var i = 0; i < size; i++){
            for (var j = 0; j < size; j++){
                if (i % 2 == 0){
                    nums[i][j] = count++;
                }
                else {
                    nums[i][size - j - 1] = count++;
                }
            }
        }

        for (var i = 0; i < size; i++) {
            for (var j = 0; j < size; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
