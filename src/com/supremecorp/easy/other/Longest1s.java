package com.supremecorp.easy.other;

import java.util.Scanner;

/**
 * Created by suprememajor on 10/5/21
 */
public class Longest1s {
    public static void longest1() {
        Scanner in = new Scanner(System.in);
        String b = in.nextLine();
        String[] parts = b.split("0");
        int max=0;
        for(int i=0;i<parts.length-1;i++){
            if(max<parts[i].length()+parts[i+1].length()){
                max = parts[i].length()+parts[i+1].length();
            }
        }
        System.out.println(max+1);
    }
    public static void longest11() {
        Scanner in = new Scanner(System.in);
        String b = in.nextLine();

        int onesBeforeLastZero = 0;
        int onesAfterLastZero = 1;
        int longestSequenceOfOnes = 0;

        for (int i = 0; i <= b.length(); i++) {
            if (i == b.length() || b.charAt(i) == '0') {
                longestSequenceOfOnes = Math.max(longestSequenceOfOnes, onesBeforeLastZero + onesAfterLastZero);
                onesBeforeLastZero = onesAfterLastZero - 1;
                onesAfterLastZero = 0;
            }
            onesAfterLastZero++;
        }

        System.out.println(longestSequenceOfOnes);
    }

    public static void longest12() {
        String[] b = new Scanner(System.in).nextLine().split("0");
        int max = 1;
        for(int i = 0; i < b.length-1; i++) max = Math.max(max, b[i].length() + b[i+1].length() + 1);
        System.out.println(max);
    }
}
