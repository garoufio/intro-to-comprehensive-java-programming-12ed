package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter an unspecified number of scores and determines how many scores are above or equal to the
 * average, and how many scores are below the average. Enter a negative number to signify the end of the
 * input. Assume the maximum number of scores is 100.
 */
public class Exercise7_4 {
  
  public static final int MAX_NUMBER_OF_SCORES = 100;
  public static final int MAX_ARRAY_SIZE = 1000;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    int[] numbers = readIntegers(input);
    input.close();
    
    double avg = getAverage(numbers);
    System.out.printf(
        "There are '%d' numbers above or equal to the average '%.2f'\n",
        getAboveOrEqualAverageCount(numbers, avg), avg
    );
    System.out.printf("There are '%d' numbers below average '%.2f'\n", getBelowAverageCount(numbers, avg), avg);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void clearArray(int[] array) {
    Arrays.fill(array, 0);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] truncateArray(int[] array) {
    int count = 0;
    for (int val : array) {
      if (val == 0) break;
      
      count++;
    }
    
    return Arrays.copyOf(array, count);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidNumber(int number, int min, int max) {
    return number >= min && number <= max;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readIntegers(Scanner scanner) {
    int[] numbers = new int[MAX_ARRAY_SIZE];
    int number, index = 0;
    
    System.out.printf("Enter scores (negative number to end) in the range [0-%d]: ", MAX_NUMBER_OF_SCORES);
    for (;;) {
      number = scanner.nextInt();
      if (number < 0) {
        break;
      }
      
      if (!isValidNumber(number, 0, MAX_NUMBER_OF_SCORES)) {
        System.out.printf("Invalid number: %d\n", number);
        clearArray(numbers);
        index = 0;
      }
      else {
        numbers[index++] = number;
      }
      
      if (index == 0) break;
    }
    return truncateArray(numbers);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getAverage(int[] numbers) {
    double sum = 0;
    
    for (int number : numbers) {
      sum += number;
    }
    return sum / numbers.length;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getAboveOrEqualAverageCount(int[] numbers, double average) {
    int count = 0;
    
    for (int number : numbers) {
      if ((double)number >= average) count++;
    }
    return count;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getBelowAverageCount(int[] numbers, double average) {
    int count = 0;
    
    for (int number : numbers) {
      if ((double)number < average) count++;
    }
    return count;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
