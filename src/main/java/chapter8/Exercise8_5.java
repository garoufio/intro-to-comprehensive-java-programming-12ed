package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (Algebra: add two matrices) The program prompts the user to enter two matrices, adds them and prints the result.
 */
public class Exercise8_5 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      double[][] array1 = readArray(input);
      double[][] array2 = readArray(input);
      double[][] result = addArrays(array1, array2);
      System.out.println("The result of the addition is:");
      printArray(result);
    }
    catch (InputMismatchException e) {
      System.err.println("Invalid input");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readArray(Scanner scanner) {
    int rows, columns;
    
    do {
      System.out.print("Enter the size of the array: ");
      rows = scanner.nextInt();
      columns = scanner.nextInt();
      if (rows <= 0 || columns <= 0) {
        System.out.println("Size must be greater than 0");
      }
    } while (rows <= 0 || columns <= 0);
    scanner.nextLine();
    
    double[][] array = new double[rows][columns];
    System.out.print("Enter matrix elements: ");
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = scanner.nextInt();
      }
    }
    scanner.nextLine();
    
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validateArrays(double[][] array1, double[][] array2) {
    if (array1 == null || array2 == null) return false;
    if (array1.length != array2.length) {
      System.err.println("Arrays do not have the same number of rows.");
      return false;
    }
    
    boolean inconsistentColumns = false;
    for (int i = 0; i < array1.length; i++) {
      if (array1[i].length != array2[i].length) {
        System.err.printf("Arrays do not have the same number of columns. Check columns of row '%d'\n", i);
        if (!inconsistentColumns) inconsistentColumns = true;
      }
    }
    if (inconsistentColumns) return false;
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] addArrays(double[][] array1, double[][] array2) {
    if (!validateArrays(array1, array2)) return null;
    
    double[][] result = new double[array1.length][array1[0].length];
    for (int row = 0; row < result.length; row++) {
      for (int col = 0; col < result[row].length; col++) {
        result[row][col] = array1[row][col] + array2[row][col];
      }
    }
    return result;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printArray(double[][] array) {
    for (int row = 0; row < array.length; row++) {
      for (int col = 0; col < array[row].length; col++) {
        System.out.print(array[row][col]);
        if (col < array[row].length - 1) System.out.print(" ");
      }
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
