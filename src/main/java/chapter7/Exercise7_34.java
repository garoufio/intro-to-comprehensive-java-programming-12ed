package chapter7;

import java.util.Scanner;

/**
 * Prompts the user to enter a string and displays the sorted string.
 */
public class Exercise7_34 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String str = input.next();
    input.close();
    
    System.out.printf("The sorted string is: %s\n", sort(str, true));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String sort(String str, boolean sortAsc) {
    if (str == null || str.length() < 2) return str;
    
    char[] chars = str.toCharArray();
    if (sortAsc) {
      selectionSortAsc(chars);
    }
    else {
      selectionSortDesc(chars);
    }
    return new String(chars);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static void selectionSortAsc(char[] arr) {
    if (arr == null || arr.length < 2) return;
    
    char currentMin;
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
  
  private static void selectionSortDesc(char[] arr) {
    if (arr == null || arr.length < 2) return;
    
    char currentMax;
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
  
}
