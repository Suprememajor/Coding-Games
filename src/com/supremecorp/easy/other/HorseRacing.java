package com.supremecorp.easy.other;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by suprememajor on 9/27/21
 */
public class HorseRacing {
    public static void horseRacing() {
        Scanner scanner = new Scanner(System.in);
        Integer[] integers = Stream.generate(scanner::nextInt).limit(scanner.nextInt()).sorted().toArray(Integer[]::new);
        System.out.println(IntStream.range(1, integers.length).map(i -> integers[i] - integers[i-1]).sorted().toArray()[0]);
    }
}
