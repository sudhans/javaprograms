package src.com.msd.coding.puzzles;

// Zero represents empty cells.
// one or more zeros will make the solution invalid

public class ValidateSudoku {
    private static int[][] invalidBoard1 = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}
    };

    private static int[][] validBoard1 = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    // Initialize 3 set of 9x9 boards to Zero
    private static int[][] row = new int[9][9];
    private static int[][] column = new int[9][9];
    private static int[][] box = new int[9][9];

    public static void main(String[] args) {
        System.out.println("Is valid Sudoku:: " + isValidSudoku(validBoard1));
    }

    private static boolean isValidSudoku(int board[][]){
        int value = 0;
        int boxNo = 0;
        for (int i=0;i<board.length;i++ ) {
            for (int j=0;j<board[i].length;j++) {
                if (board[i][j] == 0) {
                    return false;
                }
                value = board[i][j] - 1; // Converting value to map to an array index
                boxNo = 3 * (i/3) + (j/3);
                if (row[i][value] == 1 || column[j][value]==1 || box[boxNo][value] == 1) {
                    System.out.println("Not a valid sudoku - at Row " + (i+1) + " column " + (j+1) +" we have invalid entry::  " + (value+1));
                    if (row[i][value]==1) {
                        System.out.println("Duplicate entry at Row " + (i+1));
                    } else if (column[j][value]==1) {
                        System.out.println("Duplicate entry at Column " + (j+1));
                    } else {
                        System.out.println("Duplicate entry at Box " + (boxNo + 1));
                    }
                    return false;
                }

                row[i][value] = 1;
                column[j][value] = 1;
                box[boxNo][value] = 1;

            }
        }
        System.out.println("Congratulations!!");
        return true;
    }



//    // Just printing to see if we get the correct rows
//    private static void printRows(){
//        for (int i=0;i<board.length;i++) {
//            System.out.println("Row - " + i);
//            for (int j=0;j<board[i].length;j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    // Test method to see if we get correct columns
//    private static void printColumns() {
//        for (int i=0;i<board.length;i++) {
//            System.out.println("Column - " + i);
//            for (int j=0;j<board[i].length;j++) {
//                System.out.print(board[j][i] + " ");
//            }
//            System.out.println();
//        }
//    }
}
