package com.supremecorp.easy.other;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by suprememajor on 10/2/21
 */
public class EquivalenceResistance {
    public static void getResistances() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Map<String, Integer> r = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = in.next();
            int R = in.nextInt();
            r.put(name, R);
        }
        in.nextLine();
        String circuit = in.nextLine();
        for(Map.Entry<String, Integer> entry : r.entrySet()) {
            circuit = circuit.replaceAll(entry.getKey(), ""+entry.getValue());
        }
        StringBuilder c = new StringBuilder(circuit);
        System.err.println(c);
        Pattern p1 = Pattern.compile("\\(([ .0-9]*)\\)");
        Pattern p2 = Pattern.compile("\\[([ .0-9]*)]");
        while(c.toString().matches(".*\\((.*?)\\).*") || c.toString().matches(".*\\[(.*?)].*")){
            Matcher m = p1.matcher(c);
            if(m.find()) {
                int start = m.start(1) - 1;
                int end = m.end(1) + 1;
                // System.err.println(c);
                c.replace(start, end, "" + Arrays.stream(m.group(1).trim().split(" ")).map(Float::parseFloat).reduce(0.0f, Float::sum));
                // System.err.println(c);
            }
            m = p2.matcher(c);
            if(m.find()) {
                int start = m.start(1) - 1;
                int end = m.end(1) + 1;
                //                System.err.println();
                c.replace(start, end, "" + 1/(Arrays.stream(m.group(1).trim().split(" ")).map(Float::parseFloat).map(f-> 1/f).reduce(0.0f, (Float::sum))));

            }
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println(decimalFormat.format(Float.valueOf(c.toString())));
    }

    public static void getResistances2() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        HashMap<String, Integer> resistorMap = new HashMap<>();
        for (int i = 0; i < N; i++){
            String name = in.next();
            int R = in.nextInt();
            resistorMap.put(name, R);
        }
        in.nextLine();
        String circuit = in.nextLine();
        circuit = circuit.trim();
        Stack<Boolean> operatorStack = new Stack<>();
        Stack<Double> answerStack = new Stack<>();
        String[] elementList = circuit.split(" ");
        for (String s: elementList){
            if (s.equals("[")) {
                operatorStack.push(true);
                answerStack.push(0.0);
            } else if (s.equals("(")) {
                operatorStack.push(false);
                answerStack.push(0.0);
            } else if (s.equals("]") || s.equals(")")) {
                operatorStack.pop();
                if (!(operatorStack.isEmpty())) {
                    double b = answerStack.pop();
                    double a = answerStack.pop();
                    if (a == 0.0) answerStack.push(b);
                    else if (operatorStack.peek()) answerStack.push(1.0 / ((1.0 / a) + (1.0 / b)));
                    else answerStack.push(a + b);
                }
            } else if (answerStack.peek().equals(0.0)) {
                answerStack.pop();
                answerStack.push((double) resistorMap.get(s));
            } else {
                double a = answerStack.pop();
                double b = resistorMap.get(s);
                if (operatorStack.peek()) answerStack.push(1.0 / ((1.0 / a) + (1.0 / b)));
                else answerStack.push(a + b);
            }
        }
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(df.format(answerStack.pop()));
    }
}
