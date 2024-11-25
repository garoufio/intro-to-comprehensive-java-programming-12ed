package chapter8;

import chapter7.ArraySort;

import java.util.Arrays;

/**
 * (Compute the weekly hours for each employee) The program displays employees and their total hours in decreasing
 * order of the total hours. Suppose the weekly hours for all employees are stored in a two-dimensional array. Each
 * row records an employee’s seven-day work hours with seven columns.
 */
public class Exercise8_4 {
  
  public static void main(String[] args) {
    int[][] employeesDailyHours = {
        { 2, 4, 3, 4, 5, 8, 8 },
        { 7, 3, 4, 3, 3, 4, 4 },
        { 3, 3, 4, 3, 3, 2, 2 },
        { 9, 3, 4, 7, 3, 4, 1 },
        { 3, 5, 4, 3, 6, 3, 8 },
        { 3, 4, 4, 6, 3, 4, 4 },
        { 3, 7, 4, 8, 3, 8, 4 },
        { 6, 3, 5, 9, 2, 7, 9 }
    };
    
    int[] weeklyHours = sortArray(getEmployeesWeeklyHours(employeesDailyHours));
    printEmployeesWeeklyHours(weeklyHours);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] getEmployeesWeeklyHours(int[][] dailyHours) {
    if (dailyHours == null) return null;
    
    int[] weeklyHours = new int[dailyHours.length];
    for (int i = 0; i < dailyHours.length; i++) {
      for (int j = 0; j < dailyHours[i].length; j++) {
        weeklyHours[i] += dailyHours[i][j];
      }
    }
    return weeklyHours;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] sortArray(int[] array) {
    if (array == null) return null;
    
    int[] sortedArray = Arrays.copyOf(array, array.length);
    ArraySort.selectionSort(sortedArray, false);
    return sortedArray;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printEmployeesWeeklyHours(int[] weeklyHours) {
    for (int i = 0; i < weeklyHours.length; i++) {
      System.out.printf("Employee '%d' works '%d' hours per week\n", i, weeklyHours[i]);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
