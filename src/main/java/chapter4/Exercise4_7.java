package chapter4;

import java.util.Scanner;

public class Exercise4_7 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the radius of the bounding circle: ");
    double radius = input.nextDouble();
    input.close();
    if (radius <= 0) {
      System.out.println("Radius must be greater than 0");
      System.exit(1);
    }
    
    // s = 2 * radius * sin(p / 5)
    double angle = (Math.random() * (360 + 1));
    double x1 = radius * Math.cos(Math.toRadians(angle));
    double y1 = radius * Math.sin(Math.toRadians(angle));
    
    angle = (Math.random() * (360 + 1));
    double x2 = radius * Math.cos(Math.toRadians(angle));
    double y2 = radius * Math.sin(Math.toRadians(angle));
    
    angle = (Math.random() * (360 + 1));
    double x3 = radius * Math.cos(Math.toRadians(angle));
    double y3 = radius * Math.sin(Math.toRadians(angle));
    
    angle = (Math.random() * (360 + 1));
    double x4 = radius * Math.cos(Math.toRadians(angle));
    double y4 = radius * Math.sin(Math.toRadians(angle));
    
    angle = (Math.random() * (360 + 1));
    double x5 = radius * Math.cos(Math.toRadians(angle));
    double y5 = radius * Math.sin(Math.toRadians(angle));
    
    System.out.println("The coordinates of five points on the pentagon are:");
    System.out.printf("(%.2f, %.2f)\n", x1, y1);
    System.out.printf("(%.2f, %.2f)\n", x2, y2);
    System.out.printf("(%.2f, %.2f)\n", x3, y3);
    System.out.printf("(%.2f, %.2f)\n", x4, y4);
    System.out.printf("(%.2f, %.2f)\n", x5, y5);
  }

}
