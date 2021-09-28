package com.supremecorp.easy.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by suprememajor on 9/29/21
 */
public class Spreadsheet {
    private static ArrayList<String[]> list = new ArrayList<String[]>();
    public static void spreadSheet() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String operation = in.next();
            String arg1 = in.next();
            String arg2 = in.next();
            list.add(new String[]{operation, arg1, arg2});
        }
        for (int i = 0; i < N; i++) {
            System.out.println("" + getValue(i));
        }
    }
    private static int getValue(int index){
        int arg1 = (list.get(index)[1].startsWith("$")) ? getValue(Integer.parseInt(list.get(index)[1].substring(1))) :
                Integer.parseInt(list.get(index)[1]);
        int arg2 = 0;
        if (!list.get(index)[2].equals("_")){
            arg2 = (list.get(index)[2].startsWith("$")) ? getValue(Integer.parseInt(list.get(index)[2].substring(1))) :
                    Integer.parseInt(list.get(index)[2]);
        }
        if (list.get(index)[0].equals("VALUE")){
            list.get(index)[1] = "" + arg1;
            return arg1;
        }
        if (list.get(index)[0].equals("ADD")){
            list.get(index)[0] = "VALUE";
            list.get(index)[1] = "" + (arg1 + arg2);
            return arg1 + arg2;
        }
        if (list.get(index)[0].equals("SUB")){
            list.get(index)[0] = "VALUE";
            list.get(index)[1] = "" + (arg1 - arg2);
            return arg1 - arg2;
        }
        if (list.get(index)[0].equals("MULT")){
            list.get(index)[0] = "VALUE";
            list.get(index)[1] = "" + (arg1 * arg2);
            return arg1 * arg2;
        }
        return 0;
    }
    public static void spreetSheet2() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String operation = in.next();
            String arg1 = in.next();
            String arg2 = in.next();
            cells.add(new Cell(operation, arg1, arg2));
        }
        for (Cell cell : cells) {
            System.out.println(cell.evaluate(cells));
        }
    }
    private static class Cell {

        String operation;
        String arg1;
        String arg2;
        Integer value;

        public Cell(String operation, String arg1, String arg2){
            this.operation = operation;
            this.arg1 = arg1;
            this.arg2 = arg2;
        }

        public int evaluate(List<Cell> cells){
            if (value==null){
                switch(operation) {
                    case "VALUE":
                        value = parse(arg1, cells);
                        break;
                    case "ADD":
                        value = parse(arg1, cells) + parse(arg2, cells);
                        break;
                    case "SUB":
                        value = parse(arg1, cells) - parse(arg2, cells);
                        break;
                    case "MULT":
                        value = parse(arg1, cells) * parse(arg2, cells);
                        break;
                }
            }
            return value;
        }

        private int parse(String s, List<Cell> cells) {
            if (s.startsWith("$")){
                return cells.get(Integer.parseInt(s.substring(1))).evaluate(cells);
            }
            return Integer.parseInt(s);
        }
    }
}