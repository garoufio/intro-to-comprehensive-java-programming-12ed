package chapter8;

import java.util.Scanner;

/**
 * (Latin square) A Latin square is an n-by-n array filled with n different Latin letters, each occurring exactly once
 * in each row and once in each column. The program prompts the user to enter the number n and the array of characters,
 * and checks if the input array is a Latin square. The characters are the first n characters starting from A.
 */
public class Exercise8_36 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int numberOfRows = getNumberOfRows(sc);
      char[][] matrix = readMatrix(sc, numberOfRows);
      System.out.printf("\nIs the input array a Latin square? %b\n", isLatinSquare(matrix));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isLatinSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) return false;
    
    // check by row
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length - 1; j++) {
        for (int k = j + 1; k < matrix[i].length; k++) {
          if (matrix[i][j] == matrix[i][k]) return false;
        }
      }
    }
    // check by column
    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = 0; j < matrix.length - 1; j++) {
        for (int k = j + 1; k < matrix.length; k++) {
          if (matrix[j][i] == matrix[k][i]) return false;
        }
      }
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumberOfRows(Scanner sc) {
    int numberOfRows;
    
    do {
      System.out.print("Enter the number of rows: ");
      numberOfRows = sc.nextInt();
      if (numberOfRows <= 0) System.out.println("Number of rows must be greater than 0");
    } while (numberOfRows <= 0);
    
    return numberOfRows;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static char[][] readMatrix(Scanner sc, int numberOfRows) {
    char[][] points = new char[numberOfRows][2];
    
    System.out.printf("Enter '%d' characters: ", numberOfRows * numberOfRows);
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        points[i][j] = Character.toUpperCase(sc.next().charAt(0));
      }
    }
    return points;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
