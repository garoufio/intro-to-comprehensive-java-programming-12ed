package chapter7;

/**
 * Game: pick four cards. Write a program that picks four cards from a deck of 52 cards and computes their sum. An Ace,
 * King, Queen, and Jack represent 1, 13, 12, and 11, respectively. Your program should display the number of picks
 * that yields the sum of 24.
 */
public class Exercise7_29 {
  
  public static final int MAX_CARD_NUMBER = 52;
  public static final int NUMBER_OF_CARDS = 13;
  public static final int NUMBER_OF_PICKS = 4;
  public static final int TARGET_SUM = 24;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int countOfPlays = 0;
    int sumOfPicks = 0;
    int[] picks;
    for (;;) {
      picks = play(NUMBER_OF_PICKS);
      countOfPlays++;
      sumOfPicks = sum(picks);
      
      if (sumOfPicks == TARGET_SUM) break;
    }
    System.out.printf("the number of picks that yields the sum of '%d' is '%d'\n", TARGET_SUM, countOfPlays);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /* random number in [min, max] */
  public static  int getRandomCard(int min, int max) {
    return (int)(Math.random() * ((max + 1) - min) + min);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] play(int numberOfPicks) {
    int[] picks = new int[numberOfPicks];
    
    for (int i = 0; i < numberOfPicks; i++) {
      picks[i] = getRandomCard(1, MAX_CARD_NUMBER) % NUMBER_OF_CARDS;
      if (picks[i] == 0) picks[i] = NUMBER_OF_CARDS;
    }
    return picks;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int sum(int[] array) {
    int sum = 0;
    
    for (int a : array) sum += a;
    
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
