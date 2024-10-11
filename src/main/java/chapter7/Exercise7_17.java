package chapter7;

import java.util.Scanner;

/**
 * Prompt the user to enter the number of students, the student's names and their scores. Then it displays the
 * student's names in decreasing order of their scores.
 */
public class Exercise7_17 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numberOfStudents = readNumberOfStudents(input);
    int[] scores = new int[numberOfStudents];
    String[] names = new String[numberOfStudents];
    
    readStudentsInfo(input, scores, names);
    input.close();
    
    selectionSort(scores, names);
    printStudentInfo(scores, names);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readNumberOfStudents(Scanner scanner) {
    int numberOfStudents = 0;
    
    do {
      System.out.print("Enter the number of students (>= 0): ");
      numberOfStudents = scanner.nextInt();
      if (numberOfStudents < 0) {
        System.out.println("Invalid number of students!");
      }
    } while (numberOfStudents < 0);
    return numberOfStudents;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readStudentScore(Scanner scanner, int index) {
    System.out.printf("Enter the student%d score: ", index);
    int score = scanner.nextInt();
    
    return score < 0 ? 0 : score;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String readStudentName(Scanner scanner, int index) {
    System.out.printf("Enter student%d name: ", index);
    return scanner.next();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void readStudentsInfo(Scanner scanner, int[] scores, String[] names) {
    for (int i = 0; i < scores.length; i++) {
      names[i] = readStudentName(scanner, i + 1);
      scores[i] = readStudentScore(scanner, i + 1);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printStudentInfo(int[] scores, String[] names) {
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("Student%d name is '%s' and scored '%d'\n", i+1, names[i], scores[i]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Sorts using selection sort in ascending order  */
  private static void selectionSort(int[] scores, String[] names) {
    if (scores == null || scores.length < 2) return;
    
    int currentMin;
    String currentName = "";
    int currentMinIndex;
    for (int i = 0; i < scores.length - 1; i++) {
      currentMin = scores[i];
      currentMinIndex = i;
      
      for (int j = i + 1; j < scores.length; j++) {
        if (scores[j] < currentMin) {
          currentMin = scores[j];
          currentMinIndex = j;
          currentName = names[j];
        }
      }
      
      if (currentMinIndex != i) {
        // scores
        scores[currentMinIndex] = scores[i];
        scores[i] = currentMin;
        // students
        names[currentMinIndex] = names[i];
        names[i] = currentName;
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
