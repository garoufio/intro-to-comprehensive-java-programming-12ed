package chapter8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise8_29Test {
  
  @Test
  @DisplayName("Arrays are strictly identical")
  public void testStrictlyIdenticalArrays() {
    int[][] m1 = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    int[][] m2 = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    assertTrue(Exercise8_29.equals(m1, m2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Arrays are identical")
  public void testIdenticalArrays() {
    int[][] m1 = new int[][]{
        {4, 5, 6}, {9, 8, 1}, {7, 2, 3}
    };
    int[][] m2 = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    assertTrue(Exercise8_29.equals(m1, m2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Arrays are not identical")
  public void testNotIdenticalArrays() {
    int[][] m1 = new int[][]{
        {1, 2, 3}, {24, 5, 6}, {7, 8, 9}
    };
    int[][] m2 = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    assertFalse(Exercise8_29.equals(m1, m2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
