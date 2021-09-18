package com.supremecorp.easy.other;

import java.util.Scanner;

/**
 * Created by suprememajor on the 9/18/21
 */
public class Temperatures {
    public static void closest() {
        int result  = 0;
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse

        if(n != 0){
            result = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526

                if(Math.abs(result) == Math.abs(t)){
                    result = Math.max(result,t);
                }
                else{
                    if(Math.abs(result) > Math.abs(t)){
                        result = t;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
