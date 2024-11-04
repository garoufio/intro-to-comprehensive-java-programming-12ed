package chapter7;

/**
 * Implementation of binary search and linear search algorithms.
 */
public class ArraySearch {
  
  public static void main(String[] args) {
    // linear search
    int[] list1 = { 1, 4, 4, 2, 5, -3, 6, 2 };
    System.out.println("-- Linear search --");
    System.out.println(linearSearch(list1, 4));
    System.out.println(linearSearch(list1, -4));
    System.out.println(linearSearch(list1, 11));
    
    // binary search
    int[] list2 = { 2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79 };
    System.out.println("-- Binary search --");
    System.out.println(binarySearch(list2, 2));
    System.out.println(binarySearch(list2, 11));
    System.out.println(binarySearch(list2, 12));
    System.out.println(binarySearch(list2, 1));
    System.out.println(binarySearch(list2, 3));
    System.out.println(binarySearch(list2, -6));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int linearSearch(int[] arr, int key) {
    if (arr == null) return -1;
    
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key) return i;
    }
    return -1;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int binarySearch(int[] arr, int key) {
    if (arr == null) return -1;
    
    int low = 0;
    int high = arr.length - 1;
    int mid;
    
    while (low <= high) {
      mid = (low + high) / 2;
      
      if (arr[mid] == key) {
        return mid;
      }
      else if (arr[mid] < key) {
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    return -low - 1;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
