package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on the 9/18/21
 */
public class Temperatures {
    public static void closest() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        if (n == 0) System.out.println(0);
        else {
            int closest = 0;
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                if (i == 0) closest = t;// a temperature expressed as an integer ranging from -273 to 5526
                else if (Math.abs(t) < Math.abs(closest)) {
                    closest = t;
                } else if (Math.abs(t) == Math.abs(closest)) {
                    closest = Math.max(t, closest);
                }
            }
            System.out.println(closest);
        }
    }
}
