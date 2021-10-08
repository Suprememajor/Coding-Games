package com.supremecorp.easy.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by suprememajor on 10/8/21
 */
public class ChildsPlay {
    static char[][] maze;
    public static void childsPlay() {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        long n = in.nextLong();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        maze = new char[h][w];
        Robot robot = new Robot();
        for (int i = 0; i < h; i++) {
            String line = in.nextLine();
            maze[i] = line.toCharArray();
            int robotX = line.indexOf('O');
            if (robotX >= 0) {
                robot.setPosition(robotX, i);
            }
        }

        Loop loop = new Loop();
        for (long l = 0; l < n; l++) {
            loop.add(robot);
            robot.move(maze);
            if (loop.isClosed(robot)) {
                l += ((n - l) / loop.length) * loop.length;
            }
        }
        System.out.println(robot);
    }
}


class Loop
{
    List<String> visited = new ArrayList<>();
    long length = 0;

    public void add(Robot robot)
    {
        visited.add(robot.dirAndPos());
    }

    public boolean isClosed(Robot robot)
    {
        String dirAndPos = robot.dirAndPos();
        if (visited.contains(dirAndPos)) {
            length = visited.size() - visited.indexOf(dirAndPos);
            return true;
        }
        return false;
    }
}


class Robot
{
    enum Direction {
        UP(0, -1, 1), RIGHT(1, 0, 2), DOWN(0, 1, 3), LEFT(-1, 0, 0);

        private int dx;
        private int dy;
        private int nextDirOrd;

        Direction(int dx, int dy, int nextDirOrd)
        {
            this.dx = dx;
            this.dy = dy;
            this.nextDirOrd = nextDirOrd;
        }
    }

    int x;
    int y;
    Direction dir;
    Direction[] dirValues = Direction.values();

    Robot()
    {
        x = 0;
        y = 0;
        dir = Direction.UP;
    }

    void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void move(char[][] maze)
    {
        while (maze[y + dir.dy][x + dir.dx] == '#') {
            turnRight();
        }
        y += dir.dy;
        x += dir.dx;
    }

    void turnRight()
    {
        dir = dirValues[dir.nextDirOrd];
    }

    String dirAndPos()
    {
        return new StringBuilder().append(dir).append("|").append(x).append("|").append(y).toString();
    }

    @Override
    public String toString()
    {
        return x + " " + y;
    }
}