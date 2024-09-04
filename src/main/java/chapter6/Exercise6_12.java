package chapter6;

/**
 * Displays characters from 1 to Z with a specified number of characters per line.
 */
public class Exercise6_12 {
  
  public static final char STARTING_CHARACTER = '1';
  public static final char ENDING_CHARACTER   = 'Z';
  public static final int CHARACTERS_PER_LINE = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printChars(char ch1, char ch2, int numberPerLine) {
    int count = 0;
    for (char ch = ch1; ch <= ch2; ch++) {
      System.out.print(ch);
      count++;
      
      if (count % numberPerLine == 0) System.out.println();
      else System.out.print(" ");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    printChars(STARTING_CHARACTER, ENDING_CHARACTER, CHARACTERS_PER_LINE);
  }
  
}
