package chapter6;

/**
 * Displays a tax table for taxable income from $50000 to $60000 with intervals of $50.
 */
public class Exercise6_15 {
  
  public static final int STARTING_INCOME = 50000;
  public static final int ENDING_INCOME   = 60000;
  public static final int INTERVAL        = 50;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayTitle() {
    System.out.printf("%-20s%-12s%-40s%-20s%-20s\n",
        "Taxable Income",
        "Single",
        "Married Joint or Qualifying Widow(er)",
        "Married Separate",
        "Head of House hold"
        );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayBody() {
    for (int i = STARTING_INCOME; i <= ENDING_INCOME; i += INTERVAL) {
      System.out.printf("%-20d%-12d%-40d%-20d%-20d\n",
          i,
          computeTax(i, FilingStatus.SINGLE),
          computeTax(i, FilingStatus.MARRIED_JOINT_OR_QUALIFIED_WIDOW_ER),
          computeTax(i, FilingStatus.MARRIED_SEPARATE),
          computeTax(i, FilingStatus.HEAD_OF_HOUSEHOLD)
      );
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeTaxForSingle(int income) {
    double tax = 0;
    
    if (income <= 8350) {
      tax = income * 0.10;
    }
    else if (income <= 33950) {
      tax = (8350 * 0.10) + ((income - 8350) * 0.15);
    }
    else if (income <= 82250) {
      tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((income - 33950) * 0.25);
    }
    else if (income <= 171550) {
      tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((82250 - 33950) * 0.25) + ((income - 82250) * 0.28);
    }
    else if (income <= 372950) {
      tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((82250 - 33950) * 0.25) + ((171550 - 82250) * 0.28) +
          ((income - 171550) * 0.33);
    }
    else {
      tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((82250 - 33950) * 0.25) + ((171550 - 82250) * 0.28) +
          ((372950 - 171550) * 0.33) + ((income - 372950) * 0.35);
    }
    
    return tax;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeTaxForMarriedJointOrWidowEr(int income) {
    double tax = 0;
    
    if (income <= 16700) {
      tax = income * 0.10;
    }
    else if (income <= 67900) {
      tax = (16700 * 0.10) + ((income - 16700) * 0.15);
    }
    else if (income <= 137050) {
      tax = (16700 * 0.10) + ((67900 - 16700) * 0.15) + ((income - 67900) * 0.25);
    }
    else if (income <= 208850) {
      tax = (16700 * 0.10) + ((67900 - 16700) * 0.15) + ((137050 - 67900) * 0.25) + ((income - 137050) * 0.28);
    }
    else if (income <= 372950) {
      tax = (16700 * 0.10) + ((67900 - 16700) * 0.15) + ((137050 - 67900) * 0.25) + ((208850 - 137050) * 0.28) +
          ((income - 208850) * 0.33);
    }
    else {
      tax = (16700 * 0.10) + ((67900 - 16700) * 0.15) + ((137050 - 67900) * 0.25) + ((208850 - 137050) * 0.28) +
          ((372950 - 208850) * 0.33) + ((income - 372950) * 0.35);
    }
    
    return tax;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeTaxForMarriedSeparate(int income) {
    double tax = 0;
    
    if (income <= 8350) {
      tax = income * 0.10;
    }
    else if (income <= 33950) {
      tax = (8350 * 0.10) + ((income - 8350) * 0.15);
    }
    else if (income <= 68525) {
      tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((income - 33950) * 0.25);
    }
    else if (income <= 104425) {
      tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((68525 - 33950) * 0.25) + ((income - 68525) * 0.28);
    }
    else if (income <= 186475) {
      tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((68525 - 33950) * 0.25) + ((104425 - 68525) * 0.28) +
          ((income - 104425) * 0.33);
    }
    else {
      tax = (8350 * 0.10) + ((33950 - 8350) * 0.15) + ((68525 - 33950) * 0.25) + ((104425 - 68525) * 0.28) +
          ((186475 - 104425) * 0.33) + ((income - 186475) * 0.35);
    }
    
    return tax;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeTaxForHeadOfHousehold(int income) {
    double tax;
    
    if (income <= 11950) {
      tax = income * 0.10;
    }
    else if (income <= 45500) {
      tax = (11950 * 0.10) + ((income - 11950) * 0.15);
    }
    else if (income <= 117450) {
      tax = (11950 * 0.10) + ((45500 - 11950) * 0.15) + ((income - 45500) * 0.25);
    }
    else if (income <= 190200) {
      tax = (11950 * 0.10) + ((45500 - 11950) * 0.15) + ((117450 - 45500) * 0.25) + ((income - 117450) * 0.28);
    }
    else if (income <= 372950) {
      tax = (11950 * 0.10) + ((45500 - 11950) * 0.15) + ((117450 - 45500) * 0.25) + ((190200 - 117450) * 0.28) +
          ((income - 190200) * 0.33);
    }
    else {
      tax = (11950 * 0.10) + ((45500 - 11950) * 0.15) + ((117450 - 33950) * 0.25) + ((190200 - 117450) * 0.28) +
          ((372950 - 190200) * 0.33) + ((income - 372950) * 0.35);
    }
    
    return tax;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static long computeTax(int income, FilingStatus status) {
    
    return switch (status) {
      case SINGLE -> Math.round(computeTaxForSingle(income));
      case MARRIED_JOINT_OR_QUALIFIED_WIDOW_ER -> Math.round(computeTaxForMarriedJointOrWidowEr(income));
      case MARRIED_SEPARATE -> Math.round(computeTaxForMarriedSeparate(income));
      case HEAD_OF_HOUSEHOLD -> Math.round(computeTaxForHeadOfHousehold(income));
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    displayTitle();
    displayBody();
  }
  
}
