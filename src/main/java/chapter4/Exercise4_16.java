package chapter4;

/**
 * Displays a random uppercase letter using the Math.random() method.
 */
public class Exercise4_16 {
  
  public static void main(String[] args) {
    int intLetter = (int)(Math.random() * ((int)'Z' - (int)'A' + 1) + (int)'A');
    System.out.println(intLetter + " " + (char)intLetter);
  }
  
}
