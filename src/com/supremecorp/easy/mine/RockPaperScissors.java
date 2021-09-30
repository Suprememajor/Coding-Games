package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on 9/30/21
 */
public class RockPaperScissors {
    static String[][] s;
    static String[][] conquest;
    static int j;
    public static void play() {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int rounds = (int)(Math.log10(N)/Math.log10(2));
            int start = 0;
            int end;
            int size = (int)(Math.pow(2, rounds+2));
            s = new String[size][2];
            conquest = new String[size/2][rounds];
            j = N;
            for (int i = 0; i < N; i++) {
                int NUMPLAYER = in.nextInt();
                String SIGNPLAYER = in.next();
                s[i][0] = "" + NUMPLAYER;
                s[i][1] = SIGNPLAYER;
            }
            for(int i = 0; i < rounds; i++){
                end = start + (int) (Math.pow(2, rounds - i));
                competition(start, end, i);
                start += (int) (Math.pow(2, rounds - i));
            }
            System.out.println(s[j-1][0]);
            for(int i = 0; i < rounds; i++){
                System.out.print(conquest[Integer.parseInt(s[j-1][0])][i]);
                if(i != (rounds - 1))
                    System.out.print(" ");
            }

        }
        public static void competition(int start, int end, int round){
            for(int i = start; i < end; i+=2){
                if(s[i][1].equals(s[i+1][1])){
                    if(Integer.parseInt(s[i][0]) < Integer.parseInt(s[i+1][0])){
                        s[j][0] = s[i][0];
                        s[j][1] = s[i][1];
                        conquest[Integer.parseInt(s[i][0])][round] = s[i+1][0];
                        j++;
                    }else{
                        s[j][0] = s[i+1][0];
                        s[j][1] = s[i+1][1];
                        conquest[Integer.parseInt(s[i+1][0])][round] = s[i][0];
                        j++;
                    }
                }else if(s[i][1].equals("C") && s[i+1][1].equals("P") || s[i][1].equals("P") && s[i+1][1].equals("R") ||
                        s[i][1].equals("R") && s[i+1][1].equals("L") || s[i][1].equals("L") && s[i+1][1].equals("S") ||
                        s[i][1].equals("S") && s[i+1][1].equals("C") || s[i][1].equals("C") && s[i+1][1].equals("L") ||
                        s[i][1].equals("L") && s[i+1][1].equals("P") || s[i][1].equals("P") && s[i+1][1].equals("S") ||
                        s[i][1].equals("S") && s[i+1][1].equals("R") || s[i][1].equals("R") && s[i+1][1].equals("C")){
                    s[j][0] = s[i][0];
                    s[j][1] = s[i][1];
                    conquest[Integer.parseInt(s[i][0])][round] = s[i+1][0];
                    j++;
                }else{
                    s[j][0] = s[i+1][0];
                    s[j][1] = s[i+1][1];
                    conquest[Integer.parseInt(s[i+1][0])][round] = s[i][0];
                    j++;
                }
            }
    }
}
