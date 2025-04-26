package laba5;

import java.util.Arrays;

public class t8 {
    static String[] findLonger(String[] strings, int minLength){
        return Arrays.stream(strings)
                .filter(x -> x.length() > minLength)
                .toArray(String[]::new);
    }
}
