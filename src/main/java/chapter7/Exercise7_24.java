package chapter7;

/**
 * (Simulation: coupon collector’s problem) Coupon collector is a classic statistics problem with many practical
 * applications. The problem is to repeatedly pick objects from a set of objects and find out how many picks are needed
 * for all the objects to be picked at least once. A variation of the problem is to pick cards from a shuffled deck of
 * 52 cards repeatedly, and find out how many picks are needed before you see one of each suit. Assume a picked card is
 * placed back in the deck before picking another. The  program simulates the number of picks needed to get four cards
 * from each suit and display the four cards picked (it is possible a card may be picked twice).
 */
public class Exercise7_24 {
  
  public static final int NUMBER_OF_CARDS = 52;
  public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
  public static final String[] RANKS = {
      "Ace", "2", "3", "4", "5",
      "6", "7", "8", "9", "10",
      "Jack", "Queen", "King"
  };
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    boolean[] pickedSuits = new boolean[SUITS.length];
    int numberOfPicks = 0;
    int cardNumber;
    
    while (areAllSuitsPicked(pickedSuits) == false) {
      cardNumber = (int) (Math.random() * NUMBER_OF_CARDS);
      if (pickedSuits[cardNumber / 13] == false) {
        pickedSuits[cardNumber / 13] = true;
        
        System.out.printf("%s of %s\n", RANKS[cardNumber % 13], SUITS[cardNumber / 13]);
      }
      numberOfPicks++;
    }
    System.out.printf("Number of picks: %d\n", numberOfPicks);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean areAllSuitsPicked(boolean[] pickedSuits) {
    for (int i = 0; i < pickedSuits.length; i++) {
      if (pickedSuits[i] == false) return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
