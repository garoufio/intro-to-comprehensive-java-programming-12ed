package chapter7;

/**
 * Generates 100 random numbers between 0 and 9, and displays the count for each number.
 */
public class Exercise7_7 {
  
  public static final int MAX_NUMBERS_COUNT = 100;
  public static final int NUMBER_OF_SINGLE_DIGITS = 10;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int[] numbers = generateRandomNumbersArray(MAX_NUMBERS_COUNT, 0, 10);
    int[] counts = getCounts(numbers);
    
    displayCounts(counts);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int generateRandomNumber(int min, int max) {
    return (int)(Math.random() * (max - min) + min);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] generateRandomNumbersArray(int size, int min, int max) {
    int[] numbers = new int[size];
    
    for (int i = 0; i < size; i++) {
      numbers[i] = generateRandomNumber(min, max);
    }
    return numbers;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getCounts(int[] numbers) {
    int[] counts = new int[NUMBER_OF_SINGLE_DIGITS];
    
    for (int n : numbers) {
      counts[n]++;
    }
    return counts;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void displayCounts(int[] counts) {
    for (int i = 0; i < counts.length; i++) {
      System.out.printf("%d: occurs %d times\n", i, counts[i]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
