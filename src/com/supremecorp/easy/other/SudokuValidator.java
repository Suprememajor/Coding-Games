package com.supremecorp.easy.other;

import java.util.Scanner;

/**
 * Created by suprememajor on 10/7/21
 */
public class SudokuValidator {
    public static void validate() {
        Scanner in = new Scanner(System.in);
        int [] hor = new int[9];
        int [] ver = new int[9];
        int [][] sub = new int[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int n = in.nextInt()-1;
                hor[i] |= 1<<n;
                ver[j] |= 1<<n;
                sub[j/3][i/3] |= 1<<n;
            }
        }
        boolean ok = true;
        int corr = 0x1ff;
        for (int i = 0; i < 9; i++) {
            ok &= hor[i] == corr;
            ok &= ver[i] == corr;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 ; j++) {
                ok &= sub[i][j] == corr;
            }
        }
        System.out.println(ok);
    }
}
