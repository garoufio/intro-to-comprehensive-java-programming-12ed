package chapter8;

import java.util.Scanner;

/**
 * (Markov matrix) An n * n matrix is called a positive Markov matrix if each
 * element is positive and the sum of the elements in each column is 1. Write the
 * following method to check whether a matrix is a Markov matrix
 */
public class Exercise8_25 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[] indices = readMatrixIndices(sc);
      double[][] matrix = readMatrix(sc, indices);
      
      if (isMarkovMatrix(matrix)) {
        System.out.println("It is a Markov matrix");
      }
      else {
        System.out.println("It is not a Markov matrix");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
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
  
  public static boolean isMarkovMatrix(double[][] matrix) {
    double sum;
    
    for (int col = 0; col < matrix[0].length; col++) {
      sum = 0.0;
      
      for (int row = 0; row < matrix.length; row++) {
        if (matrix[row][col] < 0) return false;
        
        sum += matrix[row][col];
      }
      if (Math.abs(sum - 1.0) > 0.00001) return false;
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
  
}
