package chapter8;

import java.util.Scanner;

/**
 * Given a set of cities, the central city is the city that has the shortest total distance to all other cities.
 * The program prompts the user to enter the number of cities and the locations of the cities (coordinates), and finds
 * the central city and its total distance to all other cities.
 */
public class Exercise8_21 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int numberOfCities = readNumberOfCities(sc);
      double[][] cities = readCitiesCoordinates(sc, numberOfCities);
      double[] citiesDistances = getCitiesTotalDistance(cities);
      printCentralCityInfo(cities, citiesDistances);
    }
    catch (Exception e) {
      System.err.println("Invalid input: " + e.getMessage());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean validateNumberOfCities(int numberOfCities) {
    if (numberOfCities <= 0) {
      System.out.printf("Number of cities '%d' must be greater than '0'\n", numberOfCities);
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readNumberOfCities(Scanner sc) {
    int numberOfCities;
    do {
      System.out.print("Enter the number of cities: ");
      numberOfCities = sc.nextInt();
    } while (!validateNumberOfCities(numberOfCities));
    sc.nextLine();
    
    return numberOfCities;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readCitiesCoordinates(Scanner sc, int numberOfCities) {
    double[][] cities = new double[numberOfCities][2];
    
    System.out.print("Enter the coordinates of the cities: ");
    for (int i = 0; i < numberOfCities; i++) {
      cities[i][0] = sc.nextDouble();
      cities[i][1] = sc.nextDouble();
    }
    return cities;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double getDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] getCitiesTotalDistance(double[][] cities) {
    double[] totalDistance = new double[cities.length];
    
    // { 2.5, 5 }, { 5.1, 3 }, { 1, 9 }, { 5.4, 54 }, { 5.5, 2.1 }
    for (int i = 0; i < cities.length; i++) {
      for (int r = i + 1; r < cities.length; r++) {
        totalDistance[i] += getDistance(cities[i][0], cities[i][1], cities[r][0], cities[r][1]);
      }
      for (int l = i - 1; l >= 0; l--) {
        totalDistance[i] += getDistance(cities[i][0], cities[i][1], cities[l][0], cities[l][1]);
      }
    }
    return totalDistance;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getMinCitiesDistance(double[] distances) {
    double minDistance = distances[0];
    int minIndex = 0;
    
    for (int i = 1; i < distances.length; i++) {
      if (distances[i] < minDistance) {
        minDistance = distances[i];
        minIndex = i;
      }
    }
    return minIndex;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printCentralCityInfo(double[][] cities, double[] distances) {
    int minDistanceIndex = getMinCitiesDistance(distances);
    System.out.printf(
        "The central city is at (%.2f, %.2f)\n",
        cities[minDistanceIndex][0], cities[minDistanceIndex][1]
    );
    System.out.printf(
        "The total distance to all other cities is '%.2f'\n",
        distances[minDistanceIndex]
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
