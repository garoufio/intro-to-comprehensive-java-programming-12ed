package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Prompts the user to enter a 4-by-4 matrix and displays the sum of the major diagonal.
 */
public class Exercise8_2 {
  
  public static final int ARRAY_SIZE = 4;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    double[][] matrix = readArray();
    
    System.out.printf("Sum of elements in the major diagonal is '%.2f'\n", sumMajorDiagonal(matrix));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double sumMajorDiagonal(double[][] m) {
    double sum = 0;
    
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        if (i == j) sum += m[i][j];
      }
    }
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readArray() {
    double[][] matrix = new double[ARRAY_SIZE][ARRAY_SIZE];
    
    try (Scanner scanner = new Scanner(System.in);) {
      System.out.printf("Enter a %d-by-%d matrix row by row:\n", ARRAY_SIZE, ARRAY_SIZE);
      for (int i = 0; i < ARRAY_SIZE; i++) {
        for (int j = 0; j < ARRAY_SIZE; j++) {
          matrix[i][j] = scanner.nextDouble();
        }
      }
    }
    catch (InputMismatchException e) {
      throw new RuntimeException(e);
    }
    return matrix;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
