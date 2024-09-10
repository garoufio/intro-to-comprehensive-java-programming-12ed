package chapter6;

/**
 * Plays craps game for 10.000 times.
 */
public class Exercise6_32 {
  
  public static final int NUMBER_OF_PLAYS = 10000;
  public static final int LOOSE_GAME      = 0;
  public static final int WIN_GAME        = 1;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int rollDice() {
    return (int)(Math.random() * 7);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int play() {
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
          return LOOSE_GAME;
        } else if (sum == 7 || sum == 11) {
          System.out.printf("You win");
          return WIN_GAME;
        } else {
          System.out.printf("Point is %d\n", sum);
          point = sum;
        }
      } else {
        if (sum == 7) {
          System.out.println("You lose");
          return LOOSE_GAME;
        } else if (sum == point) {
          System.out.println("You win");
          return WIN_GAME;
        }
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int numberOfPlays = 0;
    int numberOfWins = 0;
    int result;
    
    while (numberOfPlays < NUMBER_OF_PLAYS) {
      result = play();
      if (result == WIN_GAME) numberOfWins++;
      
      numberOfPlays++;
    }
    
    System.out.printf("Number of wins '%d'\n", numberOfWins);
    System.out.printf("Number of looses '%d'\n", NUMBER_OF_PLAYS - numberOfWins);
  }
  
}
