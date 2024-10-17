package chapter7;

import java.util.Arrays;

public class ArraySort {
  
  public static void main(String[] args) {
    int[] list = { 1, 9, 4, 6, 5, -4 };
    selectionSort(list, true);
    System.out.println(Arrays.toString(list));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static void selectionSortAsc(int[] arr) {
    if (arr == null || arr.length < 2) return;
    
    int currentMin;
    int currentMinIndex;
    for (int i = 0; i < arr.length - 1; i++) {
      currentMin = arr[i];
      currentMinIndex = i;
      
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < currentMin) {
          currentMin = arr[j];
          currentMinIndex = j;
        }
      }
      
      if (currentMinIndex != i) {
        arr[currentMinIndex] = arr[i];
        arr[i] = currentMin;
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
