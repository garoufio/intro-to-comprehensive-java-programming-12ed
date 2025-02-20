package chapter8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class Exercise8_19Test {
  
  @Test
  @DisplayName("Consecutive 4 found in a row of a 2x6 array")
  public void testConsecutive4_2DArray1() {
    int[][] array = {
        {4, 5, 6, 7, 8, 9},
        {2, 1, 1, 1, 1, 3}
    };
    
    Executable checkRows = () -> assertTrue(
        Exercise8_19.checkRows(array),
        "No consecutive 4 numbers found in any row of the 2D array"
    );
    Executable checkColumns = () -> assertFalse(
        Exercise8_19.checkColumns(array),
        "Consecutive 4 numbers found in some column of the 2D array"
    );
    assertAll(checkRows, checkColumns);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("No consecutive 4 found in a 2x6 array")
  public void testConsecutive4_2DArray2() {
    int[][] array = {
        {4, 5, 6, 7, 8, 9},
        {2, 1, 2, 1, 1, 3}
    };
    
    Executable checkRows = () -> assertFalse(
          Exercise8_19.checkRows(array),
          "Consecutive 4 numbers found in some row of the 2D array"
      );
    Executable checkColumns = () -> assertFalse(
          Exercise8_19.checkColumns(array),
          "Consecutive 4 numbers found in some column of the 2D array"
      );
    assertAll(checkRows, checkColumns);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("No consecutive 4 found in a 5x6 array")
  public void testConsecutive4_2DArray3() {
    int[][] array = new int[][] {
          {4, 5, 6, 7, 8, 9},
          {2, 1, 2, 1, 1, 3},
          {4, 5, 1, 6, 8, 9},
          {3, 5, 9, 7, 4, 3},
          {2, 5, 6, 2, 8, 9}
      };
    Executable checkRows = () -> assertFalse(
          Exercise8_19.checkRows(array),
          "Consecutive 4 numbers found in some row of the 2D array"
      );
    Executable checkColumns = () -> assertFalse(
          Exercise8_19.checkColumns(array),
          "Consecutive 4 numbers found in some column of the 2D array"
      );
    assertAll(checkRows, checkColumns);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Consecutive 4 found in a row and a column of a 5x6 array")
  public void testConsecutive4_2DArray4() {
    int[][] array = new int[][] {
          {4, 7, 6, 7, 8, 9},
          {2, 5, 2, 1, 1, 3},
          {4, 5, 1, 6, 8, 9},
          {3, 5, 7, 7, 7, 7},
          {2, 5, 6, 8, 8, 8}
    };
    Executable checkRows = () -> assertTrue(
          Exercise8_19.checkRows(array),
          "No consecutive 4 numbers found in any row of the 2D array"
      );
    Executable checkColumns = () -> assertTrue(
          Exercise8_19.checkColumns(array),
          "No consecutive 4 numbers found in any column of the 2D array"
      );
    assertAll(checkRows, checkColumns);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Consecutive 4 found in a left diagonal of a 5x6 array")
  public void testConsecutive4_2DArray5() {
    int[][] array = new int[][] {
          {4, 7, 4, 7, 8, 9},
          {2, 3, 2, 6, 9, 3},
          {4, 5, 8, 9, 1, 9},
          {3, 5, 9, 8, 4, 2},
          {2, 5, 6, 2, 8, 9}
    };
    assertTrue(Exercise8_19.checkDiagonals(array), "No consecutive 4 numbers found in any diagonals");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Consecutive 4 found in a left diagonal of a 8x8 array")
  public void testConsecutive4_2DArray6() {
    int[][] array = new int[][] {
          {4, 7, 6, 1, 1, 9, 6, 7},
          {2, 5, 1, 2, 7, 3, 2, 9},
          {4, 1, 1, 7, 3, 9, 1, 4},
          {0, 1, 7, 3, 4, 3, 5, 6},
          {2, 7, 1, 4, 8, 9, 7, 0},
          {9, 5, 4, 2, 8, 1, 1, 2},
          {2, 2, 3, 2, 3, 1, 1, 8},
          {2, 5, 3, 2, 1, 9, 8, 1}
    };
    assertTrue(Exercise8_19.checkDiagonals(array), "No consecutive 4 numbers found in any diagonals");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("No Consecutive 4 found in any diagonal of a 8x8 array")
  public void testConsecutive4_2DArray7() {
    int[][] array = new int[][] {
          {4, 7, 6, 1, 1, 9, 6, 7},
          {2, 5, 1, 2, 7, 3, 2, 9},
          {4, 1, 1, 7, 3, 9, 1, 4},
          {0, 1, 7, 3, 4, 3, 5, 6},
          {2, 9, 1, 4, 8, 9, 7, 0},
          {9, 5, 4, 2, 8, 1, 1, 2},
          {2, 2, 3, 2, 3, 1, 1, 8},
          {2, 5, 3, 2, 1, 9, 8, 1}
    };
    assertFalse(Exercise8_19.checkDiagonals(array), "Consecutive 4 numbers found in some diagonals");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Consecutive 4 found in a left diagonal of a 5x6 array")
  public void testConsecutive4_2DArray8() {
    int[][] array = new int[][] {
          {4, 7, 4, 0, 8, 1},
          {2, 3, 0, 6, 9, 3},
          {4, 0, 8, 9, 1, 9},
          {0, 5, 9, 8, 4, 2},
          {2, 0, 6, 2, 8, 9}
    };
    assertTrue(Exercise8_19.checkDiagonals(array), "No consecutive 4 numbers found in any diagonals");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Consecutive 4 found in a 5x6 array")
  public void testConsecutive4_2DArray9() {
    int[][] array = new int[][] {
        {4, 7, 4, 0, 8, 1},
        {2, 3, 0, 6, 9, 3},
        {4, 0, 8, 9, 1, 9},
        {0, 5, 9, 8, 4, 2},
        {2, 0, 6, 2, 8, 9}
    };
    assertTrue(Exercise8_19.isConsecutiveFour(array), "No consecutive 4 numbers found in the array");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("No consecutive 4 found in a 8x8 array")
  public void testConsecutive4_2DArray10() {
    int[][] array = new int[][] {
        {4, 7, 6, 1, 1, 9, 6, 7},
        {2, 5, 1, 2, 7, 3, 2, 9},
        {4, 1, 1, 7, 3, 9, 1, 4},
        {0, 1, 7, 3, 4, 3, 5, 6},
        {2, 9, 1, 4, 8, 9, 7, 0},
        {9, 5, 4, 2, 8, 1, 1, 2},
        {2, 2, 3, 2, 3, 1, 1, 8},
        {2, 5, 3, 2, 1, 9, 8, 1}
    };
    assertFalse(Exercise8_19.isConsecutiveFour(array), "Consecutive 4 numbers found in the array");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Consecutive 4 found in a 8x8 array")
  public void testConsecutive4_2DArray11() {
    int[][] array = new int[][] {
        {4, 7, 6, 1, 1, 9, 6, 7},
        {2, 5, 1, 2, 7, 3, 2, 9},
        {4, 1, 1, 1, 1, 9, 1, 4},
        {0, 1, 7, 3, 4, 3, 5, 6},
        {2, 9, 1, 4, 8, 9, 7, 0},
        {9, 2, 4, 2, 8, 1, 1, 2},
        {2, 2, 2, 2, 3, 1, 1, 8},
        {2, 5, 3, 2, 1, 9, 8, 1}
    };
    assertTrue(Exercise8_19.isConsecutiveFour(array), "No consecutive 4 numbers found in the array");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
