package chapter7;

import java.util.Scanner;

public class Exercise7_1 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    int numberOfStudents = getNumberOfStudents(input);
    int[] scores = getStudentScores(input, numberOfStudents);
    input.close();
    
    printGrades(scores);
  }

  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getNumberOfStudents(Scanner scanner) {
    int numberOfStudents = 0;
    
    do {
      System.out.print("Enter number of students: ");
      numberOfStudents = scanner.nextInt();
      
      if (numberOfStudents < 0) System.out.println("Invalid number of students!");
    } while (numberOfStudents < 0);
    
    return numberOfStudents;
  }
  
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getStudentScores(Scanner scanner, int numberOfStudents) {
    boolean validScores = false;
    int[] scores = new int[numberOfStudents];
    
    do {
      System.out.printf("Enter %d scores: ", numberOfStudents);
      for (int i = 0; i < numberOfStudents; i++) {
        int score = scanner.nextInt();
        
        if (score < 0 || score > 100) {
          System.out.println("Invalid score!");
          break;
        }
        
        scores[i] = score;
        if (i == 3) validScores = true;
      }
    } while (validScores == false);
    
    return scores;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printGrades(int[] scores) {
    int maxScore = getMaxScore(scores);
    
    for (int i = 0; i < scores.length; i++) {
      System.out.printf(
          "Student '%d' score is '%d' and grade '%c'\n",
          i, scores[i], getGrade(scores[i], maxScore)
      );
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static char getGrade(int score, int maxScore) {
    if (score >= maxScore - 10) return 'A';
    else if (score >= maxScore - 20) return 'B';
    else if (score >= maxScore - 30) return 'C';
    else if (score >= maxScore - 40) return 'D';
    else return 'F';
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int getMaxScore(int[] scores) {
    int maxScore = 0;
    
    for (int score : scores) {
      if (score > maxScore) maxScore = score;
    }
    
    return maxScore;
  }
  
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
