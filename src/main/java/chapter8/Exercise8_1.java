package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Prompts the user to enter a 3-by-4 matrix and displays the sum of each column.
 */
public class Exercise8_1 {
  
  public static final int NUMBER_OF_ROWS = 3;
  public static final int NUMBER_OF_COLUMNS = 4;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    double[][] matrix = readArray();
    
    printSumOfColumns(matrix);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double sumColumn(double[][] m, int columnIndex) {
    double sum = 0;
    
    for (double[] row : m) {
      sum += row[columnIndex];
    }
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printSumOfColumns(double[][] m) {
    for (int i = 0; i < m[0].length; i++) {
      System.out.printf("Sum of elements at column '%d' is '%.2f'\n", i, sumColumn(m, i));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readArray() {
    double[][] matrix = new double[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    
    try (Scanner scanner = new Scanner(System.in);) {
      System.out.printf("Enter a %d-by-%d matrix row by row:\n", NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
      for (int i = 0; i < NUMBER_OF_ROWS; i++) {
        for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
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
