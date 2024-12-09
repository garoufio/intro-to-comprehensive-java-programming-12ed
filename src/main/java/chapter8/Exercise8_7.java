package chapter8;

/**
 * (Points nearest to each other) Listing 8.3 gives a program that finds two points in a two-dimensional space nearest
 * to each other. Revise listing 8.3, so it finds two points in a three-dimensional space nearest to each other. Use a
 * two-dimensional array to represent the points. Test the program using the following points:
 * double[][] points = {
 *    {−1, 0, 3},
 *    {−1, −1, −1},
 *    {4, 1, 1},
 *    {2, 0.5, 9},
 *    {3.5, 2, −1},
 *    {3, 1.5, 3},
 *    {−1.5, 4, 2},
 *    {5.5, 4, −0.5}
 *  }
 */
public class Exercise8_7 {
  
  public static void main(String[] args) {
    double[][] points = {
      {-1, 0, 3},
      {-1, -1, -1},
      {4, 1, 1},
      {2, 0.5, 9},
      {3.5, 2, -1},
      {3, 1.5, 3},
      {-1.5, 4, 2},
      {5.5, 4, -0.5}
    };
    
    getNearestPoints(points);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void getNearestPoints(double[][] points) {
    double minDistance = Double.MAX_VALUE;
    double distance;
    int indexPoint1 = 0, indexPoint2 = 0;
    
    for (int i = 0; i < points.length - 1; i++) {
      for (int row = i + 1; row < points.length; row++) {
        distance = getDistance(
            points[i][0], points[i][1], points[i][2],
            points[row][0], points[row][1], points[row][2]
        );
        if (distance < minDistance) {
          minDistance = distance;
          indexPoint1 = i;
          indexPoint2 = row;
        }
      }
    }
    
    System.out.printf(
        "The closest two points are (%.2f, %.2f, %.2f) and (%.2f, %.2f, %.2f)\n",
        points[indexPoint1][0], points[indexPoint1][1], points[indexPoint1][2],
        points[indexPoint2][0], points[indexPoint2][1], points[indexPoint2][2]
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
