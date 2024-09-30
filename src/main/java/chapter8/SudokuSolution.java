package chapter8;

public class SudokuSolution {
  
  public static void main(String[] args) {
    int[][] solution1 = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };
    System.out.printf("Is solution1 valid? %b\n", isValidSolution(solution1));
    
    int[][] solution2 = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {2, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 5, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 6, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 5, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };
    System.out.printf("Is solution2 valid? %b\n", isValidSolution(solution2));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean isValidSolution(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return false;
    if (grid.length % 3 != 0) return false;
    
    return hasValidRows(grid) && hasValidColumns(grid) && hasValidCells(grid);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean isValidArray(int[] row) {
    for (int i = 0; i < row.length; i++) {
      if (!isValidNumber(row[i], 1, row.length)) return false;
      
      for (int j = i + 1; j < row.length; j++) {
        if (row[j] == row[i]) return false;
      }
    }
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean isValidNumber(int number, int min, int max) {
    return number >= min && number <= max;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean hasValidRows(int[][] grid) {
    for (int row = 0; row < grid.length; row++) {
      if (isValidArray(grid[row]) == false) return false;
    }
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean hasValidColumns(int[][] grid) {
    for (int col = 0; col < grid[0].length; col++) {
      for (int i = 0; i < grid.length; i++) {
        for (int j = i + 1; j < grid.length; j++) {
          if (grid[j][col] == grid[i][col]) return false;
        }
      }
    }
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean hasValidCells(int[][] grid) {
    int len = grid.length / 3;
    
    for (int columnCell = 0; columnCell < len; columnCell++) {
      for (int rowCell = 0; rowCell < len; rowCell++) {
        int[] cell = new int[grid.length];
        int index = 0;
        
        for (int row = rowCell * len; row < rowCell * len + 3; row++) {
          for (int column = columnCell * len; column < columnCell * len + 3; column++) {
            cell[index] = grid[row][column];
            index++;
          }
        }
        //System.out.println(Arrays.toString(cell));
        if (isValidArray(cell) == false) return false;
      }
    }
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
