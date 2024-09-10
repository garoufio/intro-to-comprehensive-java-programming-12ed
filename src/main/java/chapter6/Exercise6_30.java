package chapter6;

/**
 * Game: craps
 */
public class Exercise6_30 {
  
  public static int rollDice() {
    return (int)(Math.random() * 7);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void play() {
    int roll1, roll2, sum;
    int point = 0, count = 0;
    
    for (;;) {
      roll1 = rollDice();
      roll2 = rollDice();
      sum = roll1 + roll2;
      count++;
      
      System.out.printf("You rolled %d + %d = %d\n", roll1, roll2, sum);
      if (count == 1) {
        if (sum == 2 || sum == 3 || sum == 12) {
          System.out.println("You lose");
          return;
        }
        else if (sum == 7 || sum == 11) {
          System.out.printf("You win");
          return;
        }
        else {
          System.out.printf("Point is %d\n", sum);
          point = sum;
        }
      }
      else {
        if (sum == 7) {
          System.out.println("You lose");
          return;
        }
        else if (sum == point) {
          System.out.println("You win");
          return;
        }
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    play();
  }

}
