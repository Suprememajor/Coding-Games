package com.supremecorp.easy.mine;

import java.util.*;

public class Asteroids {
    static int t1;
    static int t2;
    static int t3;
    public static void asteroids() {
        Map<Character, Asteroid> asteroids = new HashMap<>();

        int w;
        int h;
        char[][] chars;
        Asteroid currentAsteroid;
        try (Scanner in = new Scanner(System.in)) {
            w = in.nextInt();
            h = in.nextInt();
            chars = new char[w][h];
            t1 = in.nextInt();
            t2 = in.nextInt();
            t3 = in.nextInt();
            char currentChar;
            for (int i = 0; i < h; i++) {
                String firstPictureRow = in.next();
                for (int j = 0; j < firstPictureRow.length(); j++) {
                    currentChar = firstPictureRow.charAt(j);
                    if (currentChar == '.') {
                        continue;
                    } else if (asteroids.containsKey(currentChar)) {
                        currentAsteroid = asteroids.get(currentChar);
                    } else {
                        currentAsteroid = new Asteroid();
                        asteroids.put(currentChar, currentAsteroid);
                    }
                    currentAsteroid.setStartX(j);
                    currentAsteroid.setStartY(i);
                }
                String secondPictureRow = in.next();
                for (int j = 0; j < secondPictureRow.length(); j++) {
                    currentChar = secondPictureRow.charAt(j);
                    if (currentChar == '.') {
                        continue;
                    } else if (asteroids.containsKey(currentChar)) {
                        currentAsteroid = asteroids.get(currentChar);
                    } else {
                        currentAsteroid = new Asteroid();
                        asteroids.put(currentChar, currentAsteroid);
                    }
                    currentAsteroid.setNextX(j);
                    currentAsteroid.setNextY(i);
                }
            }
        }
        Set<Character> keys = asteroids.keySet();
        List<Character> keyList = new ArrayList<>(keys);
        Collections.reverse(keyList);

        for (Asteroid asteroid: asteroids.values()) {
            setFinalValues(asteroid);
        }
        for (int i = 0; i < w; i++)
            for (int j = 0; j < h; j++)
                chars[j][i] = '.';
        for (Character c: keyList) {
            currentAsteroid = asteroids.get(c);
            int finalX = currentAsteroid.getFinalX();
            int finalY = currentAsteroid.getFinalY();
            if (finalX < 0 || finalX >= w || finalY < 0 || finalY >= h)
                continue;
            chars[finalX][finalY] = c;
        }
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                System.out.print(chars[j][i]);
            }
            System.out.println();
        }
    }

    static void setFinalValues(Asteroid asteroid) {
        float changeT1T2 = (t2 - t1) * 1.0f;
        int changeT1T3 = t3 - t1;
        int changeX1X2 = asteroid.getNextX() - asteroid.getStartX();
        int changeY1Y2 = asteroid.getNextY() - asteroid.getStartY();
        float dydt = changeY1Y2 / changeT1T2;
        float dxdt = changeX1X2 / changeT1T2;
        asteroid.setFinalX((int)Math.floor(dxdt * changeT1T3) + asteroid.getStartX());
        asteroid.setFinalY((int)Math.floor(dydt * changeT1T3) + asteroid.getStartY());
    }
}
class Asteroid {
    private int startX;
    private int startY;
    private int nextX;
    private int nextY;
    private int finalX;
    private int finalY;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getNextX() {
        return nextX;
    }

    public void setNextX(int nextX) {
        this.nextX = nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public void setNextY(int nextY) {
        this.nextY = nextY;
    }

    public int getFinalX() {
        return finalX;
    }

    public void setFinalX(int finalX) {
        this.finalX = finalX;
    }

    public int getFinalY() {
        return finalY;
    }

    public void setFinalY(int finalY) {
        this.finalY = finalY;
    }
}