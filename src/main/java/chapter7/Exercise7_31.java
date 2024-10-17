package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prompts the user to enter two sorted lists. The program merges these lists and displays the sorted merged list. The
 * method must be implemented in a way that takes at most list1.length + list2.length comparisons.
 */
public class Exercise7_31 {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] list1 = readListInfo(input);
    int[] list2 = readListInfo(input);
    input.close();
    
    int[] mergedList = merge(list1, list2);
    System.out.println(Arrays.toString(mergedList));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] readListInfo(Scanner scanner) {
    int size;
    
    do {
      System.out.print("Enter list size and contents: ");
      size = scanner.nextInt();
      if (size <= 0) System.out.printf("Invalid list size '%d'\n", size);
    } while (size <= 0);
    
    int[] list = new int[size];
    for (int i = 0; i < size; i++) {
      list[i] = scanner.nextInt();
    }
    return list;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] merge(int[] list1, int[] list2) {
    if (list1[list1.length - 1] <= list2[0]) {
      return copy(list1, list2);
    }
    else if (list2[list2.length - 1] <= list1[0]) {
      return copy(list2, list1);
    }
    else {
      int index1 = 0;
      int index2 = 0;
      int index = 0;
      int[] newList = new int[list1.length + list2.length];
      
      while (index < list1.length + list2.length) {
        if (index1 == list1.length) {
          System.arraycopy(list2, index2, newList, index, list2.length - index2);
          break;
        }
        else if (index2 == list2.length) {
          System.arraycopy(list1, index1, newList, index, list1.length - index1);
          break;
        }
        
        // copy from list1
        if (list1[index1] < list2[index2]) {
          newList[index] = list1[index1];
          index1++;
        } // copy from both lists
        else if (list1[index1] == list2[index2]) {
          newList[index] = list1[index1];
          index1++;
          index++;
          newList[index] = list2[index2];
          index2++;
        } // copy from list2
        else if (list1[index1] > list2[index2]) {
          newList[index] = list2[index2];
          index2++;
        }
        index++;
      }
      return newList;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] copy(int[] list1, int[] list2) {
    int[] newList = new int[list1.length + list2.length];
    
    System.arraycopy(list1, 0, newList, 0, list1.length);
    System.arraycopy(list2, 0, newList, list1.length, list2.length);
    return newList;
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
