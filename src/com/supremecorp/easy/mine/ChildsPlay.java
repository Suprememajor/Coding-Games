
package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
*Created by suprememajor on 10/8/21
*/
public class ChildsPlay {
    static Direction direction = Direction.UP;
    public static void childsPlay() {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        long n = in.nextLong();
        int currentX = 0, currentY = 0;
        int initX = 0, initY = 0;
        int turnCount = 0, count = 0;
        char[][] map = new char[h][w];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < h; i++) {
            map[i] = toCharArray(in.nextLine().split(""));
        }
        in.close();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(map[i][j] == 'O'){
                    currentX = j;
                    currentY = i;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(count == 10){
                initX = currentX;
                initY = currentY;
                n -= i;
                i = 0;
            } else if(i != 0 && currentX == initX && currentY == initY && turnCount == 0){
                turnCount = i;
                n = (int) (n % turnCount);
                i = 0;
            }
            switch(direction){
                case UP:
                    if(map[currentY - 1][currentX] != '#'){
                        currentY--;
                    }else{
                        direction = Direction.RIGHT;
                        count++;
                        i--;
                    }
                    break;
                case DOWN:
                    if(map[currentY + 1][currentX] != '#'){
                        currentY++;
                    }else{
                        direction = Direction.LEFT;
                        count++;
                        i--;
                    }
                    break;
                case LEFT:
                    if(map[currentY][currentX - 1] != '#'){
                        currentX--;
                    }else{
                        direction = Direction.UP;
                        i--;
                        count++;
                    }
                    break;
                case RIGHT:
                    if(map[currentY][currentX + 1] != '#'){
                        currentX++;
                    }else{
                        direction = Direction.DOWN;
                        i--;
                        count++;
                    }
                    break;
            }
        }

        System.out.println(currentX + " " + currentY);
    }
    static char[] toCharArray(String[] str){
        char[] charArray = new char[str.length];
        for(int i = 0; i < str.length; i++)
            charArray[i] = str[i].charAt(0);
        return charArray;
    }
    enum Direction{
        UP, RIGHT, LEFT, DOWN
    }
}
