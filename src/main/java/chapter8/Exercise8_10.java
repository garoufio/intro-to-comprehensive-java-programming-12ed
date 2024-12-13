package chapter8;

import java.util.Arrays;

/**
 * (Largest row and column) The program randomly fills in 0s and 1s into a 4-by-4 matrix, prints the matrix, and finds
 * the first row and column with the most 1s.
 */
public class Exercise8_10 {
  
  public static final int GRID_SIZE = 4;
  public static final int MIN_NUMBER = 0;
  public static final int MAX_NUMBER = 1;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int[][] array = create2DArray();
    print2DArray(array);
    System.out.printf("The largest row index is '%d'\n", getRowWithMost1s(array));
    System.out.printf("The largest column index is '%d'\n", getColumnWithMost1s(array));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int createRandomNumber(int min, int max) {
    return (int)(Math.random() * (max - min + 1) + min);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] create2DArray() {
    int[][] array = new int[GRID_SIZE][GRID_SIZE];
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        array[i][j] = createRandomNumber(MIN_NUMBER, MAX_NUMBER);
      }
    }
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getRowWithMost1s(int[][] array) {
    int count1s;
    int maxCount = 0;
    int maxCountRowIndex = 0;
    
    for (int row = 0; row < array.length; row++) {
      count1s = 0;
      for (int col = 0; col < array[row].length; col++) {
        if (array[row][col] == 1) count1s++;
      }
      if (count1s > maxCount) {
        maxCount = count1s;
        maxCountRowIndex = row;
      }
    }
    return maxCountRowIndex;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getColumnWithMost1s(int[][] array) {
    int count1s;
    int maxCount = 0;
    int maxCountColumnIndex = 0;
    
    for (int col = 0; col < array[0].length; col++) {
      count1s = 0;
      for (int row = 0; row < array.length; row++) {
        if (array[row][col] == 1) count1s++;
      }
      if (count1s > maxCount) {
        maxCount = count1s;
        maxCountColumnIndex = col;
      }
    }
    return maxCountColumnIndex;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void print2DArray(int[][] array) {
    for (int[] row : array) {
      System.out.println(Arrays.toString(row));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
