package chapter7;

import java.util.Scanner;

/**
 * Prompts the user to enter 10 integers and displays all combinations of picking two numbers from the 10 numbers.
 */
public class Exercise7_28 {
  
  public static final int LIST_SIZE = 5;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] list = readList(input);
    input.close();
    
    printCombinations(list);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readList(Scanner scanner) {
    System.out.printf("Enter %d integers: ", LIST_SIZE);
    int[] list = new int[LIST_SIZE];
    
    for (int i = 0; i < LIST_SIZE; i++) {
      list[i] = scanner.nextInt();
    }
    return list;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printCombinations(int[] list) {
    for (int i = 0; i < list.length - 1; i++) {
      for (int j = i + 1; j < list.length; j++) {
        System.out.printf("%d %d\n", list[i], list[j]);
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
