package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on 9/29/21
 */
public class Spreadsheet {
    static int[] ans;
    static String[][] input;
    public static void spreadSheet() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        input = new String[N][3];
        ans = new int[N];
        for (int i = 0; i < N; i++) {
            input[i][0] = in.next();
            input[i][1] = in.next();
            input[i][2] = in.next();
        }
        for(int i = 0; i < N; i++){
            if(ans[i] != 0)
                continue;
            else{
                ans[i] = getResult(input[i][0], input[i][1], input[i][2]);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }
    }
    public static int getResult(String operation, String arg1, String arg2){
        int temp1;
        int temp2;
        if(arg1.contains("$") && arg2.contains("$")){
            temp1 = Integer.parseInt(arg1.substring(1));
            temp2 = Integer.parseInt(arg2.substring(1));
            if(ans[temp1] == 0)
                ans[temp1] = getResult(input[temp1][0], input[temp1][1], input[temp1][2]);
            if(ans[temp2] == 0)
                ans[temp2] = getResult(input[temp2][0], input[temp2][1], input[temp2][2]);
            return getResult(operation, Integer.toString(ans[temp1]),
                    Integer.toString(ans[temp2]));
        }else if(arg1.contains("$")){
            temp1 = Integer.parseInt(arg1.substring(1));
            if(ans[temp1] == 0)
                ans[temp1] = getResult(input[temp1][0], input[temp1][1], input[temp1][2]);
            return getResult(operation, Integer.toString(ans[temp1]), arg2);
        }else if(arg2.contains("$")){
            temp2 = Integer.parseInt(arg2.substring(1));
            if(ans[temp2] == 0)
                ans[temp2] = getResult(input[temp2][0], input[temp2][1], input[temp2][2]);
            return getResult(operation, arg1, Integer.toString(ans[temp2]));
        }else{
            switch(operation){
                case "VALUE":
                    return Integer.parseInt(arg1);
                case "ADD":
                    return (Integer.parseInt(arg1) + Integer.parseInt(arg2));
                case "SUB":
                    return (Integer.parseInt(arg1) - Integer.parseInt(arg2));
                case "MULT":
                    return (Integer.parseInt(arg1) * Integer.parseInt(arg2));
                default:
                    return 1;
            }
        }
    }
}
