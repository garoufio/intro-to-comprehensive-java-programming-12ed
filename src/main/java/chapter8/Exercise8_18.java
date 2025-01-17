package chapter8;

import java.util.Arrays;

/**
 * Shuffles the rows in a two-dimensional int array.
 */
public class Exercise8_18 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int[][] array = {
        {1, 2}, {3, 4},
        {5, 6}, {7, 8},
        {9, 10}
    };
    
    System.out.println("Original Array:");
    printMatrix(array);
    System.out.printf("\nShuffled array:\n");
    shuffle(array);
    printMatrix(array);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int generateRandomInt(int min, int max) {
    return (int)(Math.random() * (max - min + 1) + min);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void shuffle(int[][] m) {
    int rowIndex, columnIndex;
    int[][] array = new int[m.length][m[0].length];
    boolean[][] occupied =  new boolean[m.length][m[0].length];
    
    array2DCopy(m, array);
    for (int i = 0; i < m.length; i++ ) {
      for (int j = 0; j < m[i].length; j++) {
        for (; ; ) {
          rowIndex = generateRandomInt(0, m.length - 1);
          columnIndex = generateRandomInt(0, m[i].length - 1);
          
          if (occupied[rowIndex][columnIndex] == false) {
            int x = m[i][j];
            array[rowIndex][columnIndex] = x;
            occupied[rowIndex][columnIndex] = true;
            break;
          }
        }
      }
    }
    array2DCopy(array, m);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void array2DCopy(int[][] src, int[][] dest) {
    for (int i = 0; i < src.length; i++) {
      for (int j = 0; j < src[0].length; j++) {
        dest[i][j] = src[i][j];
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMatrix(int[][] m) {
    for (int[] row : m) {
      System.out.println(Arrays.toString(row));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
