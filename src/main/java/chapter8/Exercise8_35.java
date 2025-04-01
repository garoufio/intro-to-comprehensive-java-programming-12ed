package chapter8;

import java.util.Scanner;

/**
 * (Largest block) Given a square matrix with the elements 0 or 1, write a program to find a maximum square sub-matrix
 * whose elements are all 1s. The program prompts the user to enter the number of rows in the matrix and then displays
 * the location of the first element in the maximum square sub-matrix and the number of rows in the sub-matrix. The
 * return value is an array that consists of three values. The first two values are the row and column indices for the
 * first element in the sub-matrix, and the third value is the number of the rows in the sub-matrix.
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
        System.out.println("There is no square sub-matrix");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] findLargestBLock(int[][] m) {
    int[] block = new int[3]; // #row, #column, len
    int[] vector;
    
    if (m == null || m.length == 0 || m[0].length == 0) return block;
    
    for (int maxLen = m.length; maxLen > 1; maxLen--) {
      for (int row = 0; row + maxLen <= m.length; row++) {
        for (int col = 0; col + maxLen <= m[row].length; col++) {
          vector = flattenMatrix(extractSquareSubMatrix(m, row, col, maxLen));
          if (vector == null) continue;
          
          //System.out.println(maxLen + ":" + Arrays.toString(vector));
          
          if (isAll1s(vector)) {
            block[0] = row;
            block[1] = col;
            block[2] = maxLen;
            return block;
          }
        }
      }
    }
    return block;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] extractSquareSubMatrix(int[][] m, int fromRow, int fromColumn, int len) {
    if (m == null || m.length == 0 || m[0].length == 0) return null;
    
    int[][] subMatrix = new int[len][len];
    for (int i = 0, row = fromRow; (i < len) && (fromRow + len <= m.length); i++, row++) {
      for (int j = 0, col = fromColumn; (j < len) && (fromColumn + len <= m[row].length); j++, col++) {
        subMatrix[i][j] = m[row][col];
      }
    }
    return subMatrix;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] flattenMatrix(int[][] m) {
    if (m == null || m.length == 0 || m[0].length == 0) return null;
    
    int[] vector = new int[m.length * m[0].length];
    int index = 0;
    for (int row = 0; row < m.length; row++) {
      for (int col = 0; col < m[row].length; col++) {
        vector[index] = m[row][col];
        index++;
      }
    }
    return vector;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isAll1s(int[] v) {
    if (v == null || v.length == 0) return false;
    
    for (int i : v) {
      if (i != 1) return false;
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
