package chapter4;

/**
 * Generates three random points on a circle.
 */
public class Exercise4_6 {
  
  public static void main(String[] args) {
    double radius = 40;
    
    // point 1
    double angle = (Math.random() * (360 + 1));
    double x = radius * Math.cos(Math.toRadians(angle));
    double y = radius * Math.sin(Math.toRadians(angle));
    System.out.printf("Point1 is (%f, %f)\n", x, y);
    
    // point 2
    angle = (int)(Math.random() * (360 + 1));
    x = radius * Math.cos(Math.toRadians(angle));
    y = radius * Math.sin(Math.toRadians(angle));
    System.out.printf("Point2 is (%f, %f)\n", x, y);

    // point 3
    angle = (int)(Math.random() * (360 + 1));
    x = radius * Math.cos(Math.toRadians(angle));
    y = radius * Math.sin(Math.toRadians(angle));
    System.out.printf("Point3 is (%f, %f)\n", x, y);
  }
  
}
