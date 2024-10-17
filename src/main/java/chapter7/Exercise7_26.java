package chapter7;

import java.util.Scanner;

/**
 *  Prompts the user to enter two lists of integers and displays whether the two are strictly identical. The arrays
 *  list1 and list2 are strictly identical if their corresponding elements are equal.
 */
public class Exercise7_26 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] list1 = readList(input, 1);
    int[] list2 = readList(input, 2);
    input.close();
    
    System.out.printf("Are list1 and list2 strictly identical? %b\n", equals(list1, list2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean equals(int[] list1, int[] list2) {
    if (list1.length != list2.length) return false;
    
    for (int i = 0; i < list1.length; i++) {
      if (list1[i] != list2[i]) return false;
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
