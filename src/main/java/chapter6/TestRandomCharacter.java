package chapter6;

public class TestRandomCharacter {
  
  public static int NUMBER_OF_CHARS = 175;
  public static int NUMBER_OF_CHARS_PER_LINE = 25;
  
  public static void main(String[] args) {
    System.out.println("Test random lowercase letters");
    testGetRandomLowerCaseLetter();
    System.out.println();
    
    System.out.println("Test random uppercase letters");
    testGetRandomUpperCaseLetter();
    System.out.println();
    
    System.out.println("Test random digit characters");
    testGetRandomDigitCharacter();
    System.out.println();
    
    System.out.println("Test random characters");
    testGetRandomCharacter();
    System.out.println();
    
    System.out.println("Test random characters in the range [u, z]");
    testGetRandomCharacterFromRange();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void testGetRandomLowerCaseLetter() {
    for (int i = 0; i < NUMBER_OF_CHARS; i++) {
      if (i != 0 && i % NUMBER_OF_CHARS_PER_LINE == 0) System.out.println();
      
      System.out.print(RandomCharacter.getRandomLowerCaseLetter());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void testGetRandomUpperCaseLetter() {
    for (int i = 0; i < NUMBER_OF_CHARS; i++) {
      if (i != 0 && i % NUMBER_OF_CHARS_PER_LINE == 0) System.out.println();
      
      System.out.print(RandomCharacter.getRandomUpperCaseLetter());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void testGetRandomDigitCharacter() {
    for (int i = 0; i < NUMBER_OF_CHARS; i++) {
      if (i != 0 && i % NUMBER_OF_CHARS_PER_LINE == 0) System.out.println();
      
      System.out.print(RandomCharacter.getRandomDigitCharacter());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void testGetRandomCharacter() {
    for (int i = 0; i < NUMBER_OF_CHARS; i++) {
      if (i != 0 && i % NUMBER_OF_CHARS_PER_LINE == 0) System.out.println();
      
      System.out.print(RandomCharacter.getRandomCharacter());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void testGetRandomCharacterFromRange() {
    for (int i = 0; i < NUMBER_OF_CHARS; i++) {
      if (i != 0 && i % NUMBER_OF_CHARS_PER_LINE == 0) System.out.println();
      
      System.out.print(RandomCharacter.getRandomCharacter('u', 'z'));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
