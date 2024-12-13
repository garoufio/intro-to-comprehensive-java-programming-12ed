package chapter8;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (Explore matrix) The program prompts the user to enter the length of a square matrix, randomly fills in 0s and 1s
 * into the matrix, prints the matrix, and finds the rows, columns, and diagonals with all 0s or 1s.
 */
public class Exercise8_14 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      int matrixLength = getSquareMatrixLength(input);
      int[][] squareMatrix = createSquareMatrix(matrixLength);
      printMatrix(squareMatrix);
      
      // get rows filled with 0s
      int[] array0 = getRowsFilledWithSameNumber(squareMatrix, 0);
      // get rows filled with 1s
      int[] array1 = getRowsFilledWithSameNumber(squareMatrix, 1);
      printArrayWithSameNumber(array0, array1, "row");
      
      // get columns filled with 0s
      array0 = getColumnsFilledWithSameNumber(squareMatrix, 0);
      // get columns filled with 1s
      array1 = getColumnsFilledWithSameNumber(squareMatrix, 1);
      printArrayWithSameNumber(array0, array1, "column");
      
      // check if major diagonal is filled with 0s or 1s
      if (isMajorDiagonalFilledWithSameNumber(squareMatrix, 0)) {
        System.out.println("All 0s on the major diagonal");
      }
      else if (isMajorDiagonalFilledWithSameNumber(squareMatrix, 1)) {
        System.out.println("All 1s on the major diagonal");
      }
      else {
        System.out.println("No same numbers on the major diagonal");
      }
      
      // check if sub-diagonal is filled with 0s or 1s
      if (isSubDiagonalFilledWithSameNumber(squareMatrix, 0)) {
        System.out.println("All 0s on the sub-diagonal");
      }
      else if (isSubDiagonalFilledWithSameNumber(squareMatrix, 1)) {
        System.out.println("All 1s on the sub-diagonal");
      }
      else {
        System.out.println("No same numbers on the sub-diagonal");
      }
    }
    catch (InputMismatchException e) {
      System.err.println("Invalid input. Program will exit.");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validateLength(int length) {
    if (length <= 0) {
      System.out.println("Length cannot be less than or equal to zero. Please try again.");
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getSquareMatrixLength(Scanner scanner) {
    int length;
    
    do {
      System.out.print("Enter the length of the square matrix: ");
      length = scanner.nextInt();
    } while (!validateLength(length));
    
    return length;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int generateRandomNumber(int min, int max) {
    return (int)(Math.random() * (max - min + 1) + min);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] createSquareMatrix(int length) {
    int[][] array = new int[length][length];
    
    for (int row = 0; row < length; row++) {
      for (int col = 0; col < length; col++) {
        array[row][col] = generateRandomNumber(0, 1);
      }
    }
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getRowsFilledWithSameNumber(int[][] array, int number) {
    int[] rows = new int[array.length];
    int count, index = 0;
   
    Arrays.fill(rows, -1);
    for (int row = 0; row < array.length; row++) {
      count = 0;
      for (int col = 0; col < array[row].length; col++) {
        if (array[row][col] == number) count++;
      }
      if (count == array.length) {
        rows[index] = row;
        index++;
      }
    }
    return rows;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getColumnsFilledWithSameNumber(int[][] array, int number) {
    int[] columns = new int[array[0].length];
    int count, index = 0;
    
    Arrays.fill(columns, -1);
    for (int col = 0; col < array[0].length; col++) {
      count = 0;
      for (int row = 0; row < array.length; row++) {
        if (array[row][col] == number) count++;
      }
      if (count == array[0].length) {
        columns[index] = col;
        index++;
      }
    }
    return columns;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isMajorDiagonalFilledWithSameNumber(int[][] array, int number) {
    int count = 0;
    
    for (int row = 0, col = 0; row < array.length && col < array[0].length; row++, col++) {
      if (array[row][col] == number) count++;
    }
    return count == array.length;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isSubDiagonalFilledWithSameNumber(int[][] array, int number) {
    int count = 0;
    
    for (int row = 0, col = array[row].length - 1; row < array.length && col >= 0; row++, count--) {
      if (array[row][col] == number) count++;
    }
    return count == array.length;
  }

  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printArrayWithSameNumber(int[] arrayWith0s, int[] arrayWith1s, String location) {
    boolean linesWithSameNumberExist = false;
    
    for (int value : arrayWith0s) {
      if (value != -1) {
        System.out.printf("All 0s on %s %d\n", location, value);
        linesWithSameNumberExist = true;
      }
    }
    
    for (int value : arrayWith1s) {
      if (value != -1) {
        System.out.printf("All 1s on %s %d\n", location, value);
        linesWithSameNumberExist = true;
      }
    }
    
    if (!linesWithSameNumberExist) System.out.printf("No same numbers on any %s\n", location);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      for (int col : row) {
        System.out.print(col);
      }
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
