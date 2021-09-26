package com.supremecorp.easy.mine;

import java.util.*;

/**
 * Created by suprememajor on the 9/26/21
 */
public class Defibrillators {
    static String LON;
    static String LAT;

    public static void defibrillator() {
        Map<Double, String>  map= new HashMap<>();
        ArrayList<Double> dist = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        LON = in.next();
        LAT = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] temp = DEFIB.split(";");
            Double distance = getDist(toDecimal(temp[temp.length - 2]), toDecimal(temp[temp.length - 1]));
            map.put(distance, temp[1]);
            dist.add(distance);
        }
        Collections.sort(dist);

        System.out.println(map.get(dist.get(0)));
    }
    public static Double toDecimal(String doubleStr){
        doubleStr = doubleStr.replace(',', '.');
        return Double.parseDouble(doubleStr);
    }
    public static double getDist(double lng, double lat){
        double x, y, d;
        double newLON = toDecimal(LON);
        double newLAT = toDecimal(LAT);
        x = (Math.toRadians(lng) - Math.toRadians(newLON))*Math.cos((Math.toRadians(newLAT) + Math.toRadians(lat)) / 2);
        y = Math.toRadians(lat) - Math.toRadians(newLAT);
        d = Math.sqrt(Math.pow(x, 2)+ Math.pow(y, 2)) * 6371;
        return d;
    }
}
