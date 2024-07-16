package chapter4;

public class Exercise4_3 {
  
  public static void main(String[] args) {
    Runtime runtime = Runtime.getRuntime();
    System.out.println("Max memory: " + runtime.maxMemory());
    System.out.println("Total memory: " + runtime.totalMemory());
  }
  
}
