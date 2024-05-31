package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter the number of sides and the length of the side of a regular polygon (bot equilateral and
 * equiangular), and it computes and displays its area.
 */
public class Exercise4_5 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the number of sides: ");
    int numberOfSides = input.nextInt();
    if (numberOfSides <= 0) {
      input.close();
      System.out.println("The number of sides must be greater than 0.");
      System.exit(0);
    }
    System.out.print("Enter the length of the side: ");
    double len = input.nextDouble();
    if (len <= 0) {
      input.close();
      System.out.println("The length of the side must be greater than 0.");
      System.exit(1);
    }
    input.close();
    
    double area = (numberOfSides * len * len) / (4 * Math.tan(Math.toRadians(180 / numberOfSides)));
    System.out.printf("The area of the regular polygon is %.2f\n", area);
  }
  
}
