package chapter7;

import java.util.Arrays;

/**
 * The selection-sort method repeatedly finds the smallest number in the current array and swaps it with the first.
 * Rewrite this program by finding the largest number and swapping it with the last. Write a test program that reads in
 * 10 double numbers, invokes the method, and displays the sorted numbers.
 */
public class Exercise7_20 {
  
  public static void main(String[] args) {
    int[] list = { 1, 9, 4, 6, 5, -4 };
    selectionSort(list, false);
    Arrays.stream(list).forEach(a -> System.out.print(a + " "));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static void selectionSortAsc(int[] arr) {
    if (arr == null || arr.length < 2) return;
    
    int currentMax;
    int currentMaxIndex;
    for (int i = arr.length - 1; i >= 0; i--) {
      currentMax = arr[i];
      currentMaxIndex = i;
      
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] > currentMax) {
          currentMax = arr[j];
          currentMaxIndex = j;
        }
      }
      
      if (currentMaxIndex != i) {
        arr[currentMaxIndex] = arr[i];
        arr[i] = currentMax;
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static void selectionSortDesc(int[] arr) {
    if (arr == null || arr.length < 2) return;
    
    int currentMax;
    int currentMaxIndex;
    for (int i = 0; i < arr.length - 1; i++) {
      currentMax = arr[i];
      currentMaxIndex = i;
      
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] > currentMax) {
          currentMax = arr[j];
          currentMaxIndex = j;
        }
      }
      
      if (currentMaxIndex != i) {
        arr[currentMaxIndex] = arr[i];
        arr[i] = currentMax;
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void selectionSort(int[] arr, boolean sortAsc) {
    if (sortAsc) {
      selectionSortAsc(arr);
    } else {
      selectionSortDesc(arr);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
