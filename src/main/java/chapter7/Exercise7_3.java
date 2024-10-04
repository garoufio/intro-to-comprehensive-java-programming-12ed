package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter integers between 1 and 100 and counts the occurrences of each number.
 */
public class Exercise7_3 {
  
  public static final int TOTAL_NUMBERS = 100;
  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 100;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] numbers = readIntegers(input);
    input.close();
    
    Arrays.sort(numbers);
    int[] distinctNumbers = getDistinctNumbers(numbers);
    int[] occurrences = getOccurrences(numbers, distinctNumbers);
    printNumberOccurrences(distinctNumbers, occurrences);
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
  
  public static boolean isNumberValid(int number, int min, int max) {
    return number >= min && number <= max;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readIntegers(Scanner scanner) {
    int[] numbers = new int[TOTAL_NUMBERS];
    int number;
    boolean isValid = false;
    
    do {
      System.out.printf("Enter integer values (max numbers - %d) in the range [1, 100], 0 to end: ", TOTAL_NUMBERS);
      for (int i = 0; i < numbers.length; i++) {
        number = scanner.nextInt();
        
        if (number == 0) {
          isValid = true;
          break;
        }
        
        if (isNumberValid(number, MIN_NUMBER, MAX_NUMBER)) {
          numbers[i] = number;
          isValid = true;
        }
        else {
          System.out.printf("Invalid number '%d'\n", number);
          clearArray(numbers);
        }
      }
    } while (!isValid);
    
    return truncateArray(numbers);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getDistinctNumbers(int[] array) {
    int[] distinctNumbers = new int[array.length];
    int distinctIndex = 0;
    
    if (array.length > 0) {
      distinctNumbers[distinctIndex] = array[0];
      
      for (int i = 1; i < array.length; i++) {
        if (distinctNumbers[distinctIndex] == array[i]) continue;
        
        distinctNumbers[++distinctIndex] = array[i];
      }
    }
    
    return truncateArray(distinctNumbers);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getOccurrences(int[] array, int[] distinctNumbers) {
    int[] occurrences = new int[distinctNumbers.length];
    
    for (int i = 0; i < distinctNumbers.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (distinctNumbers[i] == array[j]) occurrences[i]++;
      }
    }
    
    return occurrences;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printNumberOccurrences(int[] distinctNumbers, int[] occurrences) {
    System.out.printf("The number of distinct numbers is '%d'\n", distinctNumbers.length);
    System.out.println("The distinct numbers are:");
    for (int i = 0; i < distinctNumbers.length; i++) {
      System.out.printf("%d: %d\n", distinctNumbers[i], occurrences[i]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
