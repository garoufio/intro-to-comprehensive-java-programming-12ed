package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (Locate the largest element) The program returns the location of the largest element in a two-dimensional array.
 * The return value is a one-dimensional array that contains two elements. These two elements indicate the row and
 * column indices of the largest element in the two-dimensional array. If there are more than one largest element,
 * the smallest row index and then the smallest column index will be returned. The program prompts the user to enter a
 * two-dimensional array, and then it displays the location of the largest element in the array.
 */
public class Exercise8_13 {
  
  public static final double EPSILON = 10E-5;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      int[] dimensions = readArrayDimensions(input);
      double[][] array = read2DArray(input, dimensions[0], dimensions[1]);
      int[] minElementLocation = getLocationOfLargestElement(array);
      System.out.printf(
          "The location of the largest element is at (%d, %d)\n",
          minElementLocation[0], minElementLocation[1]
      );
    }
    catch (InputMismatchException e) {
      System.err.println("Invalid input. Program will exit.");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validateDimension(int dimension, boolean isRow) {
    if (dimension < 0) {
      System.out.printf("Number of %s cannot be less than 0. Please try again.\n", isRow ? "rows" : "columns");
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readArrayDimensions(Scanner scanner) {
    int[] dimensions = new int[2];
    
    do {
      System.out.print("Enter number of rows and columns of the array: ");
      dimensions[0] = scanner.nextInt();
      dimensions[1] = scanner.nextInt();
    } while (!(validateDimension(dimensions[0], true) && validateDimension(dimensions[1], false)));
    scanner.nextLine();
    
    return dimensions;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] read2DArray(Scanner scanner, int rows, int columns) {
    double[][] array = new double[rows][columns];
    
    System.out.println("Enter the array: ");
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        array[row][col] = scanner.nextDouble();
      }
    }
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getLocationOfLargestElement(double[][] array) {
    double max = array[0][0];
    int[] maxIndices = new int[2];
    
    for (int row = 0; row < array.length; row++) {
      for (int col = 0; col < array[row].length; col++) {
        if (array[row][col] - max > EPSILON) {
          max = array[row][col];
          maxIndices[0] = row;
          maxIndices[1] = col;
        }
      }
    }
    return maxIndices;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
