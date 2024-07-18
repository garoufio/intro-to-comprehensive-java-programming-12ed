package chapter5;

/**
 * Write a program that simulates flipping a coin one million times and displays the number of heads and tails.
 */
public class Exercise5_40 {
  
  public static final int REPEATS = 1_000_000;
  
  public static void main(String[] args) {
    int heads = 0;
    int tails = 0;
    
    for (int i = 0; i < REPEATS; i++) {
      if ((int) (Math.random() + 0.5) > 0) heads++; // head is denoted by 1
      else tails++; // tail is denoted by 0
    }
    
    System.out.printf("Heads: %d\nTails: %d\n", heads, tails);
  }
  
}
