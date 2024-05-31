package chapter4;

import java.util.Scanner;

public class GuessBirthday {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int answer, day;
    String set1 =
        "1 3 5 7\n" +
        "9 11 13 15\n" +
        "17 19 21 23\n" +
        "25 27 29 31";
    String set2 =
        "2 3 6 7\n" +
        "10 11 14 15\n" +
        "18 19 22 23\n" +
        "26 27 30 31";
    String set3 =
        "4 5 6 7\n" +
        "12 13 14 15\n" +
        "20 21 22 23\n" +
        "28 29 30 31";
    String set4 =
        "8 9 10 11\n" +
        "12 13 14 15\n" +
        "24 25 26 27\n" +
        "28 29 30 31";
    String set5 =
        "16 17 18 19\n" +
        "20 21 22 23\n" +
        "24 25 26 27\n" +
        "28 29 30 31";
    
    day = 0;
    // Set1
    System.out.printf("Is your birthday in Set1:\n%s\n(0 - NO, 1 - YES): ", set1);
    answer = input.nextInt();
    if (answer == 1) {
      day += 1;
    }
    else if (answer < 0 || answer > 1) {
      System.out.println("Invalid birthday");
      System.exit(1);
    }
    // Set2
    System.out.printf("Is your birthday in Set2:\n%s\n(0 - NO, 1 - YES): ", set2);
    answer = input.nextInt();
    if (answer == 1) {
      day += 2;
    }
    else if (answer < 0 || answer > 1) {
      System.out.println("Invalid birthday");
      System.exit(1);
    }
    // Set3
    System.out.printf("Is your birthday in Set3:\n%s\n(0 - NO, 1 - YES): ", set3);
    answer = input.nextInt();
    if (answer == 1) {
      day += 4;
    }
    else if (answer < 0 || answer > 1) {
      System.out.println("Invalid birthday");
      System.exit(1);
    }
    // Set4
    System.out.printf("Is your birthday in Set4:\n%s\n(0 - NO, 1 - YES): ", set4);
    answer = input.nextInt();
    if (answer == 1) {
      day += 8;
    }
    else if (answer < 0 || answer > 1) {
      System.out.println("Invalid birthday");
      System.exit(1);
    }
    // Set5
    System.out.printf("Is your birthday in Set5:\n%s\n(0 - NO, 1 - YES): ", set5);
    answer = input.nextInt();
    if (answer == 1) {
      day += 16;
    }
    else if (answer < 0 || answer > 1) {
      System.out.println("Invalid birthday");
      System.exit(1);
    }
    input.close();
    
    System.out.printf("\nYour birthday is on '%d'\n", day);
  }
  
}
