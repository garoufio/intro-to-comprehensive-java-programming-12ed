package chapter8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise8_25Test {
  
  @Test
  @DisplayName("Is Markov matrix")
  public void testIsMarkovMatrix() {
    double[][] matrix = {
        {0.15, 0.875, 0.375},
        {0.55, 0.005, 0.225},
        {0.3,  0.12,  0.4}
    };
    assertTrue(Exercise8_25.isMarkovMatrix(matrix));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Not a Markov matrix - negative element")
  public void testIsNotMarkovMatrixWithNegativeElement() {
    double[][] matrix = {
        {0.15, 0.875,  0.375},
        {0.55, -0.005, 0.225},
        {0.3,  0.12,   0.4}
    };
    assertFalse(Exercise8_25.isMarkovMatrix(matrix));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Not a Markov matrix - sum != 1")
  public void testIsNotMarkovMatrixWithSumNotOne() {
    double[][] matrix = {
        {0.15, 0.875, 0.375},
        {0.55, 0.005, 0.225},
        {0.63,  0.12,  0.4}
    };
    assertFalse(Exercise8_25.isMarkovMatrix(matrix));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
