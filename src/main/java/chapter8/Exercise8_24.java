package chapter8;

import java.util.Scanner;

/**
 * (Check Sudoku solution) Listing 8.4 checks whether a solution is valid by checking whether every number is valid in
 * the board. Rewrite the program by checking whether every row, every column, and every small box has the numbers 1
 * to 9.
 */
public class Exercise8_24 {
  
  public static final int NUMBER_OF_ROWS = 9;
  public static final int NUMBER_OF_COLUMNS = 9;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[][] array = readArray(sc);
      
      if (isValidSolution(array)) {
        System.out.printf("The solution is valid");
      }
      else {
        System.out.printf("The solution is not valid");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] readArray(Scanner sc) {
    int[][] array = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    
    System.out.println("Enter a 9-by-9 matrix row by row:");
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = sc.nextInt();
      }
    }
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidSolution(int[][] array) {
    if (array == null || array.length == 0 || array[0].length == 0) return false;
    if (array.length % 3 != 0) return false;
    
    return hasValidRows(array) && hasValidColumns(array) && hasValidCells(array);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean isValidArray(int[] row) {
    for (int i = 0; i < row.length; i++) {
      if (!isValidNumber(row[i], 1, row.length)) return false;
      
      for (int j = i + 1; j < row.length; j++) {
        if (row[j] == row[i]) return false;
      }
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean isValidNumber(int number, int min, int max) {
    return number >= min && number <= max;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean hasValidRows(int[][] array) {
    for (int row = 0; row < array.length; row++) {
      if (isValidArray(array[row]) == false) return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean hasValidColumns(int[][] array) {
    for (int col = 0; col < array[0].length; col++) {
      for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
          if (array[j][col] == array[i][col]) return false;
        }
      }
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean hasValidCells(int[][] array) {
    int len = array.length / 3;
    
    for (int columnCell = 0; columnCell < len; columnCell++) {
      for (int rowCell = 0; rowCell < len; rowCell++) {
        int[] cell = new int[array.length];
        int index = 0;
        
        for (int row = rowCell * len; row < rowCell * len + 3; row++) {
          for (int column = columnCell * len; column < columnCell * len + 3; column++) {
            cell[index] = array[row][column];
            index++;
          }
        }
        //System.out.println(Arrays.toString(cell));
        if (isValidArray(cell) == false) return false;
      }
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
