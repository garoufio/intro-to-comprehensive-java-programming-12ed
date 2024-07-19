package chapter5;

/**
 * Reads integers, finds the largest of them, and counts its occurrences. Assume the input ends with number 0.
 */
public class Exercise5_41 {
  
  public static void main(String[] args) {
    if (args.length > 0) {
      int number = 0;
      int max = 0, count = 1;
      boolean init = false;
      
      for (int i = 0; i < args.length; i++) {
        if (args[i].matches("-?\\d+")) {
          number = Integer.parseInt(args[i]);
          if (number == 0) break;
          
          if (init == false) {
            max = number;
            count = 1;
            init = true;
            continue;
          }
          
          if (number > max) {
            max = number;
            count = 1;
          }
          else if (number == max) {
            count++;
          }
        }
      }
      
      System.out.printf("Max number is '%d' and occurred '%d' times\n", max, count);
    }
    else {
      System.out.println("No arguments given");
    }
  }
  
}
