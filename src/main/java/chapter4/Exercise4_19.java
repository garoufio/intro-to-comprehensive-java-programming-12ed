package chapter4;

import java.util.Scanner;

/**
 * Prompts the user to enter the ISBN-10 first 9 digits and the program computes and displays the ISBN-10 10th digit.
 */
public class Exercise4_19 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int isbn9, checksum, remainingISBN;
    
    System.out.print("Enter the first 9 digits of an ISBN as integer: ");
    String strIsbn9 = input.nextLine();
    input.close();
    
    if (strIsbn9.length() != 9) {
      System.out.println("Invalid ISBN number length");
      System.exit(1);
    }
    isbn9 = Integer.parseInt(strIsbn9);
    
    remainingISBN = isbn9;
    checksum = remainingISBN / 100000000;
    remainingISBN %= 100000000;
    checksum += (remainingISBN / 10000000) * 2;
    remainingISBN %= 10000000;
    checksum += (remainingISBN / 1000000) * 3;
    remainingISBN %= 1000000;
    checksum += (remainingISBN / 100000) * 4;
    remainingISBN %= 100000;
    checksum += (remainingISBN / 10000) * 5;
    remainingISBN %= 10000;
    checksum += (remainingISBN / 1000) * 6;
    remainingISBN %= 1000;
    checksum += (remainingISBN / 100) * 7;
    remainingISBN %= 100;
    checksum += (remainingISBN / 10) * 8;
    remainingISBN %= 10;
    checksum += remainingISBN * 9;
    checksum %= 11;
    System.out.printf(
        "The ISBN-10 number is '%09d%c'\n",
        isbn9, checksum < 10 ? Character.forDigit(checksum, 10) : 'X'
    );
  }
  
}
