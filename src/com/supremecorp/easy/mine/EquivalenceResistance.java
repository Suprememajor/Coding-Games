package com.supremecorp.easy.mine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by suprememajor on 10/2/21
 */
public class EquivalenceResistance {
    static Map<String, Integer> resistances = new HashMap<>();
    public static void getEquivalenceResistance() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String name = in.next();
            int R = in.nextInt();
            resistances.put(name, R);
        }
        in.nextLine();
        String circuit = in.nextLine();
        String[] s = circuit.split(" ");
        System.out.println((Math.round(solve(s) * 10) / 10.0));
    }
    public static double solve(String[] s){
        String[] sCopy = Arrays.copyOfRange(s,1,s.length);
        if(s[0].equals("(")){
            return seriesTotal(sCopy);
        }else{
            return parallelTotal(sCopy);
        }
    }

    private static double parallelTotal(String[] pT) {
        double sumInverse = 0;
        int end;
        for(int i = 0; i < pT.length; i++){
            if(pT[i].equals(")") || pT[i].equals("]")) continue;
            if(pT[i].equals("(")){
                end = findEnd("(", i, pT);
                sumInverse += Math.pow(seriesTotal(Arrays.copyOfRange(pT,i+1,end)), -1);
                i = end;
            }else if(pT[i].equals("[")){
                end = findEnd("[", i, pT);
                sumInverse += Math.pow(parallelTotal(Arrays.copyOfRange(pT,i+1,end)), -1);
                i = end;
            }else{
                sumInverse += Math.pow(resistances.get(pT[i]), -1);
            }
        }
        return Math.pow(sumInverse, -1);
    }

    private static double seriesTotal(String[] sT) {
        double sum = 0;
        int end;
        for(int i = 0; i < sT.length; i++){
            if(sT[i].equals(")") || sT[i].equals("]")) continue;
            if(sT[i].equals("(")){
                end = findEnd("(", i, sT);
                sum += seriesTotal(Arrays.copyOfRange(sT,i+1,end));
                i = end;
            }else if(sT[i].equals("[")){
                end = findEnd("[", i, sT);
                sum += parallelTotal(Arrays.copyOfRange(sT,i+1,end));
                i = end;
            }else{
                sum += resistances.get(sT[i]);
            }
        }
        return sum;
    }

    private static int findEnd(String type, int i, String[] sT) {
        String open, close;
        if(type.equals("(")){
            open = "(";
            close = ")";
        }else{
            open = "[";
            close = "]";
        }
        int count = 1;
        for(int j = i+1; j < sT.length; j++){
            if(sT[j].equals(open)) count++;
            else if(sT[j].equals(close)) count--;
            if(count == 0) return j;
        }
        return -1;
    }
}
