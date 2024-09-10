package chapter6;

/**
 * Displays 100 random characters and 100 random single digits.
 */
public class Exercise6_38 {
  
  public static final int MAX_NUMBERS_PER_LINE    = 50;
  public static final int MAX_NUMBERS_TO_PRINT    = 100;
  public static final int MAX_CHARACTERS_PER_LINE = 50;
  public static final int MAX_CHARACTERS_TO_PRINT = 100;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getRandomNumber(int min, int max) {
    return (int)(Math.random() * (max - min + 1)) + min;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printRandomCharacters() {
    for (int i = 1; i <= MAX_CHARACTERS_TO_PRINT; i++) {
      System.out.print(RandomCharacter.getRandomCharacter('A', 'Z')); // from listing RandomCharacter
      
      if (i % MAX_CHARACTERS_PER_LINE == 0) System.out.println();
      else System.out.print(" ");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printRandomNumbers() {
    for (int i = 1; i <= MAX_NUMBERS_TO_PRINT; i++) {
      System.out.print(getRandomNumber(0, 9));
      
      if (i % MAX_NUMBERS_PER_LINE == 0) System.out.println();
      else System.out.print(" ");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    printRandomCharacters();
    printRandomNumbers();
  }
  
}
