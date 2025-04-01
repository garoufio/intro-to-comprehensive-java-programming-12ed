package chapter8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Exercise8_35Test {
  
  public int[][] matrix2, matrix3, matrix4, matrix5, matrix;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeAll
  public void init() {
    matrix = new int[][] {
        { 1, 0, 1, 0, 1 },
        { 1, 1, 1, 1, 1 },
        { 0, 0, 1, 0, 0 },
        { 1, 0, 1, 0, 1 },
        { 1, 0, 1, 0, 1 }
    };
    matrix2 = new int[][] {
        { 1, 0, 1, 0, 1 },
        { 1, 1, 1, 1, 1 },
        { 0, 0, 1, 1, 0 },
        { 1, 0, 1, 0, 1 },
        { 1, 0, 1, 0, 1 }
    };
    matrix3 = new int[][] {
        { 1, 0, 1, 0, 1 },
        { 1, 1, 1, 0, 1 },
        { 1, 0, 1, 1, 1 },
        { 1, 0, 1, 1, 1 },
        { 1, 0, 1, 1, 1 }
    };
    matrix4 = new int[][] {
        { 1, 0, 1, 0, 1 },
        { 1, 1, 1, 1, 1 },
        { 0, 1, 1, 1, 1 },
        { 0, 1, 1, 1, 1 },
        { 0, 1, 1, 1, 1 }
    };
    matrix5 = new int[][] {
        { 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1 }
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("5x5 square block of 1s found")
  public void testLargestBlock5x5() {
    int[] block = Exercise8_35.findLargestBLock(matrix5);
    assertArrayEquals(new int[] { 0, 0, 5}, block);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("4x4 square block of 1s found")
  public void testLargestBlock4x4() {
    int[] block = Exercise8_35.findLargestBLock(matrix4);
    assertArrayEquals(new int[] { 1, 1, 4 }, block);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("3x3 square block of 1s found")
  public void testLargestBlock3x3() {
    int[] block = Exercise8_35.findLargestBLock(matrix3);
    assertArrayEquals(new int[] { 2, 2, 3 }, block);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("2x2 square block of 1s found")
  public void testLargestBlock2x2() {
    int[] block = Exercise8_35.findLargestBLock(matrix2);
    assertArrayEquals(new int[] { 1, 2, 2 }, block);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("No square block of 1s found")
  public void testLargestBlockNone() {
    int[] block = Exercise8_35.findLargestBLock(matrix);
    assertArrayEquals(new int[] { 0, 0, 0 }, block);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
