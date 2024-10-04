package chapter7;

import java.util.Arrays;

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
    
  }

}
