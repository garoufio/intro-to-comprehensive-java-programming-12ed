package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * (Column sorting) The program prompts the user to enter an n * n matrix of double values and displays a new
 * column-sorted matrix.
 */
public class Exercise8_27 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[] indices = readMatrixIndices(sc);
      double[][] matrix = readMatrix(sc, indices);
      
      double[][] sortedMatrix = sortColumns(matrix);
      printMatrix(sortedMatrix);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] sortColumns(double[][] m) {
    double[][] sortedMatrix = new double[m.length][m[0].length];
    double[] columns = new double[m.length];
    
    for (int c = 0; c < m[0].length; c++) {
      for (int r = 0; r < m.length; r++) {
        columns[r] = m[r][c];
      }
      Arrays.sort(columns);
      for (int r = 0; r < m.length; r++) {
        sortedMatrix[r][c] = columns[r];
      }
    }
    return sortedMatrix;
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
  
  public static double[][] readMatrix(Scanner sc, int[] indices) {
    double[][] matrix = new double[indices[0]][indices[1]];
    
    System.out.printf("Enter a %d-by-%d matrix row by row:\n", indices[0], indices[1]);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = sc.nextDouble();
      }
    }
    return matrix;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMatrix(double[][] m) {
    System.out.println("The column-sorted matrix is:");
    for (double[] row : m) {
      System.out.println(Arrays.toString(row));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
