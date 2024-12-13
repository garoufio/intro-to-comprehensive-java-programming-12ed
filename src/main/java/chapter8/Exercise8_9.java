package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take turns marking an available cell in a
 * 3 * 3 grid with their respective tokens (either X * or O). When one player has placed three tokens in a horizontal,
 * vertical, or diagonal row on the grid, the game is over and that player has won. A draw (no winner) occurs when all
 * the cells on the grid have been filled with tokens and neither player has achieved a win. Create a program for
 * playing a tic-tac-toe game. The program prompts two players to alternately enter an X token and O token. Whenever a
 * token is entered, the program displays the board on the console and determines the status of the game (win, draw,
 * or continue).
 */
public class Exercise8_9 {
  
  public static final int GRID_SIZE = 3;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    play();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validatePoint(int[] point) {
    if (point == null) {
      System.out.println("Input point is null");
      return false;
    }
    if (point[0] < 0 || point[0] > GRID_SIZE) {
      System.out.println("Input row is out of bounds. Please try again.");
      return false;
    }
    if (point[1] < 0 || point[1] > GRID_SIZE) {
      System.out.println("Input column is out of bounds. Please try again.");
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readPoint(Scanner scanner, char player) {
    int[] point = new int[2];
    
    do {
      System.out.printf("Enter a row (0, 1 or 2) for player %c: ", player);
      point[0] = scanner.nextInt();
      System.out.printf("Enter a column (0, 1 or 2) for player %c: ", player);
      point[1] = scanner.nextInt();
    } while (!validatePoint(point));
    scanner.nextLine();
    
    return point;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printBoard(char[][] board) {
    System.out.println("-------------");
    for (int row = 0; row < board.length; row++) {
      System.out.print("|");
      for (int col = 0; col < board[row].length; col++) {
        System.out.printf(" %c |", board[row][col]);
      }
      System.out.println("\n-------------");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isCellFee(char[][] board, int[] point) {
    return board[point[0]][point[1]] == ' ';
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkRows(char[][] board) {
    int count;
    for (int row = 0; row < board.length; row++) {
      count = 0;
      for (int col = 1; col < board[row].length; col++) {
        if (board[row][col - 1] == ' ') break;
        if (board[row][col] == board[row][col - 1]) {
          count++;
        }
      }
      if (count == board.length - 1) return true;
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkColumns(char[][] board) {
    int count;
    for (int col = 0; col < board[0].length; col++) {
      count = 0;
      for (int row = 1; row < board.length; row++) {
        if (board[row - 1][col] == ' ') break;
        if (board[row][col] == board[row - 1][col]) count++;
      }
      if (count == board[0].length - 1) return true;
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkMainDiagonal(char[][] board) {
    int count = 0;
    for (int row = 1, col = 1; row < board.length && col < board[row].length; row++, col++) {
      if (board[row - 1][col - 1] == ' ') return false;
      if (board[row][col] == board[row - 1][col - 1]) count++;
    }
    return count == board.length - 1;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean checkCounterDiagonal(char[][] board) {
    int count = 0;
    for (int row = 1, col = 1; row < board.length && col >= 0; row++, col--) {
      if (board[row - 1][col + 1] == ' ') return false;
      if (board[row][col] == board[row - 1][col + 1]) count++;
    }
    return count == board.length - 1;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean hasPlayerWon(char[][] board) {
    return checkRows(board) || checkColumns(board) || checkMainDiagonal(board) || checkCounterDiagonal(board);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void play() {
    char[][] board = new char[GRID_SIZE][GRID_SIZE];
    int[] point;
    int playsCounter = 0;
    char player;
    
    try (Scanner scanner = new Scanner(System.in)) {
      for (char[] row : board) {
        Arrays.fill(row, ' ');
      }
      for (;;) {
        player = playsCounter % 2 == 0 ? 'X' : 'O';
        
        printBoard(board);
        point = readPoint(scanner, player);
        System.out.println();
        // ask the player to enter a point again if the cell is not free
        if (!isCellFee(board, point)) {
          System.out.println("The point entered is not free. Please try again.");
          continue;
        }
        board[point[0]][point[1]] = player;
        
        if (hasPlayerWon(board)) {
          printBoard(board);
          System.out.printf("Player '%c' won\n", player);
          break;
        }
        
        playsCounter++;
        if (playsCounter == GRID_SIZE * GRID_SIZE) {
          System.out.println("There is no winner.");
          break;
        }
      }
      System.out.printf("Game completed after '%d' plays\n", playsCounter);
    }
    catch (Exception e) {
      e.printStackTrace();
      System.err.println("Invalid input. Game stopped unexpectedly...");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
