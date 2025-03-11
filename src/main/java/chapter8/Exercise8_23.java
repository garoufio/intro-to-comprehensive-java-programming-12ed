package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * (Game: find the flipped cell) Suppose you are given a 6-by-6 matrix filled with 0s and 1s. All rows and all columns
 * have an even number of 1s. Let the user flip one cell (i.e., flip from 1 to 0 or from 0 to 1) and the program finds
 * which cell was flipped. The program prompts the user to enter a 6-by-6 array with 0s and 1s and finds the first row r
 * and first column c where the even number of the 1s property is violated (i.e., the number of 1s is not even). The
 * flipped cell is at (r, c).
 */
public class Exercise8_23 {
  
  public static final int NUMBER_OF_ROWS = 6;
  public static final int NUMBER_OF_COLUMNS = 6;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int[][] array = readArray(scanner);
      int[] flippedCell = findFlippedCell(array);
      
      if (flippedCell[0] == -1 || flippedCell[1] == -1) {
        System.out.println("There are no flipped cells in the array.");
      }
      else {
        System.out.printf("The flipped cell is at (%d, %d).\n", flippedCell[0], flippedCell[1]);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidArray(int[][] array) {
    for (int[] row : array) {
      for (int col : row) {
        if (!(col == 1 || col == 0)) {
          System.out.println("\nArray must only contain 1 or 0!");
          return false;
        }
      }
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] readArray(Scanner sc) {
    int[][] array = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    
    do {
      System.out.println("Enter a 6-by-6 matrix row by row: ");
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
          array[i][j] = sc.nextInt();
        }
      }
    } while (!isValidArray(array));
    
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean hasRowEvenNumberOf1s(int[] row) {
    int count1s = 0;
    
    for (int element : row) {
      if (element == 1) count1s++;
    }
    return count1s != 0 && count1s % 2 == 0;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean hasColumnEvenNumberOf1s(int[][] array, int column) {
    int count1s = 0;
    
    for (int i = 0; i < array.length; i++) {
      if (array[i][column] == 1) count1s++;
    }
    return count1s != 0 && count1s % 2 == 0;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] findFlippedCell(int[][] array) {
    int[] flippedCell = new int[2];
    
    Arrays.fill(flippedCell, -1);
    for (int i = 0; i < array.length; i++) {
      if (!hasRowEvenNumberOf1s(array[i])) {
        for (int j = 0; j < array[i].length; j++) {
          if (!hasColumnEvenNumberOf1s(array, j)) {
            flippedCell[0] = i;
            flippedCell[1] = j;
            return flippedCell;
          }
        }
      }
    }
    return flippedCell;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
