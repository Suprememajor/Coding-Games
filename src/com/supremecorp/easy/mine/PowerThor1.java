package com.supremecorp.easy.mine;

import java.util.Scanner;

/**
 * Created by suprememajor on 10/9/21
 */
public class PowerThor1 {
    public static void thorPower() {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if(initialTx < lightX && initialTy < lightY){
                initialTx++;
                initialTy++;
                System.out.println("SE");
            }
            else if(initialTx < lightX && initialTy > lightY){
                initialTx++;
                initialTy--;
                System.out.println("NE");
            }
            else  if(initialTx > lightX && initialTy < lightY){
                initialTx--;
                initialTy++;
                System.out.println("SW");
            }
            else if(initialTx > lightX && initialTy > lightY){
                initialTx--;
                initialTy--;
                System.out.println("NW");
            }
            else if(initialTx < lightX){
                initialTx++;
                System.out.println("E");
            }
            else if(initialTx > lightX){
                initialTx--;
                System.out.println("W");
            }
            else  if(initialTy < lightY){
                initialTy++;
                System.out.println("S");
            }
            else if(initialTy > lightY){
                initialTy--;
                System.out.println("N");
            }

            // A single line providing the move to be made: N NE E SE S SW W or NW

        }
    }
}
