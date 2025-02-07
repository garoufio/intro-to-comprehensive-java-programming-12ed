package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (Pattern recognition: four consecutive equal numbers) Prompts the user to enter the number of rows and columns of a
 * two-dimensional array, then the values in the array, and displays true if the array contains four consecutive
 * numbers with the same value either horizontally, vertically, or diagonally. Otherwise, the program displays false.
 */
public class Exercise8_19 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int rows = readSize(sc, "rows");
      int columns = readSize(sc, "columns");
      int[][] values = readArrayValues(sc, rows, columns);
      System.out.printf("Is consecutive four? %b", isConsecutiveFour(values));
    }
    catch (InputMismatchException e) {
      System.out.println("Invalid input! " + e.getMessage());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValid(int size, String msg) {
    if (size <= 0) {
      System.out.printf("%s size must be greater than '0'\n", msg);
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readSize(Scanner sc, String msg) {
    int size;
    
    do {
      System.out.printf("Enter %s size: ", msg);
      size = sc.nextInt();
    } while (!isValid(size, msg));
    
    return size;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] readArrayValues(Scanner sc, int rows, int columns) {
    int[][] array = new int[rows][columns];
    
    System.out.printf("Enter '%d' array elements:\n", rows * columns);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        array[i][j] = sc.nextInt();
      }
    }
    sc.nextLine();
    
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkRows(int[][] values) {
    boolean hasConsecutiveFour;
    for (int[] row : values) { // check every row
      for (int column = 0; column <= row.length - 4; column++) {
        hasConsecutiveFour = true;
        for (int i = column; i < column + 3; i++) { // check columns by a window of 4 values
          if (row[i] != row[i + 1]) {
            hasConsecutiveFour = false;
            break;
          }
        }
        if (hasConsecutiveFour) return true;
      }
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkColumns(int[][] values) {
    boolean hasConsecutiveFour;
    for (int column = 0; column < values[0].length; column++) { // check every column
      for (int row = 0; row <= values.length - 4; row++) {
        hasConsecutiveFour = true;
        for (int i = row; i < row + 3; i++) { // check rows by a window of 4 values
          if (values[i][column] != values[i + 1][column]) {
            hasConsecutiveFour = false;
            break;
          }
        }
        if (hasConsecutiveFour) return true;
      }
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkDiagonals(int[][] values) {
    boolean hasConsecutiveFour;
    
    // check from left to right
    for (int row = 0; row <= values.length - 4; row++) {
      for (int column = 0; column <= values[row].length - 4; column++) {
        hasConsecutiveFour = true;
        for (int i = row, j = column; i < row + 3 && j < column + 3; i++, j++) {
          if (values[i][j] != values[i + 1][j + 1]) {
            hasConsecutiveFour = false;
            break;
          }
        }
        if (hasConsecutiveFour) return true;
      }
    }
    
    // check from right to left
    for (int row = 0; row <= values.length - 4; row++) {
      for (int column = values[row].length - 1; column >= 3; column--) {
        hasConsecutiveFour = true;
        for (int i = row, j = column; i < row + 3 && j > column - 3; i++, j--) {
          if (values[i][j] != values[i + 1][j - 1]) {
            hasConsecutiveFour = false;
            break;
          }
        }
        if (hasConsecutiveFour) return true;
      }
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isConsecutiveFour(int[][] values) {
    return checkRows(values) || checkColumns(values) || checkDiagonals(values);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
