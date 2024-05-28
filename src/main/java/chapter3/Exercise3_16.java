package chapter3;

/**
 * Generates and displays a random coordinate in a rectangular which is centered at (0, 0) with width 100 and height
 * 200.
 */
public class Exercise3_16 {
  
  public static void main(String[] args) {
    int pointX, pointY, pointSignX, pointSignY;
    
    pointX = (int)(Math.random() * 51);
    pointY = (int)(Math.random() * 101);
    pointSignX = (int)(Math.random() + 0.5);  // 0 for - and 1 for +
    pointSignY = (int)(Math.random() + 0.5);  // 0 for - and 1 for +
    
    if (pointSignX == 0) pointX = -pointX;
    if (pointSignY == 0) pointY = -pointY;
    System.out.printf("Random coordinates are (%d, %d)\n", pointX, pointY);
  }
  
}
