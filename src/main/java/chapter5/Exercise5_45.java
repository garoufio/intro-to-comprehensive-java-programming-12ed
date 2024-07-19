package chapter5;

import java.util.Scanner;

public class Exercise5_45 {
  
  public static void main(String[] args) {
    double number;
    double sum = 0, sum2 = 0;
    int count = 0;
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter 10 numbers (> 0):\n");
    do {
      number = input.nextDouble();
      sum += number;
      sum2 += Math.pow(number, 2);
      count++;
    } while (count < 10);
    input.close();
    
    double mean = sum / count;
    //double deviation = Math.sqrt((sum2 - (Math.pow(sum, 2) / count) / (count - 1)));
    double deviation = Math.sqrt((sum2 / count) - Math.pow(mean, 2));
    
    System.out.printf("The mean is '%.2f'\n", mean);
    System.out.printf("The standard deviation is '%.2f'\n", deviation);
  }
  
}
