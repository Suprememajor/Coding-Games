package com.supremecorp.easy.mine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogicGates {
    private static final Map<String, String> input = new HashMap<>();

    public static void logicGates() {
        int m;
        String[][] output;
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            m = in.nextInt();
            //Five spaces because the result will be stored in the fourth index
            output = new String[m][5];
            for (int i = 0; i < n; i++) {
                input.put(in.next(), in.next());
            }
            for (int i = 0; i < m; i++) {
                output[i][0] = in.next();
                output[i][1] = in.next();
                output[i][2] = in.next();
                output[i][3] = in.next();
            }
        }
        for (int i = 0; i < m; i++) {
            logicGate(output[i]);
            System.out.println(output[i][0] + " " + output[i][4]);
        }
    }

    static void logicGate(String[] arr) {
        StringBuilder tempAns = new StringBuilder();
        if (arr.length != 5)
            throw new IllegalArgumentException("Invalid array size");
        for (int i = 0; i < input.get(arr[3]).length(); i++) {
            tempAns.append(gateParser(input.get(arr[2]).charAt(i), input.get(arr[3]).charAt(i), arr[1]));
        }
        arr[4] = tempAns.toString();
    }

    static char gateParser(char a, char b, String gate) {
        switch (gate.toUpperCase()) {
            case "AND":
                if (a == '-' && b == '-') return '-';
                else return '_';
            case "OR":
                if (a == '_' && b == '_') return '_';
                else return '-';
            case "XOR":
                if ((a == '-' && b == '-') || (a == '_' && b == '_')) return '_';
                else return '-';
            case "NAND":
                if (a == '-' && b == '-') return '_';
                else return '-';
            case "NOR":
                if (a == '_' && b == '_') return '-';
                else return '_';
            case "NXOR":
                if ((a == '-' && b == '-') || (a == '_' && b == '_')) return '-';
                else return '_';
        }
        return '0';
    }
}
