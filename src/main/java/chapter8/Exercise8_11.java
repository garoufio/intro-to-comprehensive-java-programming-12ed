package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (Game: nine heads and tails) Nine coins are placed in a 3-by-3 matrix with some face up and some face down. You can
 * represent the state of the coins using a 3-by-3 matrix with values 0 (heads) and 1 (tails). Each state can also be
 * represented using a binary number. Here are some examples:
 *  0 0 0   1 0 1   1 1 0   1 0 1   1 0 0
 *  0 1 0   0 0 1   1 0 0   1 1 0   1 1 1
 *  0 0 0   1 0 0   0 0 1   1 0 0   1 1 0
 * For example, the preceding matrices correspond to the numbers 000010000 101001100 110100001 101110100 100111110.
 * There are a total of 512 possibilities, so you can use decimal numbers 0, 1, 2, 3, ... and 511 to represent all
 * states of the matrix. The program prompts the user to enter a number between 0 and 511 and displays the corresponding
 * matrix with the characters H (stands for 0) and T (stands for 1).
 */
public class Exercise8_11 {
  
  public static final int GRID_SIZE = 3;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      int number = getNumber(input);
      char[][] grid = createGrid(number);
      printGrid(grid);
    }
    catch (InputMismatchException e) {
      e.printStackTrace();
      System.err.println("Invalid input");
    }
     }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validateNumber(int number) {
    if(number < 0 || number > 511) {
      System.out.printf("Number '%d' is out of range\n", number);
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumber(Scanner scanner) {
    int number;
    do {
      System.out.print("Enter an integer between 0 and 511: ");
      number = scanner.nextInt();
    } while (!validateNumber(number));
    
    return number;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String convertNumberToBits(int number) {
    return String.format("%09d", Integer.parseInt(Integer.toBinaryString(number)));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static char convertToHeadOrTail(char ch) {
    return ch == '0' ? 'H' : 'T';
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static char[][] createGrid(int number) {
    char[][] grid = new char[GRID_SIZE][GRID_SIZE];
    String numberString = convertNumberToBits(number);
    
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int col = 0; col < GRID_SIZE; col++) {
        grid[row][col] = convertToHeadOrTail(numberString.charAt((row * GRID_SIZE) + col));
      }
    }
    return grid;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printGrid(char[][] grid) {
    for (char[] row : grid) {
      for (int i = 0; i < row.length; i++) {
        System.out.print(row[i]);
        if (i != row.length - 1) System.out.print(" ");
      }
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
