package laba5;

import java.util.Arrays;

public class t7 {
    static int[] findDividers(int[] nums, int div){
        return Arrays.stream(nums).filter(x -> x % div == 0).toArray();
    }
}
