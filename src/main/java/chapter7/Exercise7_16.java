package chapter7;

import java.util.Arrays;

/**
 * Computes the execution time of the linear search and the binary search algorithms.
 */
public class Exercise7_16 {
  
  public static final int MAX_NUMBERS = 100000;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int[] array = createRandomArray(MAX_NUMBERS, 1, 100);
    int key = createRandomValue(1, 100);
    
    long executionTime = getLinearSearchExecutionTime(array, key);
    System.out.printf("The execution time of linear search is: %f seconds\n", executionTime / (Math.pow(10, 9)));
    executionTime = getBinarySearchExecutionTime(array, key);
    System.out.printf("The execution time of binary search is: %f seconds\n", executionTime / (Math.pow(10, 9)));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static long getLinearSearchExecutionTime(int[] array, int key) {
    long startTime = System.nanoTime();
    ArraySearch.linearSearch(array, key);
    long endTime = System.nanoTime();
    return endTime - startTime;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static long getBinarySearchExecutionTime(int[] array, int key) {
    int[] sortedArray = Arrays.copyOf(array, array.length);
    Arrays.sort(sortedArray);
    
    long startTime = System.nanoTime();
    ArraySearch.binarySearch(sortedArray, key);
    long endTime = System.nanoTime();
    return endTime - startTime;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] createRandomArray(int size, int min, int max) {
    int[] array = new int[size];
    
    for (int i = 0; i < array.length; i++) {
      array[i] = createRandomValue(min, max);
    }
    
    return array;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int createRandomValue(int min, int max) {
    return (int)(Math.random() * (max - min + 1)) + min;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
