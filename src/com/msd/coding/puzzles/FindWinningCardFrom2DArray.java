package com.msd.coding.puzzles;

import java.util.Arrays;

/**
 * Objective: Find the biggest non-repeating number, from a 2 dimensional array
 * Player A, B, C -> each gets a random number of cards
 * Each player can put the highest non-repeating card from their set
 * The highest number on table determines the winning card
 */
public class FindWinningCardFrom2DArray {
    public static void main(String[] args) {
        int[] a = {5, 7, 3, 9, 4, 9, 8, 3, 1}; // Player A
        int[] b = {1, 2, 2, 4, 4, 1};
        int[] c = {1, 2, 3};
        int[][] cards = {a, b, c};

        // Sort the players cards in ascending order
        for (int[] card : cards) {
            Arrays.sort(card);
            System.out.println(Arrays.toString(card));
        }

        int res = -1;

        for (int[] card : cards) {
            int big = -1;
            // Iterate the cards backwards
            for (int i=card.length - 1;i>0;i-- ) {
                System.out.println(card[i]);
                if (card[i] > card[i-1]) {
                    big = card[i];
                    System.out.println("Big is "+ big);
                    // We have the best card for this player, skip other cards
                    break;
                } else if (card[i] == card[i-1]) {
                    // May be big, but this card is not eligible as it is repeated, skip next card
                    // and continue validating other cards
                    i--;
                }
            }
            // Winning card is the biggest of the best card from each player
            res = Math.max(res, big);

        }
        System.out.println("Winning Card is " + res);
    }


}
