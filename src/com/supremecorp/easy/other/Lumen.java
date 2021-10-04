package com.supremecorp.easy.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by suprememajor on 10/4/21
 */
public class Lumen {


    public static void lumen() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Spot.L = in.nextInt();
        if (in.hasNextLine()) {in.nextLine();}

        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char[] LINE = in.nextLine().replace(" ","").toCharArray();
            for(int j=0;j<LINE.length;j++){
                spots.add(new Spot(LINE[j], i, j));
            }
        }

        List<Spot> candles = spots.stream().filter(Spot::isCandle).collect(Collectors.toList());
        spots.forEach(s->s.setLight(candles));
        System.out.println(spots.stream().filter(Spot::isDark).count());
    }

    static class Spot{
        public static int L;
        int x, y;
        boolean isDark = true, isCandle = false;

        Spot(char c, int xx, int yy){
            x=xx;
            y=yy;
            if(c=='C'){
                isCandle=true;
                isDark=false;
            }
        }

        boolean isCandle(){
            return isCandle;
        }

        boolean isDark(){
            return isDark;
        }

        private boolean isIn(int xx, int yy){
            return Math.abs(x-xx)<L && Math.abs(y-yy)<L;
        }

        void setLight(List<Spot> candles){
            for(Spot c:candles){
                if(isIn(c.x, c.y)){
                    isDark = false;
                    break;
                }
            }
        }
    }

    static int N;
    static int L;
    static boolean hasLight[][];

    public static void lumen2() {
        Scanner in = new Scanner(System.in);
        N = Integer.parseInt(in.nextLine());

        hasLight = new boolean[N][N];

        L = Integer.parseInt(in.nextLine());

        int nbDarkCells = N*N;
        for (int i = 0; i < N; i++) {
            nbDarkCells -= light(String.join("", in.nextLine().split(" ")), i);
        }

        System.out.println(nbDarkCells);
    }

    static int light(String line, int row) {
        int nbLights = 0;
        int col = line.indexOf("C");
        while (col != -1) {
            for (int i = Math.max(0, row - L + 1) ; i < Math.min(N, row + L) ; i++) {
                for (int j = Math.max(0, col - L + 1) ; j < Math.min(N, col + L) ; j++) {
                    if (!hasLight[i][j]) {
                        hasLight[i][j] = true;
                        nbLights++;
                    }
                }
            }
            line = line.substring(0, col)+"X"+line.substring(col+1);
            col = line.indexOf("C");
        }
        return nbLights;
    }
}
