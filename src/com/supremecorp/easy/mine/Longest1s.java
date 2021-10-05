package com.supremecorp.easy.mine;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by suprememajor on 10/5/21
 */
public class Longest1s {
    public static void longest1() {
        Scanner in = new Scanner(System.in);
        String string = "11100010101000011111001010";
        in.close();
        int maxCount = 0;
        String collect = Arrays.stream(string.split("0")).collect(Collectors.joining());
        System.out.println(collect);
    }
}
