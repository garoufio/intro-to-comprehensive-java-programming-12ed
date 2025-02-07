package chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise8_20 {
  
  public static final int NUMBER_OF_ROWS = 6;
  public static final int NUMBER_OF_COLUMNS = 7;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      play(input);
    }
    catch (Exception e) {
      System.out.println("Invalid input! " + e.getMessage());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkRows(char[][] board) {
    boolean hasConsecutiveFour;
    for (char[] row : board) { // check every row
      for (int column = 0; column <= row.length - 4; column++) {
        hasConsecutiveFour = true;
        for (int i = column; i < column + 3; i++) { // check columns by a window of 4 values
          if ((row[i] == ' ' && row[i + 1] == ' ') || (row[i] != row[i + 1])) {
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
  
  public static boolean checkColumns(char[][] board) {
    boolean hasConsecutiveFour;
    for (int column = 0; column < board[0].length; column++) { // check every column
      for (int row = 0; row <= board.length - 4; row++) {
        hasConsecutiveFour = true;
        for (int i = row; i < row + 3; i++) { // check rows by a window of 4 values
          if ((board[i][column] == ' ' && board[i + 1][column] == ' ') || (board[i][column] != board[i + 1][column])) {
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
  
  public static boolean checkDiagonals(char[][] board) {
    boolean hasConsecutiveFour;
    
    // check from left to right
    for (int row = 0; row <= board.length - 4; row++) {
      for (int column = 0; column <= board[row].length - 4; column++) {
        hasConsecutiveFour = true;
        for (int i = row, j = column; i < row + 3 && j < column + 3; i++, j++) {
          if ((board[i][j] == ' ' && board[i + 1][j + 1] == ' ') || (board[i][j] != board[i + 1][j + 1])) {
            hasConsecutiveFour = false;
            break;
          }
        }
        if (hasConsecutiveFour) return true;
      }
    }
    
    // check from right to left
    for (int row = 0; row <= board.length - 4; row++) {
      for (int column = board[row].length - 1; column >= 3; column--) {
        hasConsecutiveFour = true;
        for (int i = row, j = column; i < row + 3 && j > column - 3; i++, j--) {
          if ((board[i][j] == ' ' && board[i + 1][j - 1] == ' ') || (board[i][j] != board[i + 1][j - 1])) {
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
  
  public static boolean isConsecutiveFour(char[][] board) {
    return checkRows(board) || checkColumns(board) || checkDiagonals(board);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMatrix(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      System.out.print("|");
      for (int column = 0; column < board[row].length; column++) {
        System.out.printf("%c|", board[row][column]);
      }
      System.out.println();
    }
    for (int row = 0; row < 2 * board[0].length + 1; row++) {
      System.out.print("-");
    }
    System.out.println();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validateInput(int column) {
    return (column >= 0 && column < NUMBER_OF_COLUMNS);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readInput(Scanner sc, boolean isRed) {
    int column;
    do {
      System.out.printf("Drop a %s disk at column (0 - %d): ", isRed ? "red" : "yellow", NUMBER_OF_COLUMNS - 1);
      column = sc.nextInt();
      if (column < 0 || column > NUMBER_OF_COLUMNS - 1) {
        System.out.println("Invalid column! Please try again.");
      }
    } while (!validateInput(column));
    
    return column;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidColumnPosition(char[][] board, int column) {
    for (int row = board.length - 1; row >= 0; row--) {
      if (board[row][column] == ' ') return true;
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void placeDisk(char[][] board, int column, boolean isRed) {
    for (int row = board.length - 1; row >= 0; row--) {
      if (board[row][column] == ' ') {
        board[row][column] = isRed ? 'R' : 'Y';
        break;
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isBoardFull(char[][] board) {
    for (int column = 0; column < board[0].length; column++) {
      for (int row = board.length - 1; row >= 0; row--) {
        if (board[row][column] == ' ') return false;
      }
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void initializeBoard(char[][] board) {
    for (char[] row : board) {
      Arrays.fill(row, ' ');
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void play(Scanner sc) {
    char[][] board = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    initializeBoard(board);
    
    boolean isRed = true;
    int numberOfplays = 0;
    int column;
    for (;;) {
      if (isBoardFull(board)) {
        System.out.printf("It's a tie!\n");
        break;
      }
      
      printMatrix(board);
      // read input
      for (;;) {
        column = readInput(sc, isRed);
        if (isValidColumnPosition(board, column)) {
          placeDisk(board, column, isRed);
          break;
        }
        System.out.println("Column is full! Please try again.");
      }
      
      if (isConsecutiveFour(board)) {
        System.out.printf("The '%s' player won\n", isRed ? "red" : "yellow");
        break;
      }
      numberOfplays++;
      isRed = numberOfplays % 2 == 0;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
