package com.supremecorp.easy.other;

import java.util.Scanner;

/**
 * Created by suprememajor on 10/1/21
 */
public class EncrytionEnigma {
    public static void encrypt() {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine(), alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] rotor = new String[3];
        int pseudoRandomNumber = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            rotor[i] = in.nextLine();
        }
        char[] message = in.nextLine().toCharArray();
        if (operation.charAt(0)=='E')
        {
            for (int i=0; i<message.length; i++)
            {
                message[i] = alph.charAt((message[i]-'A'+i+pseudoRandomNumber)%26);
                for (int j=0; j<3; j++)
                {
                    message[i] = rotor[j].charAt(message[i]-'A');
                }
            }
            System.out.println(message);
        }
        else
        {
            for (int i=0; i<message.length; i++)
            {
                for (int k=2; k>=0; k--)
                {
                    for (int j=0; j<26; j++)
                    {
                        if (message[i]==rotor[k].charAt(j))
                        {
                            message[i] = alph.charAt(j);
                            break;
                        }
                    }
                }
                for (int j=0; j<26; j++)
                {
                    if (message[i]==alph.charAt(j))
                    {
                        message[i] = alph.charAt((j-i-pseudoRandomNumber+78)%26);
                        break;
                    }
                }
            }
            System.out.println(message);
        }
    }
}
