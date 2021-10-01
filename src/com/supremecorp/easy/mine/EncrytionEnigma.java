package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on 10/1/21
 */
public class EncrytionEnigma {
    public static void encrypt() {
        int control = 0;
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        String[] rotor = new String[3];
        int pseudoRandomNumber = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            rotor[i] = in.nextLine();
        }
        String message = in.nextLine();
        char[] temp = new char[message.length()];
        char[] temp2 = new char[message.length()];
        switch(operation){
            case "ENCODE":
                for(int i = 0; i < message.length(); i++){
                    control = message.charAt(i) + (i + pseudoRandomNumber);
                    while(control > 90)
                        control = (control - 90) + 64;
                    temp[i] = (char)control;
                }
                for(int i = 0; i < 3; i++){
                    for(int j = 0;j < message.length(); j++){
                        temp2[j] = rotor[i].charAt( (int)(temp[j]) - 65);
                    }
                    System.arraycopy(temp2, 0, temp, 0, temp.length);
                }
                break;
            case "DECODE":
                temp = message.toCharArray();
                for(int i = 2; i >= 0; i--){
                    for(int j = 0; j < message.length(); j++){
                        for(int k = 0; k < 26; k++){
                            if(temp[j] == rotor[i].charAt(k)){
                                temp2[j] = ((char)(65 + k));
                                break;
                            }
                        }
                    }
                    System.arraycopy(temp2, 0, temp, 0, temp.length);
                }
                for(int i = 0; i < temp.length; i++){
                    control = temp[i] - (pseudoRandomNumber + i);
                    while(control < 65)
                        control += 26;
                    temp2[i] = (char)control;
                }
                System.arraycopy(temp2, 0, temp, 0, temp.length);
                break;
        }
        for(int i = 0; i < temp.length; i++)
            System.out.print(temp[i]);
    }
}
