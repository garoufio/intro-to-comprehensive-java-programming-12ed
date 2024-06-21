package chapter5;

/**
 * Computes the future tuition in 10 years and the total cost of tuition fees of four years' worth of tuition fees
 * starting after the tenth year.
 */
public class Exercise5_7 {
  
  public static final double ANNUAL_INCREASE = 0.05;
  public static final double STARTING_TUITION_FEE = 10_000;
  
  public static void main(String[] args) {
    double tuitionFee = STARTING_TUITION_FEE;
    
    for (int i = 1; i <= 10; i++) {
      tuitionFee += tuitionFee * ANNUAL_INCREASE;
    }
    System.out.printf("The tuition fee after 10 years will be '$%.2f'\n", tuitionFee);
    
    double totalCost = tuitionFee;
    for (int i = 0; i < 4; i++) {
      tuitionFee += tuitionFee * ANNUAL_INCREASE;
      totalCost += tuitionFee;
    }
    System.out.printf("The total cost of four years' worth of tuition after the tenth year is '$%.2f'\n", totalCost);
  }
  
}
