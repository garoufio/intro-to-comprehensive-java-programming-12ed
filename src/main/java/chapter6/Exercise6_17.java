package chapter6;

import java.util.Scanner;

/**
 * Prompts the user to enter a positive integer value n so the program can create an n-by-n matrix of 0s and 1s.
 */
public class Exercise6_17 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printMatrix(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print((int)(Math.random() + 0.5));
        if (j < n - 1) System.out.print(" ");
      }
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getMatrixSize(Scanner scanner) {
    int n;
    do {
      System.out.print("Enter n: ");
      n = scanner.nextInt();
      if (n <= 0) System.out.println("n must be positive and greater than 0");
    } while (n <= 0);
    
    return n;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = getMatrixSize(scanner);
    scanner.close();
    
    printMatrix(n);
  }
  
}
