package chapter8;

public class GradeExam {
  
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
    printStudentScores(studentScores);
    int[] highestScore = findHighestScore(studentScores);
    System.out.printf("Student %d has the highest score: %d\n", highestScore[0], highestScore[1]);
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
  
  public static void printStudentScores(int[] scores) {
    if (scores == null) return;
    
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("Student %d's correct count is %d\n", i, scores[i]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] findHighestScore(int[] scores) {
    if (scores == null) return null;
    
    int[] highestScore = new int[2];
    highestScore[0] = 0;  // index
    highestScore[1] = scores[0];  // correct count
    
    for (int i = 1; i < scores.length; i++) {
      if (scores[i] > highestScore[1]) {
        highestScore[0] = i;
        highestScore[1] = scores[i];
      }
    }
    
    return highestScore;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
