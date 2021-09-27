package com.supremecorp.easy.mine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by suprememajor on 9/27/21
 */
public class HorseRacing {
    public static void horseRacing() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            list.add(pi);
        }
        Collections.sort(list);
        int difference = list.get(list.size() - 1) - list.get(list.size() - 2);
        for(int i = list.size() - 2; i > 0 ; i--){
            if(list.get(i) - list.get(i - 1) < difference)
                difference = list.get(i) - list.get(i - 1);
        }
        System.out.println(difference);
    }
}
