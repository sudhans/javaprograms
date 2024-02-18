package com.msd.coding.puzzles;

// Move Backward: If cell i-1 exists and contains a , you can walk back to cell i-1

public class LeapGameCanWin1DArray {
    public static void main(String[] args) {
        int a[] = {0,0,0, 0,1,0};
        int b[] = {0,0,0,0,0};
        int c[] = {0,0,0,1,0,0,1,0,1,0,1,0,0,1,1};
        int d[] = {0, 1, 0};
//        System.out.println(canWin(3, a));
//        System.out.println(canWin(3, b));
//        System.out.println(canWin(5, c));
        System.out.println(canWin(2, a));
    }

    private static boolean canWin(int leap, int[]game) {

        for (int i=0;i<game.length;) {
            if (i + leap >= game.length) {
                System.out.println("Leaped to win");
                return true;
            }
            if (game[i + leap] == 0) {
                System.out.println("Leaped to " + (i + leap));
                i= i + leap;
            } else if (game[i+1] == 0) {
                System.out.println("Moving to " + (i + 1));
                i++;
            } else {
                System.out.println("Declaring lost at " + i);
                return false;
            }
        }

        System.out.println("Completed Loop ");
        return true;
    }
}
