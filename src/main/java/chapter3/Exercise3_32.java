package chapter3;

import java.util.Scanner;

/**
 * Prompts the user to enter the x-, y- coordinates of three points p0, p1 and p2, and then it decides whether the
 * point p2 is on the left or right of the line, or on the same line.
 */
public class Exercise3_32 {
  
  public static void main(String[] args) {
    Scanner input =  new Scanner(System.in);
    double pointX0, pointY0, pointX1, pointY1, pointX2, pointY2;
    
    System.out.print("Enter three points for p0, p1 and p2: ");
    pointX0 = input.nextDouble();
    pointY0 = input.nextDouble();
    pointX1 = input.nextDouble();
    pointY1 = input.nextDouble();
    pointX2 = input.nextDouble();
    pointY2 = input.nextDouble();
    input.close();
    
    double equation = (pointX1 - pointX0) * (pointY2 - pointY0) - (pointX2 - pointX0) * (pointY1 - pointY0);
    if (Math.abs(equation) == 0D) {
      System.out.println("p2 is on the same line ");
    }
    else if (equation < 0D) {
      System.out.println("p2 is on the right side of the line");
    }
    else {
      System.out.println("p2 is on the left side of the line");
    }
  }
  
}
