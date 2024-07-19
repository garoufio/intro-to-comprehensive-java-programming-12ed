package chapter5;

import java.util.Scanner;

/**
 * ISBN-13 is a new standard for identifying books. It uses 13 digits d1d2d3d4d5d6d7d8d9d10d11d12d13. The last digit
 * d13 is a checksum, which is calculated from the other digits using the following formula:
 *  10 - (d1 + 3*d2 + d3 + 3*d4 + d5 + 3*d6 + d7 + 3*d8 + d9 + 3*d10 + d11 + 3d*12) % 10
 * If the checksum is 10, replace it with 0. The program reads the input as a string and computes and displays the
 * checksum.
 */
public class Exercise5_47 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
    String isbn12 = input.nextLine();
    input.close();
    
    if (isbn12.length() != 12 || !isbn12.matches("\\d{12}")) {
      System.out.printf("'%s' is an invalid input\n", isbn12);
      System.exit(1);
    }
    
    int checksum, number;
    int sum = 0;
    for (int i = 0; i < isbn12.length(); i++) {
      number = Integer.parseInt(isbn12.charAt(i) + "");
      sum += (i % 2 != 0) ? (3 * number) : number;
    }
    checksum = 10 - (sum % 10);
    if (checksum == 10) checksum = 0;
    
    System.out.printf("The ISBN-13 number is '%s'\n", isbn12 + checksum);
  }
  
}
