package com.supremecorp.easy.mine;

import java.util.Arrays;
import java.util.Scanner;

public class MerlinsMagicSquare {
    static String[] square;

    public static void merlinsMagicSquare() {
        String[] allButtonsPressed = new String[0];
        square = new String[9];
        try (Scanner in = new Scanner(System.in)) {
            for (int i = 0; i < 3; i++) {
                String[] input = in.nextLine().split(" ");
                System.arraycopy(input, 0, square, i * 3, 3);
            }
            allButtonsPressed = in.nextLine().split("");
        } catch (Exception exception) {
            System.err.println(Arrays.toString(exception.getStackTrace()));
        }
        String[] endpoint = {"*", "*", "*", "*", "~", "*", "*", "*", "*"};
        String[] tempArray = new String[9];
        Arrays.stream(allButtonsPressed).forEach(str -> touchButton(Integer.parseInt(str)));
        System.arraycopy(square, 0, tempArray, 0, 9);
        for (int i = 1; i <= 9; i++) {
            touchButton(i);
            if (Arrays.equals(square, endpoint)) {
                System.out.println(i);
                break;
            }
            System.arraycopy(tempArray, 0, square, 0, 9);
        }
    }

    public static void touchButton(int pos) {
        flipBit(pos);
        if (pos == 5) { // for 5
            for (int i = 2; i <= 8; i += 2)
                flipBit(i);
        } else if (pos == 2 || pos == 8) { // for 2 and 8
            flipBit(pos - 1);
            flipBit(pos + 1);
        } else if (pos % 2 == 0) {  // for 4 and 6
            flipBit(pos - 3);
            flipBit(pos + 3);
        } else { //for 1, 3, 7, and 9
            flipBit(5);
            if (pos == 1 || pos == 7) {// for 1 and 7
                flipBit(4);
                flipBit(pos + 1);
            } else { // for 3 and 9
                flipBit(6);
                flipBit(pos - 1);
            }
        }
    }

    private static void flipBit(int pos) {
        square[pos - 1] = square[pos - 1].equals("~") ? "*" : "~";
    }
}
