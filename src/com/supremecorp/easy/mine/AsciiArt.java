package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on the 9/20/21
 */
public class AsciiArt {
    public static void asciiArt() {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        int[] code = new int[T.length()];
        String[] ans = new String[H];
        for(int i = 0; i < T.length(); i++){
            code[i] = (int)T.charAt(i);
        }
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            ans[i] = "";
            for(int j = 0; j < T.length(); j++){
                ans[i] += ROW.substring((L * extractChar(code[j])), (L * extractChar(code[j])) + L);
            }
        }
        for(int i = 0; i < H ; i++){
            System.out.println(ans[i]);
        }
    }
    public static int extractChar(int n){
        if(n >= 65 && n <= 90)
            return (n - 65);
        else if(n >= 97 && n <= 122)
            return (n - 97);
        else
            return 26;
    }
}
