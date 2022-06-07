package com.msd.coding.puzzles;

/**
 * if the given numbers are {3, 2, 3, 4, 5}, the duplicate number is 3 and the missing number is 1
 * if the given numbers are {1, 2, 3, 4, 4}, the duplicate number is 4 and the missing number is 5
 */

public class FindMissingNumberReplacedByAnotherNumber {
    public static void main(String[] args) {
        int[] a = {1, 2, 3,4, 3};
        // Has complexity of o(n)
        for (int i=0;i<a.length;i++) {
            if (a[i] != (i + 1)) {
                System.out.println("Duplicate Number is " + a[i] + " missing number is " + (i+1));
            }

        }
    }
}
