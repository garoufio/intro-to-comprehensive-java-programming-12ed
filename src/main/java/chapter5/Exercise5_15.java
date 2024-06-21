package chapter5;

/**
 * Displays the ASCII character table from ! to ~.
 */
public class Exercise5_15 {

  public static final int CHARS_PER_LINE = 10;
  public static final char STARTING_CHAR = '!';
  public static final char ENDING_CHAR = '~';
  
  public static void main(String[] args) {
    int count = 0;
    for (char ch = STARTING_CHAR; ch <= ENDING_CHAR; ch++) {
      System.out.printf("%c ", ch);
      count++;
      if (count % CHARS_PER_LINE == 0) System.out.println();
    }
  }

}
