package com.supremecorp.easy.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by suprememajor on 9/28/21
 */
public class GhostLegs {
    public static void ghostLegs() {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        List<String> lines = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            lines.add(in.nextLine());
        }

        for (int j = 0; j < W; j+=3){
            int move = j;
            String firstLetter = "";
            for (int i = 0; i < lines.size(); i++) {
                if (i == 0) {
                    firstLetter = String.valueOf(lines.get(i).charAt(move));
                }

                if (move < W-1 && lines.get(i).charAt(move+1) == '-') {
                    move += 3;
                }
                else if (move >= 1 && lines.get(i).charAt(move-1) == '-') {
                    move -= 3;
                }
            }
            System.out.println(firstLetter + String.valueOf(lines.get(H-1).charAt(move)));
        }
    }
}
