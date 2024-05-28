package chapter3;

public class Exercise3_4 {
  
  public static void main(String[] args) {
    // Math.random() * (max - min + 1) + min: generates a random number in the range [min , max], max is included
    int randomNumber = (int)(Math.random() * (12 - 1 + 1) + 1);
    
    switch (randomNumber) {
      case 1: System.out.printf("January (%d)\n", randomNumber); break;
      case 2: System.out.printf("February (%d)\n", randomNumber); break;
      case 3: System.out.printf("March (%d)\n", randomNumber); break;
      case 4: System.out.printf("April (%d)\n", randomNumber); break;
      case 5: System.out.printf("May (%d)\n", randomNumber); break;
      case 6: System.out.printf("June (%d)\n", randomNumber); break;
      case 7: System.out.printf("July (%d)\n", randomNumber); break;
      case 8: System.out.printf("August (%d)\n", randomNumber); break;
      case 9: System.out.printf("September (%d)\n", randomNumber); break;
      case 10: System.out.printf("October (%d)\n", randomNumber); break;
      case 11: System.out.printf("November (%d)\n", randomNumber); break;
      case 12: System.out.printf("December (%d)\n", randomNumber); break;
      default: System.out.printf("Month cannot be computed.");
    }
  }
  
}
