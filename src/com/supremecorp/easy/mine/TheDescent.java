package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on the 9/22/21
 */
public class TheDescent {
    public static void descend() {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[8];
        int max, maxMountain;
        // game loop
        while (true) {
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                arr[i] = mountainH;
            }
            max = arr[0];
            maxMountain = 0;
            for(int i = 1 ; i < 8 ; i++)
                if(max < arr[i]){
                    max = arr[i];
                    maxMountain = i;
                }


            System.out.println(maxMountain); // The index of the mountain to fire on.
        }
    }
}
