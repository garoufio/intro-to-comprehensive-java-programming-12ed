package chapter2;

import java.util.Scanner;

/**
 * Computes and displays the population projection for a given number of years.
 */
public class Exercise2_11 {
  
  public static final long CURRENT_US_POPULATION = 312_032_486;
  public static final double BIRTHS_PER_SECOND = 7;
  public static final double DEATHS_PER_SECOND = 13;
  public static final double IMMIGRANTS_PER_SECOND = 45;
  public static final long SECONDS_PER_YEAR = 365 * 24 * 60 * 60;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long population;
    int years;
    
    System.out.print("Enter the number of years: ");
    years = input.nextInt();
    input.close();
    
    population = (long)(
        CURRENT_US_POPULATION + years * (
        (SECONDS_PER_YEAR / BIRTHS_PER_SECOND) +
        (SECONDS_PER_YEAR / IMMIGRANTS_PER_SECOND) -
        (SECONDS_PER_YEAR / DEATHS_PER_SECOND)
    ));
    System.out.printf("The population in '%d' year(s) will be '%,d'\n", years, population);
  }
  
}
