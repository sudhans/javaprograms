package src.com.msd.coding.puzzles;

import java.util.Arrays;

/**
 * You are given an array arr, consisting of zeros, ones and twos
 * Sort the same array in-place and return it. Do not create a new array
 *
 * arr[] = { 0, 1, 2, 2, 1, 0} should be arranged to {0, 0, 1, 1, 2, 2}
 * arr[] = { 2, 2,1, 2, 1, 0} should be arranged to {0, 1, 1, 2, 2, 2}
 *
 * Note: Have start pointer, end pointer and current.
 * If current is 2, swap to end
 * If current is 0, swap to start
 * move start and end pointers as required, after swap
 */
public class SortItUp
{
    public static void main(String[] args) {

        int arr[]= {0, 1, 2, 2, 1, 0};

        int start = 0;
        int end = arr.length - 1;
        int current = 0;
        while (current <= end) {
            switch(arr[current]) {
                case 0:
                    if (current > start) {
                        swapNumbers(arr, current, start);
                    }
                    start++;
                    current++;
                    break;
                case 1:
                      current++;
                    break;
                case 2:
                    swapNumbers(arr, current, end);
                    end --;
                    break;
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    private static void swapNumbers(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
