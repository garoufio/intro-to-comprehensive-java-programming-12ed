package chapter6;

public class Exercise6_13 {
  
  public static final int STARTING_NUMBER = 1;
  public static final int ENDING_NUMBER = 20;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayTitle() {
    System.out.printf("%-10s%14s\n", "i", "m(i)");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayBody() {
    for (int i = STARTING_NUMBER; i <= ENDING_NUMBER; i++) {
      System.out.printf("%-10d%9.4f\n", i, computeSum(i));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeSum(int number) {
    double result = 0;
    
    for (int i = 1; i <= number; i++) {
      result += i / (i + 1.0);
    }
    
    return result;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    displayTitle();
    displayBody();
  }
  
}
