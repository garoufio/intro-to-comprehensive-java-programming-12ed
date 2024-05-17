package chapter2;

import java.util.Scanner;

/**
 * Computes the area and the volume of a cylinder for a given radius and length and displays the result.
 */
public class Exercise2_2 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double area, volume, radius, length;
    
    System.out.print("Enter the radius and the length of the cylinder: ");
    radius = input.nextDouble();
    length = input.nextDouble();
    input.close();
    
    area = Math.PI * radius * radius;
    volume = area * length;
    
    System.out.printf("The area of the cylinder is '%.2f'\n", area);
    System.out.printf("The volume of the cylinder is '%.2f'\n", volume);
  }

}
