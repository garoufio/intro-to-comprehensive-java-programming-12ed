package chapter7;

/**
 * Game: locker puzzle.
 */
public class Exercise7_23 {
  
  public static final int NUMBER_OF_STUDENTS = 100;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    boolean[] lockers = new boolean[NUMBER_OF_STUDENTS];
    
    play(lockers);
    printOpenLockers(lockers);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void play(boolean[] lockers) {
    changeLockerState(lockers, 0, 1, true, true);
    changeLockerState(lockers, 1, 1, true, false);
    for (int i = 2; i < lockers.length; i++) {
      changeLockerState(lockers, i, i + 1, false, false);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void changeLockerState(
      boolean[] lockers,
      int fromIndex,
      int step,
      boolean changeAllStates,
      boolean setAllStatesTo
  ) {
    for (int i = fromIndex; i < lockers.length; i += step) {
      if (changeAllStates) {
        lockers[i] = setAllStatesTo;
      }
      else {
        lockers[i] = lockers[i] ? false : true;
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printOpenLockers(boolean[] lockers) {
    for (int i = 0; i < lockers.length; i++) {
      if (lockers[i]) {
        System.out.printf("L%d ", i + 1);
      }
    }
    System.out.println();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
