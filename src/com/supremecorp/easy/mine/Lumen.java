package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on 10/4/21
 */
public class Lumen {
    public static void lumen() {
        Scanner in = new Scanner(System.in);
        int ans = 0;
        int N = in.nextInt();
        int L = in.nextInt();
        char[][] spots = new char[N][N];
        int[][] count = new int[N][N];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String LINE = in.nextLine();
            spots[i] = toCharArray(LINE.split(" "));
        }
        in.close();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(spots[i][j] == 'C'){
                    count[i][j] += L;
                    //Bottom
                    for(int k = i + 1, l = 1; k < N; k++, l++){
                        for(int m = Math.max(j - l, 0); m <= Math.min(j + l, N-1); m++){
                            count[k][m] += (L- l > 0) ? L-l : 0;
                        }
                    }
                    //Top
                    for(int k = i - 1, l = 1; k >= 0; k--, l++){
                        for(int m = Math.max(j - l, 0); m <= Math.min(j + l, N-1); m++){
                            count[k][m] += (L-l > 0) ? L-l : 0;
                        }
                    }
                    //Left
                    for(int k = j - 1, l = 1; k >= 0; k--,l++){
                        for(int m = Math.max(i - l + 1, 0); m <= Math.min(i + l - 1, N-1); m++){
                            count[m][k] += (L-l > 0) ? L-l : 0;
                        }
                    }
                    //Right
                    for(int k = j + 1, l = 1; k < N; k++,l++){
                        for(int m = Math.max(i - l + 1, 0); m <= Math.min(i + l - 1, N-1); m++){
                            count[m][k] += (L-l > 0) ? L-l : 0;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(count[i][j] == 0)
                    ans++;

        System.out.println(ans);
    }
    private static char[] toCharArray(String[] temp){
        char[] c = new char[temp.length];
        for(int i = 0; i < temp.length; i++)
            c[i] = temp[i].charAt(0);
        return c;
    }
}
