package chapter7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Prompts the user to enter his/her year of birth and displays the related animal in the Chinese zodiac.
 */
public class Exercise7_33 {
  
  public static final String[] ANIMALS = {
      "monkey", "rooster", "dog", "pig", "rat", "ox",
      "tiger", "rabbit", "dragon", "snake", "horse", "sheep"
  };
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      int year = getYearOfBirth(input);
      printAnimal(year);
    } catch (InputMismatchException e) {
      System.err.println("Invalid value for year entered.");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getYearOfBirth(Scanner scanner) {
    int year;
    
    do {
      System.out.print("Enter year of birth: ");
      year = scanner.nextInt();
      if (year < 1000 || year > 9999) {
        System.out.println("Invalid year. Year must be between 1000 and 9999.");
      }
    } while (year < 1000 || year > 9999);
    
    return year;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printAnimal(int year) {
    System.out.println(ANIMALS[year % 12]);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
