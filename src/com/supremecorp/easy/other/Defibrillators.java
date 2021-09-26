package com.supremecorp.easy.other;

import java.util.Scanner;

/**
 * Created by suprememajor on the 9/26/21
 */
public class Defibrillators {
    public static void defibrillator() {
        Scanner in = new Scanner(System.in);
        String SLON = in.next();
        String SLAT = in.next();
        int N = in.nextInt();

        SLON = SLON.replaceAll(",", ".");
        SLAT = SLAT.replaceAll(",", ".");

        if (in.hasNextLine()) {
            in.nextLine();
        }

        double record = Math.pow(2,99);

        String location = "";

        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();

            String WORDS[] = DEFIB.split(";");

            String SLON_ = WORDS[4];
            String SLAT_ = WORDS[5];

            SLON_ = SLON_.replaceAll(",", ".");
            SLAT_ = SLAT_.replaceAll(",", ".");

            double LON = Double.parseDouble(SLON);
            double LON_ = Double.parseDouble(SLON_);
            double LAT = Double.parseDouble(SLAT);
            double LAT_ = Double.parseDouble(SLAT_);

            double x = (LON_-LON)*Math.cos(Math.toRadians((LAT-LAT_)/2));
            double y = LAT_-LAT;
            double d = Math.sqrt((Math.pow(x,2)+Math.pow(y,2))) * 6371;

            if(d < record) {
                record = d;
                location = WORDS[1];
            }
        }

        System.out.print(location);
    }
}
