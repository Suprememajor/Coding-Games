package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on 9/28/21
 */
public class GhostLegs {
    public static void ghostLegs() {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        char[][] chars = new char[H][W];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < H; i++) {
            String line = in.nextLine();
            for(int j = 0; j < W; j++){
                chars[i][j] = line.charAt(j);
            }
        }
        int temp;
        for(int j = 0; j < W ; j += 3){
            temp = j;
            for(int i = 1; i < H; i++){
                if(temp != W-1 && chars[i][temp+1] == '-'){
                    temp += 3;
                }else if(temp != 0 && chars[i][temp-1] == '-'){
                    temp -= 3;
                }
            }
            System.out.println(chars[0][j]+""+chars[H-1][temp]);
        }
    }
}
