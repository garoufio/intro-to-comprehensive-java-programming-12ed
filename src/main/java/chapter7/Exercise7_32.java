package chapter7;

import java.util.Scanner;

public class Exercise7_32 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size = readListSize(input);
    int[] list = readListContent(input, size);
    input.close();
    
    // TODO: partition
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
  
}
