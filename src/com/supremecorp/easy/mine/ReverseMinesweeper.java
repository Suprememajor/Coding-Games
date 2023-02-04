package com.supremecorp.easy.mine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseMinesweeper {
    static int w, h;
    static int[][] solution;

    public static void reverseMinesweeper() {
        Scanner in = new Scanner(System.in);
        w = in.nextInt();
        h = in.nextInt();
        String[][] map = new String[h][w];
        solution = new int[h][w];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < h; i++) {
            String line = in.nextLine();
            map[i] = line.split("");
        }
        in.close();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j].equals("x")) {
                    getNeighbors(new Point(j, i)).forEach(point -> solution[point.y][point.x]++);
                    solution[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = solution[i][j] <= 0 ? "." : "" + solution[i][j];
            }
            System.out.println(String.join("", map[i]));
        }
    }

    static List<Point> getNeighbors(Point p) {
        List<Point> points = new ArrayList<>();
        if (p.x == 0) {
            if (p.y == 0) {
                points.add(new Point(p.x, p.y + 1));
                points.add(new Point(p.x + 1, p.y));
                points.add(new Point(p.x + 1, p.y + 1));
            } else if (p.y == h - 1) {
                points.add(new Point(p.x, p.y - 1));
                points.add(new Point(p.x + 1, p.y));
                points.add(new Point(p.x + 1, p.y - 1));
            } else {
                points.add(new Point(p.x, p.y + 1));
                points.add(new Point(p.x + 1, p.y));
                points.add(new Point(p.x + 1, p.y + 1));
                points.add(new Point(p.x, p.y - 1));
                points.add(new Point(p.x + 1, p.y - 1));
            }
        } else if (p.x == w - 1) {
            if (p.y == 0) {
                points.add(new Point(p.x, p.y + 1));
                points.add(new Point(p.x - 1, p.y));
                points.add(new Point(p.x - 1, p.y + 1));
            } else if (p.y == h - 1) {
                points.add(new Point(p.x, p.y - 1));
                points.add(new Point(p.x - 1, p.y));
                points.add(new Point(p.x - 1, p.y - 1));

            } else {
                points.add(new Point(p.x, p.y + 1));
                points.add(new Point(p.x - 1, p.y));
                points.add(new Point(p.x - 1, p.y + 1));
                points.add(new Point(p.x, p.y - 1));
                points.add(new Point(p.x - 1, p.y - 1));
            }
        } else {
            if (p.y == 0) {
                points.add(new Point(p.x, p.y + 1));
                points.add(new Point(p.x + 1, p.y));
                points.add(new Point(p.x + 1, p.y + 1));
                points.add(new Point(p.x - 1, p.y));
                points.add(new Point(p.x - 1, p.y + 1));
            } else if (p.y == h - 1) {
                points.add(new Point(p.x, p.y - 1));
                points.add(new Point(p.x + 1, p.y));
                points.add(new Point(p.x + 1, p.y - 1));
                points.add(new Point(p.x - 1, p.y));
                points.add(new Point(p.x - 1, p.y - 1));
            } else {
                points.add(new Point(p.x - 1, p.y - 1));
                points.add(new Point(p.x, p.y - 1));
                points.add(new Point(p.x + 1, p.y - 1));
                points.add(new Point(p.x - 1, p.y + 1));
                points.add(new Point(p.x, p.y + 1));
                points.add(new Point(p.x + 1, p.y + 1));
                points.add(new Point(p.x - 1, p.y));
                points.add(new Point(p.x + 1, p.y));
            }
        }
        return points;
    }

    record Point(int x, int y) {
    }
}
