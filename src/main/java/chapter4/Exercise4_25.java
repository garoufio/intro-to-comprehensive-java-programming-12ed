package chapter4;

/**
 * Creates a car plate with random letters and numbers in the format DDD1111 (three letters and four digits), and \
 * displays it.
 */
public class Exercise4_25 {
  
  public static void main(String[] args) {
    char intLetter1 = (char)((int)(Math.random() * ((int)'Z' - (int)'A' + 1) + (int)'A'));
    char intLetter2 = (char)((int)(Math.random() * ((int)'Z' - (int)'A' + 1) + (int)'A'));
    char intLetter3 = (char)((int)(Math.random() * ((int)'Z' - (int)'A' + 1) + (int)'A'));
    int digit1 = (int)(Math.random() * 10);
    int digit2 = (int)(Math.random() * 10);
    int digit3 = (int)(Math.random() * 10);
    int digit4 = (int)(Math.random() * 10);
    String plate = "" + intLetter1 + intLetter2 + intLetter3 + digit1 + digit2 + digit3 + digit4;
    
    System.out.println(plate);
  }
  
}
