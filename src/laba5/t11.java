package laba5;

import java.util.Arrays;

public class t11 {
    static int[] findGreater(int[] nums, int max){
        return Arrays.stream(nums).filter(x -> x < max).toArray();
    }
}
