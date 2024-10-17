package chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise7_32 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size = readListSize(input);
    int[] list = readListContent(input, size);
    input.close();
    
    partition(list);
    System.out.println("After the partition, the list is: " + Arrays.toString(list));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readListSize(Scanner scanner) {
    int size;
    
    do {
      System.out.print("Enter list size and contents: ");
      size = scanner.nextInt();
      if (size <= 0) System.out.printf("Invalid list size '%d'\n", size);
    } while (size <= 0);
    
    return size;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readListContent(Scanner scanner, int size) {
    int[] list = new int[size];
    for (int i = 0; i < size; i++) {
      list[i] = scanner.nextInt();
    }
    return list;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int partition(int[] list) {
    int first = 0;
    int last = list.length - 1;
    int pivot = list[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search
    
    while (high > low) {
      // Search forward from left
      while (low <= high && list[low] <= pivot) low++;
      
      // Search backward from right
      while (low <= high && list[high] > pivot) high--;
      
      // Swap two elements in the list
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }
    
    while (high > first && list[high] >= pivot) high--;
    
    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
