package laba5;

import java.util.Arrays;
import java.util.Scanner;

public class t6 {
    static String[] findWithSubstring(String[] strings, String substring){
        return Arrays.stream(strings)
                .filter(x -> x.contains(substring))
                .toArray(String[]::new);
    }
}
