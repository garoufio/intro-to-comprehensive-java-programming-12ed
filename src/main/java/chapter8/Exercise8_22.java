package chapter8;

import java.util.Arrays;

/**
 * (Even number of 1s) The program generates a 6-by-6 two-dimensional matrix filled with 0s and 1s, displays the matrix,
 * and checks if every row and every column have an even number of 1s.
 */
public class Exercise8_22 {
  
  public static final int NUMBER_OF_ROWS = 6;
  public static final int NUMBER_OF_COLUMNS = 6;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int[][] matrix = generateRandomMatrix();
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
    
    System.out.printf("Does matrix have even number of 1s in any of its rows? %b\n", haveRowsEvenNumberOf1s(matrix));
    System.out.printf(
        "Does matrix have even number of 1s in any of its columns? %b\n",
        haveColumnsEvenNumberOf1s(matrix)
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int generateRandomNumber(int min, int max) {
    return (int) (Math.random() * (max - min + 1)) + min;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] generateRandomMatrix() {
    int[][] matrix = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    
    for (int i = 0; i < NUMBER_OF_ROWS; i++) {
      for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
        matrix[i][j] = generateRandomNumber(0, 1);
      }
    }
    return matrix;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean haveRowsEvenNumberOf1s(int[][] matrix) {
    int count;
    
    for (int[] row : matrix) {
      count = 0;
      for (int e : row) {
        if (e == 1) {
          count++;
          if (count != 0 && count % 2 == 0) return true;
        }
      }
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean haveColumnsEvenNumberOf1s(int[][] matrix) {
    int count;
    
    for (int col = 0; col < matrix[0].length; col++) {
      count = 0;
      for (int row = 0; row < matrix.length; row++) {
        if (matrix[row][col] == 1) {
          count++;
          if (count != 0 && count % 2 == 0) return true;
        }
      }
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
