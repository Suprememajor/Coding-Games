package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on the 9/23/21
 */
public class ChuckNorris {
    public static void chuck() {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        int count;
        StringBuilder binaryString = new StringBuilder();
        String temp;
        StringBuilder temp1;
        for(int i = 0; i< MESSAGE.length();i++){
            temp = Integer.toBinaryString(MESSAGE.charAt(i));
            temp1 = new StringBuilder();
            if(temp.length() < 7){
                temp1.append("0".repeat(7 - temp.length()));
                temp = temp1 + temp;
            }
            binaryString.append(temp);
        }
        for(int i = 0;i<binaryString.length();){
            count = 0;
            if(binaryString.charAt(i) == '1'){
                count++;
                i++;
                while(i <  binaryString.length() && binaryString.charAt(i) == '1'){
                    count++;
                    i++;
                }
                System.out.print("0 ");
                for(int j = 0; j<count;j++){
                    System.out.print("0");
                }
                if(i <= binaryString.length()-1)
                    System.out.print(" ");
            }else if(binaryString.charAt(i) == '0'){
                count++;
                i++;
                while(i < binaryString.length() && binaryString.charAt(i) == '0'){
                    count++;
                    i++;
                }
                System.out.print("00 ");
                for(int j = 0; j<count;j++){
                    System.out.print("0");
                }
                if(i <= binaryString.length()-1)
                    System.out.print(" ");
            }
        }
    }
}
