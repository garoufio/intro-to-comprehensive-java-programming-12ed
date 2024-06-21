package chapter5;

import java.util.Scanner;

/**
 * Prompts the user to enter the number of students, their names and scores and finds the student with the highest
 * score.
 */
public class Exercise5_8 {
  
  public static final int MIN_NUMBER_OF_STUDENTS = 1;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String name, maxName;
    int score, maxScore, numberOfStudents;
    
    System.out.print("Enter the number of students: ");
    numberOfStudents = input.nextInt();
    if (numberOfStudents < MIN_NUMBER_OF_STUDENTS) {
      System.out.printf("The minimum number of students is '%d'\n", MIN_NUMBER_OF_STUDENTS);
      System.exit(1);
    }
    
    maxName = "";
    maxScore = Integer.MIN_VALUE;
    for (int i = 0; i < numberOfStudents; i++) {
      System.out.print("Enter student name: ");
      name = input.next();
      System.out.print("Enter student's score: ");
      score = input.nextInt();
      
      if (score > maxScore) {
        maxScore = score;
        maxName = name;
      }
    }
    input.close();
    System.out.printf("Student with name '%s' has the highest score '%d'\n", maxName, maxScore);
  }
  
}
