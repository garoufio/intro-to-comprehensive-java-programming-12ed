package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter a list and displays whether the list is sorted or not.
 */
public class Exercise7_19 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size = readSizeOfList(input);
    int[] list = readList(input, size);
    input.close();
    
    if (isSorted(list)) {
      System.out.println("The list is already sorted");
    }
    else {
      System.out.println("The list is not sorted");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readSizeOfList(Scanner scanner) {
    int size = 0;
    
    do {
      System.out.print("Enter the size of the list (>= 0): ");
      size = scanner.nextInt();
      if (size < 0) {
        System.out.println("Invalid size of list!");
      }
    } while (size < 0);
    return size;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readList(Scanner scanner, int size) {
    int[] list = new int[size];
    
    System.out.print("Enter the contents of the list: ");
    for (int i = 0; i < size; i++) {
      list[i] = scanner.nextInt();
    }
    return list;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isSorted(int[] list) {
    int[] sortedList = Arrays.copyOf(list, list.length);
    Arrays.sort(sortedList);
    
    for (int i = 0; i < sortedList.length; i++) {
      if (sortedList[i] != list[i]) return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
