package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * (Largest block) Given a square matrix with the elements 0 or 1, write a program to find a maximum square submatrix
 * whose elements are all 1s. The program prompts the user to enter the number of rows in the matrix and then displays
 * the location of the first element in the maximum square submatrix and the number of rows in the submatrix. The
 * return value is an array that consists of three values. The first two values are the row and column indices for the
 * first element in the submatrix, and the third value is the number of the rows in the submatrix.
 */
public class Exercise8_35 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int numberOfRows = getNumberOfRows(sc);
      int[][] matrix = readMatrix(sc, numberOfRows);
      int[] largestBlock = findLargestBLock(matrix);
      
      if (largestBlock != null && largestBlock[0] > 1) {
        System.out.printf(
            "The maximum square submatrix is at (%d, %d) with size %d\n",
            largestBlock[0], largestBlock[1], largestBlock[2]
        );
      }
      else {
        System.out.println("There is no square submatrix");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] findLargestBLock(int[][] m) {
    int[] block = new int[3]; // (#row, #column, len
    int row, col, len = 0;
    
//    1 0 1 0 1
//    1 1 1 0 1
//    1 0 1 1 1
//    1 0 1 1 1
//    1 0 1 1 1
    for (int maxLen = m.length; maxLen > 1; maxLen--) {
      // generate n x n array of 1s
      int[][] arrayOf1s = generateArraysOf1s(maxLen);
      // extract n x n subarray from array
      int[][] subArray = new int[1][1];
      // compare arrays
      if (compare2DArrays(arrayOf1s, subArray)) {
        block[0] = maxLen;
        block[1] = maxLen;
        block[2] = maxLen;
        break;
      }
    }
    return block;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] generateArraysOf1s(int n) {
    int[][] matrix = new int[n][n];
    for (int[] row : matrix) {
      Arrays.fill(row, 1);
    }
    return matrix;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] extractSubArray(int[][] m, int row, int col, int len) {
    int[][] subArray = new int[len][len];
    
    for (int i = row; i < row + len && i < m.length; i++) {
      for (int j = col; j < col + len && i < m[i].length; j++) {
        subArray[i][j] = m[i][j];
      }
    }
    return subArray;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean compare2DArrays(int[][] m1, int[][] m2) {
    if (m1 == null || m2 == null) return false;
    if (m1.length != m2.length) return false;
    
    for (int i = 0; i < m1.length; i++) {
      if (m1[i].length != m2[i].length) return false;
      
      for (int j = 0; j < m1[i].length; j++) {
        if (m1[i][j] != m2[i][j]) return false;
      }
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumberOfRows(Scanner sc) {
    int numberOfRows = 0;
    
    do {
      System.out.print("Enter the number of rows: ");
      numberOfRows = sc.nextInt();
      if (numberOfRows <= 0) System.out.println("Number of rows must be greater than 0");
    } while (numberOfRows <= 0);
    
    return numberOfRows;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] readMatrix(Scanner sc, int numberOfRows) {
    int[][] points = new int[numberOfRows][2];
    
    System.out.printf("Enter '%d' bits: ", numberOfRows * numberOfRows);
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = sc.nextInt();
      }
    }
    return points;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
