package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  Prompts the user to enter two lists of integers and displays whether the two are identical. The arrays list1 and
 *  list2 are identical if they have the same content.
 */
public class Exercise7_27 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] list1 = readList(input, 1);
    int[] list2 = readList(input, 2);
    input.close();
    
    System.out.printf("Are list1 and list2 identical? %b\n", equals(list1, list2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean equals(int[] list1, int[] list2) {
    if (list1.length != list2.length) return false;
    
    int[] sortedList1 = Arrays.copyOf(list1, list1.length);
    Arrays.sort(sortedList1);
    int[] sortedList2 = Arrays.copyOf(list2, list2.length);
    Arrays.sort(sortedList2);
    
    for (int i = 0; i < sortedList1.length; i++) {
      if (sortedList1[i] != sortedList2[i]) return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readList(Scanner scanner, int listNumber) {
    System.out.printf("Enter list%d size and contents: ", listNumber);
    int size = scanner.nextInt();
    if (size <= 0) {
      System.out.printf("Invalid list%d size\n", listNumber);
      return null;
    }
    
    int[] list = new int[size];
    for (int i = 0; i < size; i++) {
      list[i] = scanner.nextInt();
    }
    return list;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
