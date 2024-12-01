package chapter32;

import java.util.Arrays;
import java.util.concurrent.*;

public class Test {
  
  public static void main(String[] args) {
    int[] arr = new int[10];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }

    for (int a : arr) {
      a *= 2;
    }
    Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

    System.out.println();
    for (int i = 0; i < arr.length; i++) {
      arr[i] *= 2;
    }
    Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

    int[] newArr = new int[arr.length];
    System.arraycopy(arr, 0, newArr, 0, arr.length);
    System.out.println("\nNew array:");
    Arrays.stream(newArr).forEach(a -> System.out.print(a + " "));
    
    System.out.println();
    Runnable task = () -> {
      System.out.println("Thread executing " + Thread.currentThread().threadId());
    };
    Thread thread1 = new Thread(task);
    Thread thread2 = new Thread(task);
    thread1.start();
    thread2.start();
    
    System.out.println("Executor - Future/Callable");
    ExecutorService executor = Executors.newFixedThreadPool(5);
    Callable<Integer> newtask = () -> {
      Thread.sleep(5000);
      return 120;
    };
    
    Future<Integer> future = executor.submit(newtask);
    try {
      Integer result = future.get();
      System.out.println(result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();
    }
  }
  
}
