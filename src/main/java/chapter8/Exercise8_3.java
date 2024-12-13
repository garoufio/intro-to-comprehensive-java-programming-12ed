package chapter8;

import chapter7.ArraySort;

import java.util.Arrays;

/**
 * (Sort students on grades) Rewrite Listing GradeExam.java, to display the students in increasing order of the number
 * of correct answers.
 */
public class Exercise8_3 {
  
  public static void main(String[] args) {
    final char[][] answers = {
        { 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
        { 'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D' },
        { 'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D' },
        { 'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D' },
        { 'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
        { 'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
        { 'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
        { 'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' }
    };
    final char[] keys = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };
    
    int[] studentScores = gradeAllAnswers(answers, keys);
    printStudentScores(sortStudentScores(studentScores));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] gradeAllAnswers(char[][] answers, char[] keys) {
    if (answers == null || keys == null) return null;
    
    int[] scores = new int[answers.length];
    
    for (int row = 0; row < answers.length; row++) {
      scores[row] = 0;
      for (int col = 0; col < answers[row].length; col++) {
        if (answers[row][col] == keys[col]) {
          scores[row]++;
        }
      }
    }
    return scores;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /* Sorts student scores in increasing order */
  public static int[] sortStudentScores(int[] scores) {
    if (scores == null) return null;
    
    /* either use sort method from Arrays class or the selection sort method from chapter 7 */
    int[] sortedScores = Arrays.copyOf(scores, scores.length);
//    Arrays.sort(sortedScores);
    ArraySort.selectionSort(sortedScores, true);
    
    return sortedScores;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printStudentScores(int[] scores) {
    if (scores == null) return;
    
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("Student %d's correct count is %d\n", i, scores[i]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
