package chapter8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise8_28Test {
  
  @Test
  @DisplayName("Arrays are strictly equal")
  public void testStrictlyEqualArrays() {
    int[][] m1 = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    int[][] m2 = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    
    assertTrue(Exercise8_28.strictlyEquals(m1, m2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Arrays differ on their content")
  public void testNotStrictlyEqualArrays1() {
    int[][] m1 = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    int[][] m2 = new int[][]{
        {4, 5, 6}, {11, 12, 13}, {7, 8, 9}
    };
    
    assertFalse(Exercise8_28.strictlyEquals(m1, m2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Arrays have the same content but differ on the corresponding elements")
  public void testNotStrictlyEqualArrays2() {
    int[][] m1 = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    int[][] m2 = new int[][]{
        {4, 5, 6}, {1, 2, 3}, {7, 8, 9}
    };
    
    assertFalse(Exercise8_28.strictlyEquals(m1, m2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
