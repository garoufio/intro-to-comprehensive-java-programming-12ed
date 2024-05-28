package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter three integers, sorts them in increasing order and displays them sorted.
 */
public class Exercise3_8 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int intVal1, intVal2, intVal3;
    
    System.out.print("Enter three integers: ");
    intVal1 = input.nextInt();
    intVal2 = input.nextInt();
    intVal3 = input.nextInt();
    input.close();
    
    // 1 3 2
    if (intVal1 >= intVal2) {
      if (intVal1 >= intVal3) {
        System.out.printf("%d ", intVal1);
        if (intVal2 >= intVal3) {
          System.out.printf("%d %d\n", intVal2, intVal3);
        }
        else {
          System.out.printf("%d %d\n", intVal3, intVal2);
        }
      }
      else {
        System.out.printf("%d %d %d\n", intVal3, intVal1, intVal2);
      }
    }
    else if (intVal2 >= intVal3) {
      System.out.printf("%d ", intVal2);
      if (intVal1 >= intVal3) {
        System.out.printf("%d %d\n", intVal1, intVal3);
      }
      else {
        System.out.printf("%d %d\n", intVal3, intVal1);
      }
    }
    else {
      System.out.printf("%d %d %d\n", intVal3, intVal2, intVal1);
    }
  }
  
}
