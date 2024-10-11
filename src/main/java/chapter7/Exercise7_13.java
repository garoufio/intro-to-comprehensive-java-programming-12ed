package chapter7;

/**
 * Returns a random number between 'start' and 'end' excluding a list of numbers.
 */
public class Exercise7_13 {
  
  public static final int ITERATIONS = 45;
  public static final int START = 1;
  public static final int END = 100;
  public static final int[] NUMBERS_EXCLUDED = { 4, 8, 93, 95 };
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    for (int i = 0; i < ITERATIONS; i++) {
      System.out.printf("%4d\n", getRandom(START, END, NUMBERS_EXCLUDED));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getRandom(int start, int end, int... numbers) {
    int randomNumber;
    
    if (numbers == null || numbers.length == 0) {
      randomNumber =  (int)(Math.random() * (end - start + 1) + start); // END is inclusive
    }
    else {
      do {
        randomNumber = (int)(Math.random() * (end - start + 1) + start); // END is inclusive
      } while (contains(randomNumber, numbers));
    }
    return randomNumber;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean contains(int number, int... array) {
    boolean result = false;
    
    if (array == null || array.length == 0) return result;
    
    for (int n : array) {
      if (n == number) return true;
    }
    
    return result;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
