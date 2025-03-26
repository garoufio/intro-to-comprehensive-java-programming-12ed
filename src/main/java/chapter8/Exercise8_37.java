package chapter8;

import java.util.Scanner;

/**
 * (Guess the capitals) The program repeatedly prompts the user to enter a capital for a state. Upon receiving the user
 * input, the program reports whether the answer is correct. Assume that 50 states and their capitals are stored in a
 * two-dimensional array. The program prompts the user to answer all states’ capitals and displays the total correct
 * count. The user’s answer is not case-sensitive.
 */
public class Exercise8_37 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String[][] stateCapitals = createStateCapitals();
      guessCapitals(stateCapitals, sc);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String[][] createStateCapitals() {
    return new String[][] {
        { "Alabama", "Montgomery" },      { "Alaska", "Juneau" },           { "Arizona", "Phoenix" },
        { "Arkansas", "Little Rock" },    { "California", "Sacramento" },   { "Colorado", "Denver" },
        { "Connecticut", "Hartford" },    { "Delaware", "Dover" },          { "Florida", "Tallahassee" },
        { "Georgia", "Atlanta" },         { "Hawaii", "Honolulu" },         { "Idaho", "Boise" },
        { "Illinois", "Springfield" },    { "Indiana", "Indianapolis" },    { "Iowa", "Des Moines" },
        { "Kansas", "Topeka" },           { "Kentucky", "Frankfort" },      { "Louisiana", "Baton Rouge" },
        { "Maine", "Augusta" },           { "Maryland", "Annapolis" },      { "Massachusetts", "Boston" },
        { "Michigan", "Lansing" },        { "Minnesota", "Saint Paul" },    { "Mississippi", "Jackson" },
        { "Missouri", "Jefferson City" }, { "Montana", "Helena" },          { "Nebraska", "Lincoln" },
        { "Nevada", "Carson City" },      { "New Hampshire", "Concord" },   { "New Jersey", "Trenton" },
        { "New Mexico", "Santa Fe" },     { "New York", "Albany" },         { "North Carolina", "Raleigh" },
        { "North Dakota", "Bismarck" },   { "Ohio", "Columbus" },           { "Oklahoma", "Oklahoma City" },
        { "Oregon", "Salem" },            { "Pennsylvania", "Harrisburg" }, { "Rhode Island", "Providence" },
        { "South Carolina", "Columbia" }, { "South Dakota", "Pierre" },     { "Tennessee", "Nashville" },
        { "Texas", "Austin" },            { "Utah", "Salt Lake City" },     { "Vermont", "Montpelier" },
        { "Virginia", "Richmond" },       { "Washington", "Olympia" },      { "West Virginia", "Charleston" },
        { "Wisconsin", "Madison" },       { "Wyoming", "Cheyenne" }
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void guessCapitals(String[][] stateCapitals, Scanner sc) {
    String capital;
    int correct = 0;
    
    for (String[] stateCapital : stateCapitals) {
      System.out.printf("What is the capital of '%s'? ", stateCapital[0]);
      capital = sc.nextLine();
      if (capital.equalsIgnoreCase(stateCapital[1])) {
        correct++;
        System.out.println("Your answer is correct");
      }
      else {
        System.out.printf("The correct answer should be '%s'.\n", stateCapital[1]);
      }
    }
    System.out.printf("The correct count is '%d'", correct);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
