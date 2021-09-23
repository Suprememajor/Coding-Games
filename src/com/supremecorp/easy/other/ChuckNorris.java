package com.supremecorp.easy.other;

import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by suprememajor on the 9/23/21
 */
public class ChuckNorris {
    public static void chuck() {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        StringBuilder binary = new StringBuilder();

        for(int i=0;i<MESSAGE.length();i++)
            binary.append(String.format("%7s", Integer.toBinaryString(MESSAGE.charAt(i))).replaceAll(" ", "0"));
        System.out.println(compressBinary(binary.toString()));
    }
    public static String compressBinary(String s) {
        StringBuilder ans = new StringBuilder();
        char last = s.charAt(0);
        for(int i =0;i<s.length();) {
            ans.append(last == '1' ? "0 " : "00 ");
            while(i<s.length() && s.charAt(i)==last)
            {
                ans.append("0");
                i++;
            }
            ans.append(" ");
            last = last=='1'?'0':'1';
        }
        return ans.toString().trim();
    }

    public static void chuck2() {
        new Scanner(System.in).nextLine().chars()
                .mapToObj(c -> String.format("%7s", Integer.toBinaryString(c)).replace(" ", "0"))
                .collect(Collectors.joining()).chars().reduce('2', (a, b) -> {
                    System.out.print(a == b ? "0" : ((a != '2' ? " " : "") + (b == '1' ? "0 0" : "00 0")));
                    return b;
                });
    }
}
