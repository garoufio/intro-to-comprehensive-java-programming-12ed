package chapter5;

/**
 * It computes the following summation: 1/3 + 3/5 + 5/7 + 7/9 + 9/11 + ... + 95/97 + 97/99 and displays the result.
 */
public class Exercise5_24 {
  
  public static void main(String[] args) {
    double sum = 0;
    
    for (int i = 1; i <= 97; i += 2) {
      sum += i / (i + 2.0);
    }
    System.out.println("The result is: " + sum);
  }
  
}
