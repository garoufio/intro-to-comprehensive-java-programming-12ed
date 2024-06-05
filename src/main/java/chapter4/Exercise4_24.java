package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter three cities, and then it displays them in ascending order.
 */
public class Exercise4_24 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the first city: ");
    String city1 = input.nextLine();
    System.out.print("Enter the second city: ");
    String city2 = input.nextLine();
    System.out.print("Enter the third city: ");
    String city3 = input.nextLine();
    input.close();
    
    if (city1.compareTo(city2) <= 0) {
      if (city1.compareTo(city3) <= 0) {
        if (city2.compareTo(city3) <= 0) {
          System.out.printf("The three cities in alphabetical order are:\n%s\n%s\n%s\n", city1, city2, city3);
        }
        else {
          System.out.printf("The three cities in alphabetical order are:\n%s\n%s\n%s\n", city1, city3, city2);
        }
      }
      else {
        System.out.printf("The three cities in alphabetical order are:\n%s\n%s\n%s\n", city3, city1, city2);
      }
    }
    else if (city1.compareTo(city3) <= 0) {
      System.out.printf("The three cities in alphabetical order are:\n%s\n%s\n%s\n", city2, city1, city3);
    }
    else if (city2.compareTo(city3) <= 0) {
      System.out.printf("The three cities in alphabetical order are:\n%s\n%s\n%s\n", city2, city3, city1);
    }
    else {
      System.out.printf("The three cities in alphabetical order are:\n%s\n%s\n%s\n", city3, city2, city1);
    }
  }
  
}
