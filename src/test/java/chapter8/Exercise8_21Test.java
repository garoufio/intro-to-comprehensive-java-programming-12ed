package chapter8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Exercise8_21Test {
  
  public double[][] cities;
  
  @BeforeAll
  public void setUp() {
    cities = new double[][] {
        { 2.5, 5 }, { 5.1, 3 }, { 1, 9 }, { 5.4, 54 }, { 5.5, 2.1 }
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Total distance of the first city")
  public void testTotalDistanceOfFirstCity() {
    assertEquals(60.81, Exercise8_21.getCitiesTotalDistance(cities)[0], 0.001);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Find min city distance index")
  public void testFindCentralCity() {
    double[] distances = Exercise8_21.getCitiesTotalDistance(cities);
    assertEquals(0, Exercise8_21.getMinCitiesDistance(distances));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
