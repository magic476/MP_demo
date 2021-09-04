package com.wp.Utils;

import java.util.Random;

public class RandomGenerator {
    private static String range = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static synchronized String getRandomString(){
        Random random = new Random();
        StringBuffer result = new StringBuffer();
        //要生成几位，就把这里的数字改成几
        for (int i=0;i<8;i++){
            result.append(range.charAt(random.nextInt(range.length())));
        }
        return result.toString();
    }
}
