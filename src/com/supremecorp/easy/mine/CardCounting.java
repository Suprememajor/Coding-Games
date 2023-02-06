package com.supremecorp.easy.mine;

import java.util.Arrays;
import java.util.Scanner;

public class CardCounting {
    static final int CARD_NUMBER = 52;
    static int lowCards, threshold, totalCards;

    public static void cardCounting() {
        String streamOfConsciousness = null;
        try (Scanner in = new Scanner(System.in)) {
            streamOfConsciousness = in.nextLine();
            threshold = in.nextInt();
        } catch (Exception exception) {
            System.err.println(Arrays.toString(exception.getStackTrace()));
        }
        assert streamOfConsciousness != null;
        String[] strings = streamOfConsciousness.split("[.]");
        for (String str : strings) {
            if (isValidThought(str)) {
                count(str);
            }
        }
        int cardNumberLeft = CARD_NUMBER - totalCards;
        int lowerCardsLeft = (threshold - 1) * 4 - lowCards;
        long percentage = Math.round(100.0 * lowerCardsLeft / cardNumberLeft);
        System.out.println(percentage + "%");
    }

    static boolean isValidThought(String str) {
        return str.matches("[A2-9TJQK]+");
    }

    static void count(String str) {
        int length = str.length();
        totalCards += length;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'A') {
                lowCards = (threshold > 1) ? lowCards + 1 : lowCards;
            } else {
                if (!Character.toString(str.charAt(i)).matches("[TJQK]")) {
                    lowCards = (threshold > Integer.parseInt(str.charAt(i) + "")) ? lowCards + 1 : lowCards;
                }
            }
        }
    }
}
