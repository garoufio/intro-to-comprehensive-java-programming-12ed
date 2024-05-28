package chapter3;

import java.util.Scanner;

/**
 * Game: pick a card. Prompts the user to enter a number in the range [1, 52]. That number denotes the related rank and
 * suit of the card. The program finds and displays the equivalent description of the selected card number according to
 * the following:
 * rank: Ace, Two, Three, Four, Five, Six, seven, eight, nine, Jack, Queen, King
 */
public class Exercise3_24 {
  
  public static void main(String[] args) {
    Scanner input =  new Scanner(System.in);
    int cardNumber;
    
    System.out.print("Choose a card from deck (1-52): ");
    cardNumber = input.nextInt();
    input.close();
    
    if (cardNumber >= 1 && cardNumber <= 52) {
      int rank = (cardNumber - 1) / 4;
      int suit = (cardNumber - 1) % 4;
      
      String rankStr = switch (rank) {
        case 0 -> "Ace";
        case 1 -> "Two";
        case 2 -> "Three";
        case 3 -> "Four";
        case 4 -> "Five";
        case 5 -> "Six";
        case 6 -> "Seven";
        case 7 -> "Eight";
        case 8 -> "Nine";
        case 9 -> "Ten";
        case 10 -> "Jack";
        case 11 -> "Queen";
        case 12 -> "King";
        default -> throw new IllegalStateException("Invalid rank " + rank);
      };
      String suitStr = switch (suit) {
        case 0 -> "Clubs";
        case 1 -> "Diamonds";
        case 2 -> "Hearts";
        case 3 -> "Spades";
        default -> throw new IllegalStateException("Invalid suit " + suit);
      };
      System.out.printf("The card you picked is %s of %s\n", rankStr, suitStr);
    }
    else {
      System.out.println("Invalid card number");
    }
  }
  
}
