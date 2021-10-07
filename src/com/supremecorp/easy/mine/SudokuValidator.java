package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on 10/7/21
 */
public class SudokuValidator {
    public static void validate() {
        Scanner in = new Scanner(System.in);
        int[][] soduku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                soduku[i][j] = in.nextInt();
            }
        }
        in.close();

        // Write an answer using System.out.println()

        if(validate(soduku)) System.out.println("true");
        else System.out.println("false");

        //System.out.println("true or false");
    }
    public static boolean validate(int[][] arr){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                for(int k = j + 1; k < 9; k++){
                    if(arr[i][j] == arr[i][k] || arr[j][i] == arr[k][i]) return false;
                }
            }
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++){
                    for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++){
                        if(row != i && col != j && arr[row][col] == arr[i][j]) return false;
                    }
                }
            }
        }
        return true;
    }
}
