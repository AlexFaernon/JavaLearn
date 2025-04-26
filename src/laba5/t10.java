package laba5;

import java.util.Arrays;

public class t10 {
    static String[] findLonger(String[] strings){
        return Arrays.stream(strings)
                .filter(x -> x.chars().allMatch(Character::isLetter))
                .toArray(String[]::new);
    }
}
