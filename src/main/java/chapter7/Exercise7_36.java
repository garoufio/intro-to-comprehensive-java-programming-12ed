package chapter7;

import java.util.Arrays;

/**
 * (Game: Eight Queens) The classic Eight Queens puzzle is to place eight queens on a chessboard such that no two queens
 * can attack each other (i.e., no two queens are on the same row, same column, or same diagonal). The program displays
 * one such solution.
 */
public class Exercise7_36 {
  
  public static final int CHESS_BOARD_SIZE = 8;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int[] queens = new int[CHESS_BOARD_SIZE];
    Arrays.fill(queens, -1);
    
    play(queens);
    printSolution(queens);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidPosition(int[] queens, int position, int currentIndex) {
    if (currentIndex == 0) return true;
    
    int previousIndex = currentIndex - 1;
    int step = 1;
    for (int i = previousIndex; i >= 0; i--) {
      // same column validity check
      if (position == queens[i]) return false;
      
      // same diagonal validity check
      int value = queens[i] - step;
      if (value < 0) value = 0;
      if (position == value) return false;
      value = queens[i] + step;
      if (value > queens.length) value = queens.length - 1;
      if (position == value) return false;
      step++;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int createRandomNumber(int min, int max) {
    return (int)(Math.random() * (max - min) + min);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void play(int[] queens) {
    int position;
    
    for (int i = 0; i < queens.length; i++) {
      do {
        position = createRandomNumber(0, queens.length); // queens.length is excluded
      } while (!isValidPosition(queens, position, i));
      queens[i] = position;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printSolution(int[] queens) {
    for (int i = 0; i < queens.length; i++) {
      System.out.print("|");
      for (int j = 0; j < queens.length; j++) {
        System.out.printf("%s|", queens[i] == j ? "Q" : " ");
      }
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
