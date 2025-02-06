package chapter7;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (Game: bean machine) The bean machine, also known as a quincunx or the Galton box, is a device for statistics
 * experiments named after English scientist Sir Francis Galton. It consists of an upright board with evenly spaced
 * nails (or pegs) in a triangular form. Balls are dropped from the opening of the board. Every time a ball hits a nail,
 * it has a 50% chance of falling to the left or to the right. The piles of balls are accumulated in the slots at the
 * bottom of the board. The program should prompt the user to enter the number of the balls and the number of the slots
 * in the machine. Simulate the falling of each ball by printing its path. Display the final buildup of the balls in
 * the slots in a histogram. (Hint: Create an array named slots. Each element in slots stores the number of balls in a
 * slot. Each ball falls into a slot via a path. The number of Rs in a path is the position of the slot where the ball
 * falls. For example, for the path LRLRLRR, the ball falls into slots[4], and for the path RRLLLLL, the ball falls
 * into slots[2].)
 */
public class Exercise7_37 {
  
  public static void main(String[] args) {
    start();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumberOfSlots(Scanner scanner) {
    int numberOfSlots = 0;
    
    do {
      System.out.print("Enter the number of slots in the bean machine: ");
      numberOfSlots = scanner.nextInt();
      if (numberOfSlots < 1) {
        System.out.println("Number of slots must be greater than 0");
      }
    } while (numberOfSlots < 1);
    
    return numberOfSlots;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumberOfBalls(Scanner scanner) {
    int numberOfBalls = 0;
    
    do {
      System.out.print("Enter the number of balls to drop: ");
      numberOfBalls = scanner.nextInt();
      if (numberOfBalls < 1) {
        System.out.println("Number of balls must be greater than 0");
      }
    } while (numberOfBalls < 1);
    
    return numberOfBalls;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static char getDirection() {
    int randomNumber = (int)(Math.random() * (10) + 1);
    return randomNumber >= 5 ? 'R' : 'L';
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int countR(char[] array) {
    int count = 0;
    
    for (char ch : array) {
      if (ch == 'R') count++;
    }
    return count;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printSlots(int[] slots) {    
    for (int i = 0; i < slots.length; i++) {
      for (int j = 0; j < slots.length; j++) {
        if (slots[j] == 0) System.out.print(" ");
        else {
          if (slots.length - slots[j] <= i) System.out.print("O");
          else System.out.print(" ");
        }
        if (j != slots.length - 1) System.out.print(" ");
      }
      System.out.println();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void start() {
    try (Scanner input = new Scanner(System.in)) {
      int numberOfBalls = getNumberOfBalls(input);
      int numberOfSlots = getNumberOfSlots(input);
      int[] slot = new int[numberOfSlots];
      char[] path = new char[numberOfSlots];
      int index;

      for (int i = 0; i < numberOfBalls; i++) {
        for (int j = 0; j < numberOfSlots; j++) {
          path[j] = getDirection();
        }
        for (int k = 0; k < numberOfSlots - 1; k++) {
          System.out.print(path[k]);
        }
        System.out.println();
        index = countR(path);
        slot[index]++;
      }
      System.out.println(Arrays.toString(slot));
      printSlots(slot);
    }
    catch (InputMismatchException e) {
      System.err.println("Invalid input");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
