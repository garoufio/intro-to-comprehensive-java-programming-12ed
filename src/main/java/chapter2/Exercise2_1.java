package chapter2;

import java.util.Scanner;

/**
 * Converts Celsius degrees into Fahrenheit and displays the result.
 */
public class Exercise2_1 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double celsius, fahrenheit;
    
    System.out.print("Enter celsius: ");
    celsius = input.nextDouble();
    input.close();
    
    fahrenheit = (celsius * (9.0 / 5)) + 32;
    System.out.printf("'%.2f' Celsius is '%.2f' Fahrenheit\n", celsius, fahrenheit);
  }
  
}
