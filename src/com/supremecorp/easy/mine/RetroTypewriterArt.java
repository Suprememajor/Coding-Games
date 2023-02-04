package com.supremecorp.easy.mine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RetroTypewriterArt {
    public static void retroTypewriterArt() {
        Map<String, String> map = new HashMap<>();
        map.put("sp", " ");
        map.put("bS", "\\");
        map.put("sQ", "'");
        map.put("nl", "\n");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strings = input.split(" ");
        for (String str : strings) {
            separateString(str, map);
        }
    }

    static void separateString(String str, Map<String, String> map) {
        if (str.contains("sp") ||
                str.contains("bS") ||
                str.contains("sQ") ||
                str.contains("nl")) {
            String substring = str.substring(0, str.length() - 2);
            printLetter(substring.equals("") ? 1 : Integer.parseInt(substring),
                    map.get(str.substring(str.length() - 2)));
        } else {
            String substring = str.substring(0, str.length() - 1);
            printLetter(substring.equals("") ? 1 : Integer.parseInt(substring),
                    str.substring(str.length() - 1));
        }
    }

    static void printLetter(int freq, String letter) {
        if (freq > 0) {
            System.out.print(letter);
            printLetter(freq - 1, letter);
        }
    }
}
