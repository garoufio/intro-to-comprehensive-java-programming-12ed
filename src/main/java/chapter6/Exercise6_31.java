package chapter6;

import java.util.Scanner;

/**
 * Credit card validation using the Luhn check (Mod10 check).
 */
public class Exercise6_31 {
  
  public static final int MAX_CARD_NUMBER_LENGTH          = 16;
  public static final int Min_CARD_NUMBER_LENGTH          = 13;
  public static final int STARTING_DIGIT_VISA             = 4;
  public static final int STARTING_DIGIT_MASTERCARD       = 5;
  public static final int STARTING_DIGIT_AMERICAN_EXPRESS = 37;
  public static final int STARTING_DIGIT_DISCOVER         = 6;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Return true if input is valid. */
  public static boolean isInputValid(String cardNumber) {
    int len = cardNumber.length();
    
    if (len < Min_CARD_NUMBER_LENGTH || len > MAX_CARD_NUMBER_LENGTH) return false;
    
    for (char c : cardNumber.toCharArray()) {
      if (!Character.isDigit(c)) return false;
    }
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Return true if the card number is valid after validation using the algorithm. */
  public static boolean isValid(long number) {
    return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Get the result from Step 2 */
  public static int sumOfDoubleEvenPlace(long number) {
    int sum = 0;
    String cardNumber = String.valueOf(number);
    
    for (int i = cardNumber.length() - 2; i >= 0; i -= 2) {
      sum += getDigit(2 * (cardNumber.charAt(i) - '0'));
    }
    
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Return this number if it is a single digit, otherwise return the sum of the two digits. */
  public static int getDigit(int number) {
    if (number >= 0 && number <= 9) {
      return number;
    }
    else {
      return (number % 10) + (number / 10);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Return sum of odd place digits in number. */
  public static int sumOfOddPlace(long number) {
    int sum = 0;
    String cardNumber = String.valueOf(number);
    
    for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
      sum += getDigit(cardNumber.charAt(i) - '0');
    }
    
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Return true if the number d is a prefix for number. */
  public static boolean prefixMatched(long number, int d) {
    return (int)getPrefix(number, getSize(d)) == d;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Return the number of digits in d. */
  public static int getSize(long d) {
    return String.valueOf(d).length();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Return the first k number of digits from number. If the number of digits is less than k, return number. */
  public static long getPrefix(long number, int k) {
    String cardNumber = String.valueOf(number);
    
    return cardNumber.length() < k ? number : Long.parseLong(cardNumber.substring(0, k));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String getCardNumber(Scanner scanner) {
    System.out.print("Enter card number (13-16 digits): ");
    String cardNumber = scanner.nextLine();
    
    return isInputValid(cardNumber) ? cardNumber : null;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String cardNumber = getCardNumber(input);
    input.close();
    
    if (cardNumber != null) {
      long number = Long.parseLong(cardNumber);
      boolean checkMod10 = isValid(number);
      boolean checkStartingDigits = prefixMatched(number, STARTING_DIGIT_VISA) ||
          prefixMatched(number, STARTING_DIGIT_MASTERCARD) ||
          prefixMatched(number, STARTING_DIGIT_AMERICAN_EXPRESS) ||
          prefixMatched(number, STARTING_DIGIT_DISCOVER);
      
      if (checkMod10 && checkStartingDigits) {
        System.out.printf("'%s' is valid\n", cardNumber);
      }
      else {
        System.out.printf("'%s' is invalid\n", cardNumber);
      }
    }
    else {
      System.out.println("Invalid card number entered.");
    }
  }

}
