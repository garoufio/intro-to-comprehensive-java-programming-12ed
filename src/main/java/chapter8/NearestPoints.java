package chapter8;

public class NearestPoints {
  
  public static void main(String[] args) {
    final double[][] points = {
        {-1, 3}, {-1, -1}, {1, 1}, {2, 0.5},
        {2, -1}, {3, 3}, {4, 2}, {4, -0.5}
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
        distance = getDistance(points[i][0], points[i][1], points[row][0], points[row][1]);
        if (distance < minDistance) {
          minDistance = distance;
          indexPoint1 = i;
          indexPoint2 = row;
        }
      }
    }
    
    System.out.printf(
        "The closest two points are (%.2f, %.2f) and (%.2f, %.2f)\n",
        points[indexPoint1][0], points[indexPoint1][1], points[indexPoint2][0], points[indexPoint2][1]
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
