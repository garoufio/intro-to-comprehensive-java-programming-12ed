package chapter5;

public class Exercise5_39 {
  
  public static final double BASE_SALARY = 5000;
  public static final double GOAL_SALARY = 30000;
  
  public static void main(String[] args) {
    double salesAmount = 0;
    double commission;
    
    while (true) {
      commission = 0;
      if (salesAmount >= 0.01 && salesAmount <= 5000) {
        commission += salesAmount * 0.08;
      }
      else if (salesAmount >= 5000.01 && salesAmount <= 10000) {
        commission += (salesAmount - 5000.0) * 0.1;
      }
      else {
        commission += (salesAmount - 10000.0) * 0.12;
      }
      salesAmount += 0.1;
      
      if (commission + BASE_SALARY >= GOAL_SALARY) break;
    }
    System.out.printf(
        "The minimum sales amount in order to make '$%.2f' is '$%.2f'\n",
        GOAL_SALARY, salesAmount
        );
  }

}
