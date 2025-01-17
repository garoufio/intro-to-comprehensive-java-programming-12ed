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
//      int rows = readSize(sc, "rows");
//      int columns = readSize(sc, "columns");
//      int[][] values = readArrayValues(sc, rows, columns);
//      System.out.printf("Is consecutive four? %b", isConsecutiveFour(values));
      
//      int[][] test1 = new int[][] {
//          {4, 5, 6, 7, 8, 9},
//          {2, 1, 1, 1, 1, 3}
//      };
//      System.out.println("Check rows 1: " + checkRows(test1));
//      System.out.println("Check columns 1: " + checkColumns(test1));
//      int[][] test2 = new int[][] {
//          {4, 5, 6, 7, 8, 9},
//          {2, 1, 2, 1, 1, 3}
//      };
//      System.out.println("Check rows 2: " + checkRows(test2));
//      System.out.println("Check columns 2: " + checkColumns(test2));
//      int[][] test3 = new int[][] {
//          {4, 5, 6, 7, 8, 9},
//          {2, 1, 2, 1, 1, 3},
//          {4, 5, 1, 6, 8, 9},
//          {3, 5, 9, 7, 4, 3},
//          {2, 5, 6, 2, 8, 9}
//      };
//      System.out.println("Check rows 3: " + checkRows(test3));
//      System.out.println("Check columns 3: " + checkColumns(test3));
//      int[][] test4 = new int[][] {
//          {4, 7, 6, 7, 8, 9},
//          {2, 5, 2, 1, 1, 3},
//          {4, 5, 1, 6, 8, 9},
//          {3, 5, 9, 7, 4, 3},
//          {2, 5, 6, 2, 8, 9}
//      };
//      System.out.println("Check rows 4: " + checkRows(test4));
//      System.out.printf("Check columns 4: %b\n", checkColumns(test4));
//      System.out.println("Check columns 3: " + checkColumns(test3));
      int[][] test5 = new int[][] {
          {4, 7, 6, 7, 8, 9},
          {2, 5, 2, 1, 1, 3},
          {4, 5, 5, 6, 8, 9},
          {3, 5, 9, 5, 4, 3},
          {2, 5, 6, 2, 5, 9}
      };
      System.out.println("Check major diagonal 5: " + checkMajorDiagonal(test5));
      System.out.printf("Check sub diagonal 5: %b\n", checkSubDiagonal(test5));
      int[][] test6 = new int[][] {
          {4, 7, 6, 7, 8, 9},
          {2, 5, 2, 1, 9, 3},
          {4, 5, 1, 9, 8, 9},
          {3, 5, 9, 7, 4, 3},
          {2, 5, 6, 2, 8, 9}
      };
      System.out.println("Check major diagonal 6: " + checkMajorDiagonal(test6));
      System.out.printf("Check sub diagonal 6: %b\n", checkSubDiagonal(test6));
      int[][] test7 = new int[][] {
          {4, 7, 6, 7, 8, 9},
          {2, 5, 2, 1, 7, 3},
          {4, 5, 5, 9, 8, 9},
          {3, 5, 9, 5, 4, 3},
          {2, 5, 6, 2, 8, 9}
      };
      System.out.println("Check major diagonal 7: " + checkMajorDiagonal(test7));
      System.out.printf("Check sub diagonal 7: %b\n", checkSubDiagonal(test7));
    }
    catch (InputMismatchException e) {
      System.out.println("Invalid input! " + e.getMessage());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValid(int size, String msg) {
    if (size <= 0) {
      System.out.printf("%s size must be greater than '0'\n", msg, size);
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readSize(Scanner sc, String msg) {
    int size = 0;
    
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
    int count;
    for (int row = 0; row < values.length; row++) { // rows
      count = 0;
      for (int column = 0; column < values[row].length - 1; column++) { // columns
        if (values[row][column] == values[row][column + 1]) {
          count++;
          if (count == 3) return true;
          else continue;
        }
        count = 0;
      }
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkColumns(int[][] values) {
    int count;
    for (int column = 0; column < values[0].length; column++) { // columns
      count = 0;
      for (int row = 0; row < values.length - 1; row++) { // rows
        if (values[row][column] == values[row + 1][column]) {
          count++;
          if (count == 3) return true;
          else continue;
        }
        count = 0;
      }
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkMajorDiagonal(int[][] values) {
    // check right part
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < values[i].length; j++) {
      
      }
    }
    
    // check left part
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkSubDiagonal(int[][] values) {
    // check right part
    
    // check left part
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isConsecutiveFour(int[][] values) {
    return checkColumns(values) || checkColumns(values) || checkMajorDiagonal(values) || checkSubDiagonal(values);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
