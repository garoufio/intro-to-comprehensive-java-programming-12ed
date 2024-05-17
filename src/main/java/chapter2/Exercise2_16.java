package chapter2;

import java.util.Scanner;

/**
 * Calculates and displays the area of a hexagon for a given side of hexagon.
 */
public class Exercise2_16 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double length, area;
    
    System.out.print("Enter the length of the side: ");
    length = input.nextDouble();
    input.close();
    
    area = ((3 * Math.sqrt(3)) / 2) * Math.pow(length, 2);
    System.out.printf("The area of the hexagon is '%.2f'", area);
  }
  
}
