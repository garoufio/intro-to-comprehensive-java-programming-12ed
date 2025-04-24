package chapter8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Exercise8_17Test {
  
  private double minSafeAmount;
  private double[][] data;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeAll
  public void init() {
    minSafeAmount = 201.0;
    data = new double[][] {
      { 25,   2,  1,  100.5,   4,  320.5 },
      { 125,  2,  2,  40,      3,  85    },
      { 175,  2,  0,  125,     3,  75    },
      { 75,   1,  0,  125                },
      { 181,  1,  2,  125                }
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Find the Lender-Borrowers relations")
  public void testBorrowers() {
    int[][] borrowersExpected = new int[][]{
        { 0, 1 },
        { 0, 4 },
        { 1, 2 },
        { 1, 3 },
        { 2, 0 },
        { 2, 3 },
        { 3, 0 },
        { 4, 2 }
    };
    int[][] borrowersActual = Exercise8_17.createBorrowers(data);
    for (int i = 0; i < borrowersActual.length; i++) {
      assertArrayEquals(borrowersExpected[i], borrowersActual[i], () -> "Not equal arrays");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Banks' total assets")
  public void testTotalAssets() {
    double[] assetsExpected = new double[] { 446, 250, 375, 200, 306 };
    double[] assetsActual = Exercise8_17.computeTotalAssets(data);
    
    assertArrayEquals(assetsExpected, assetsActual, () -> "Assets are not equal");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Unsafe banks")
  public void testUnsafeBanks() {
    int[] unsafeBanksExpected = new int[]{ 1, 3 , -1, -1, -1};
    int[] unsafeBanksActual = Exercise8_17.findUnsafeBanks(data, minSafeAmount);
    
    System.out.println(Arrays.toString(unsafeBanksActual));
    
    assertArrayEquals(unsafeBanksExpected, unsafeBanksActual, () -> "List of unsafe banks is different");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
