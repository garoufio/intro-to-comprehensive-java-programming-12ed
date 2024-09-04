package chapter6;

/**
 * Estimates π for a given value.
 */
public class Exercise6_14 {
  
  public static final int STARTING_NUMBER = 1;
  public static final int ENDING_NUMBER   = 1000;
  public static final int STEP            = 100;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayTitle() {
    System.out.printf("%-10s%14s\n", "i", "m(i)");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayBody() {
    for (int i = STARTING_NUMBER; i <= ENDING_NUMBER; i += STEP) {
      System.out.printf("%-10d%9.4f\n", i, computeSum(i));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeSum(int number) {
    double result = 0;
    
    for (int i = 1; i <= number; i++) {
      result += Math.pow(-1, i + 1) / ((2 * i) - 1.0);
    }
    
    return 4.0 * result;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    displayTitle();
    displayBody();
  }
  
}
