package chapter8;

import java.util.Arrays;

/**
 * Sorts a two-dimensional array. Performs a primary sort on rows, and a secondary sort on columns.
 */
public class Exercise8_16 {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void main(String[] args) {
    int[][] array = new int[][]{
        {4, 2}, {1, 7}, {4, 5},
        {1, 2}, {1, 1}, {4, 1}
    };
    
    int[][] sortedArray = sort(array);
    printArray(sortedArray);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] sort(int m[][]) {
    int minIndex;
    int[] minElement;
    int[] temp;
    
    int[][] sortedArray = new int[m.length][m[0].length];
    System.arraycopy(m, 0, sortedArray, 0, m.length);
    
    for (int i = 0; i < m.length - 1; i++) {
      minIndex = i;
      minElement = sortedArray[i];
      for (int j = i + 1; j < m.length; j++) {
        if (sortedArray[j][0] < minElement[0] ||
            (sortedArray[j][0] == minElement[0] && sortedArray[j][1] < minElement[1])
        ) {
          minIndex = j;
          minElement = sortedArray[j];
        }
      }
      // swap
      if (minIndex != i) {
        temp = sortedArray[i];
        sortedArray[i] = minElement;
        sortedArray[minIndex] = temp;
      }
    }
    return sortedArray;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printArray(int m[][]) {
    for (int row[] : m) {
      System.out.println(Arrays.toString(row));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
