package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter the ISBN-10 first 9 digits and the program computes and displays the ISBN-10 10th digit.
 */
public class Exercise5_36 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String isbn9;
    
    System.out.print("Enter the first 9 digits of an ISBN as integer: ");
    isbn9 = input.nextLine();
    input.close();
    
    if (!isbn9.matches("\\d{9}")) {
      System.out.println("The ISBN number is incorrect");
      System.exit(1);
    }
    
    // 013601267 -> 1
    // 013031997 -> X
    int isbn9Number = Integer.parseInt(isbn9);
    int checksum = 0, remainingISBN = isbn9Number;
    for (int i = 100_000_000, j = 1; i > 0; i /= 10, j++) {
      checksum += (remainingISBN / i) * j;
      remainingISBN %= i;
    }
    checksum %= 11;
    System.out.printf(
        "The ISBN-10 number is '%s%c'\n",
        isbn9, checksum < 10 ? Character.forDigit(checksum, 10) : 'X'
    );
  }
  
}
