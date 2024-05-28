package chapter3;

import java.util.Scanner;

public class Exercise3_34 {
  
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
    if (Math.abs(equation) <= 1E-14 &&
        ((pointX0 <= pointX2 && pointX2 <= pointX1) || (pointX0 >= pointX2 && pointX2 >= pointX1))
    ) {
      System.out.printf(
          "(%f, %f) is on the line segment from (%f, %f) to (%f, %f)\n",
          pointX2, pointY2, pointX0, pointY0, pointX1, pointY1
      );
    }
    else {
      System.out.printf(
          "(%f, %f) is not on the line segment from (%f, %f) to (%f, %f)\n",
          pointX2, pointY2, pointX0, pointY0, pointX1, pointY1
      );
    }
  }
  
}
