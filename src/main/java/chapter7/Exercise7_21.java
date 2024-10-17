package chapter7;

/**
 * The program passes an unspecified number of integers from command line and displays their total.
 */
public class Exercise7_21 {
  
  public static void main(String[] args) {
    if (args.length > 0) {
      int sum = 0;
      for (String arg : args) {
        sum += Integer.parseInt(arg);
      }
      System.out.println("Sum = " + sum);
      
      // calculate sum using streams
//      sum = Arrays
//              .stream(args)
//              .mapToInt(s -> Integer.parseInt(s))
//              .sum();
//      System.out.println("Sum = " + sum);
      
//      sum = Arrays
//          .stream(args)
//          .mapToInt(s -> Integer.parseInt(s))
//          .reduce(0, Integer::sum);
//      System.out.println("Sum = " + sum);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
