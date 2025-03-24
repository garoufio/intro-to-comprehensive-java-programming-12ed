package chapter8;

import java.util.Scanner;

/**
 * (Strictly identical arrays) The two-dimensional arrays m1 and m2 are strictly identical if their corresponding
 * elements are equal. The program prompts the user to enter two n * n arrays of integers and displays whether the two
 * are strictly identical or not.
 */
public class Exercise8_28 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[] indices = readMatrixIndices(sc);
      int[][] matrix1 = readMatrix(sc, indices);
      int[][] matrix2 = readMatrix(sc, indices);
      
      if (strictlyEquals(matrix1, matrix2)) {
        System.out.println("The two arrays are strictly identical");
      }
      else {
        System.out.println("The two arrays are not strictly identical");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean strictlyEquals(int[][] m1, int[][] m2) {
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
  
  public static int[] readMatrixIndices(Scanner sc) {
    int[] indices = new int[2];
    
    do {
      System.out.print("Enter the indices of the matrix (rows x columns): ");
      indices[0] = sc.nextInt(); // number of rows
      indices[1] = sc.nextInt(); // number of columns
    } while (indices[0] <= 0 || indices[1] <= 0);
    
    return indices;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] readMatrix(Scanner sc, int[] indices) {
    int[][] matrix = new int[indices[0]][indices[1]];
    
    System.out.printf("Enter a %d-by-%d matrix row by row:\n", indices[0], indices[1]);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    return matrix;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
