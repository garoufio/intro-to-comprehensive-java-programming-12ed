package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * (Identical arrays) The two-dimensional arrays m1 and m2 are identical if they have the same content. The program
 * prompts the user to enter two 3 * 3 arrays of integers and displays whether the two are identical or not.
 */
public class Exercise8_29 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[] indices = readMatrixIndices(sc);
      int[][] matrix1 = readMatrix(sc, indices);
      int[][] matrix2 = readMatrix(sc, indices);
      
      if (equals(matrix1, matrix2)) {
        System.out.println("The two arrays are identical");
      }
      else {
        System.out.println("The two arrays are not identical");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean equals(int[][] m1, int[][] m2) {
    if (m1 == null || m2 == null) return false;
    
    int len1 = m1.length * m1[0].length;
    int len2 = m2.length * m2[0].length;
    if (len1 != len2) return false;
    
    int[] array1 = new int[len1];
    int[] array2 = new int[len2];
    int index = 0;
    // flatten array1
    for (int[] row : m1) {
      for (int col : row) {
        array1[index++] = col;
      }
    }
    // flatten array2
    index = 0;
    for (int[] row : m2) {
      for (int col : row) {
        array2[index++] = col;
      }
    }
    // sort array1 and array2
    Arrays.sort(array1);
    Arrays.sort(array2);
    // compare elements
    for (int i = 0; i < len1; i++) {
      if (array1[i] != array2[i]) return false;
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
