package laba5;

import java.util.Arrays;

public class t9 {
    static int[] findGreater(int[] nums, int min){
        return Arrays.stream(nums).filter(x -> x > min).toArray();
    }
}
