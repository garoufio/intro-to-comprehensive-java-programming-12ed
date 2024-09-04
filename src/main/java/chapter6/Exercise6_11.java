package chapter6;

/**
 * Computes and displays the commission using the scheme in Exercise5_39 from a starting to and ending sales amount.
 */
public class Exercise6_11 {
  
  public static final int STARTING_SALES_AMOUNT  = 10000;
  public static final int ENDING_SALES_AMOUNT    = 100000;
  public static final int STEP_AMOUNT            = 5000;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayTitle() {
    System.out.printf("%-15s%15s\n", "Sales Amount", "Commission");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayBody() {
    for (int amount = STARTING_SALES_AMOUNT; amount <= ENDING_SALES_AMOUNT; amount += STEP_AMOUNT) {
      System.out.printf("%-15d%13.2f\n", amount, computeCommission(amount));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeCommission(int salesAmount) {
    double commission = 0.0;
    
    if (salesAmount >= 0.01 && salesAmount <= 5000) {
      commission = salesAmount * 0.08;
    }
    else if (salesAmount > 5000 && salesAmount <= 10000) {
      commission = 5000 * 0.08 + ((salesAmount - 5000) * 0.1);
    }
    else {
      commission = 5000 * 0.08 + 5000 * 0.1 + (salesAmount - 10000) * 0.12;
    }
    
    return commission;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    displayTitle();
    displayBody();
  }

}
