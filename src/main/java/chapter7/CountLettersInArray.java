package chapter7;

public class CountLettersInArray {
  
  public static final int NUMBER_OF_CHARS = 100;
  public static final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
  
  //------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    char[] chars = createRandomCharacters(NUMBER_OF_CHARS, true);
    int[] countChars = getCharsCount(chars, true);
    
    displayChars(chars, true);
    System.out.println();
    displayCharsCount(countChars, true);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static char[] createRandomCharacters(int numberOfChars, boolean isLowerCase) {
    char[] chars = new char[numberOfChars];
    char lowerBound = isLowerCase ? 'a' : 'A';
    char upperBound = isLowerCase ? 'z' : 'Z';
    
    for (int i = 0; i < numberOfChars; i++) {
      chars[i] = (char)(lowerBound + (Math.random() * (upperBound - lowerBound + 1)));
    }
    
    return chars;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getCharsCount(char[] chars, boolean isLowerCase) {
    int[] counts = new int[NUMBER_OF_LETTERS_IN_ALPHABET];
    char lowerBound = isLowerCase ? 'a' : 'A';
    
    for (char ch : chars) {
      counts[ch - lowerBound]++;
    }
    
    return counts;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayChars(char[] chars, boolean isLowerCase) {
    System.out.printf("The %s letters are:\n", isLowerCase ? "lowercase" : "uppercase");
    
    for (int i = 0; i < chars.length; i++) {
      System.out.print(chars[i]);
      if ((i + 1) % 20 == 0) {
        System.out.println();
      }
      else {
        System.out.print(" ");
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayCharsCount(int[] counts, boolean isLowerCase) {
    char lowerBound = isLowerCase ? 'a' : 'A';
    char upperBound = isLowerCase ? 'z' : 'Z';
    
    System.out.println("The occurrences of each letter are:");
    for (char ch = lowerBound; ch <= upperBound; ch++) {
      System.out.printf("%c: %d\n", ch, counts[ch - lowerBound]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
