package chapter8;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (Financial tsunami) Banks lend money to each other. In tough economic times, if a bank goes bankrupt, it may not be
 * able to pay back the loan. A bank’s total assets are its current balance plus its loans to other banks. If a bank’s
 * total assets are under a certain limit, the bank is unsafe. The money it borrowed cannot be returned to the lender,
 * and the lender cannot count the loan in its total assets. Consequently, the lender may also be unsafe, if its total
 * assets are under the limit. Write a program to find all the unsafe banks. Your program reads the input as follows:
 *    1) Reads two integers n and limit, where n indicates the number of banks and limit is the minimum total assets
 *       for keeping a bank safe.
 *    2) Reads n lines that describe the information for n banks with IDs from 0 to n−1. The first number in the line
 *       is the bank’s balance, the second number indicates the number of banks that borrowed money from the bank, and
 *       the rest are pairs of two numbers. Each pair describes a borrower. The first number in the pair is the
 *       borrower’s ID and the second is the amount borrowed.
 */
public class Exercise8_17 {
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int numberOfBanks = readNumberOfBanks(sc, "Enter number of banks: ");
      double safeBalanceLimit = readAmount(sc, "Enter safe balance limit: ");
      double[][] loanData = readLoans(sc, numberOfBanks);
      int[] unsafeBanks = findUnsafeBanks(loanData, safeBalanceLimit);
      
      printArray(unsafeBanks, "Unsafe banks are: ");
    }
    catch (InputMismatchException e) {
      System.err.println("Invalid input: " + e.getMessage());
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  // Validations
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean validateNumberOfBanks(int numberOfBanks) {
    if (numberOfBanks <= 0) {
      System.out.printf("Invalid number of banks '%d'. Number of banks must be greater than '0'.\n", numberOfBanks);
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean validateAmount(double amount) {
    if (amount <= 0) {
      System.out.printf("Invalid amount '%.2f'. Amount must be greater than '0'.\n", amount);
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static boolean validateBankID(int bankID, int currentBankID, int numberOfBanks) {
    if (bankID < 0 || bankID >= numberOfBanks || bankID == currentBankID) {
      System.out.printf(
          "Invalid bank ID '%d'. It must be in the range [0, %d], excluding '%d'\n",
          bankID, numberOfBanks - 1, currentBankID
      );
      return false;
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  // Parse input
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int readNumberOfBanks(Scanner sc, String msg) {
    int numberOfBanks;
    do {
      System.out.print(msg);
      numberOfBanks = sc.nextInt();
    } while (!validateNumberOfBanks(numberOfBanks));
    sc.nextLine();
    
    return numberOfBanks;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double readAmount(Scanner sc, String msg) {
    double amount;
    do {
      System.out.print(msg);
      amount = sc.nextDouble();
    } while (!validateAmount(amount));
    sc.nextLine();
    
    return amount;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double readBankID(Scanner sc, String msg, int currentBankID, int numberOfBanks) {
    double bankID;
    
    do {
      System.out.print(msg);
      bankID = sc.nextDouble();
    } while (!validateBankID((int)bankID, currentBankID, numberOfBanks));
    
    return bankID;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[][] readLoans(Scanner sc, int numberOfBanks) {
    double[][] data = new double[numberOfBanks][2 * numberOfBanks];
    int index;
    
    for (int i = 0; i < numberOfBanks; i++) {
      index = 2;
      System.out.print("Enter bank's current balance and the number of banks that borrowed money from this bank: ");
      data[i][0] = sc.nextDouble(); // bank's balance
      data[i][1] = sc.nextDouble(); // number of banks that borrowed money from this bank
      sc.nextLine();
      
      for (int j = 0; j < data[i][1]; j++, index += 2) {
        data[i][index] = readBankID(sc, "Enter bank ID: ", i, numberOfBanks); // bankID
        data[i][index + 1] = readAmount(sc, "Enter amount borrowed: "); // amount of money borrowed from this bank
      }
    }
    return data;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  // Helpers
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] truncateArray(int[] array, int delimiter) {
    int toIndex;
    for (toIndex = 0; toIndex < array.length; toIndex++) {
      if (array[toIndex] == delimiter) break;
    }
    return Arrays.copyOfRange(array, 0, toIndex);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeTotalAsset(double[] row) {
    double sum;
    
    sum = row[0];
    if (row[1] > 0) {
      for (int i = 3; i < row.length; i += 2) {
        sum += row[i];
      }
    }
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double computeTotalAsset(double[] row, int excludeBank) {
    double sum;
    
    sum = row[0];
    if (row[1] > 0) {
      for (int i = 3; i < row.length; i += 2) {
        if (row[i - 1] == excludeBank) continue;
        
        sum += row[i];
      }
    }
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static double[] computeTotalAssets(double[][] data) {
    if (data == null) return null;
    
    double[] assets = new double[data.length];
    int index = 0;
    for (double[] d : data) {
      assets[index] = computeTotalAsset(d);
      index++;
    }
    return assets;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] createBorrowers(double[][] data) {
    if (data == null) return null;
    
    int totalNumberOfBorrowers = 0;
    for (double[] d : data) {
      totalNumberOfBorrowers += (int) d[1];
    }
    
    int index = 0;
    int[][] borrowers = new int[totalNumberOfBorrowers][2];
    for (int i = 0; i < data.length; i++) {
      for (int j = 2, k = 0; j < data[i].length && k < data[i][1]; j += 2, k++) {
        borrowers[index][0] = i;  // lender
        borrowers[index][1] = (int)data[i][j];  // borrower
        index++;
      }
    }
    return borrowers;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] findUnsafeBanks(double[][] data, double limit) {
    if (data == null) return null;
    
    boolean isUnsafe;
    int[][] borrowers = createBorrowers(data);
    double[] assets = computeTotalAssets(data);
    
    int index = 0;
    int[] banks = new int[assets.length];
    Arrays.fill(banks, -1);
    
    do {
      isUnsafe = false;
      
      for (int i = 0; i < assets.length; i++) {
        boolean exists = false;
        // check if bank's asset is below safe limit
        if (assets[i] < limit) {
          // check if bank is already marked as unsafe
          for (int b : banks) {
            if (b == i) exists = true;
          }
          // if bank is already marked as unsafe, then ignore it
          if (exists) continue;
          else {
            isUnsafe = true;
            banks[index] = i;
            
            // compute new assets
            for (int j = 0; j < assets.length; j++) {
              assets[j] = computeTotalAsset(data[j], banks[index]);
            }
            index++;
          }
        }
      }
    } while (isUnsafe);
    
    // truncate array by removing -1 values and sorts the truncated array
    int[] sortedBanks = truncateArray(banks, -1);
    Arrays.sort(sortedBanks);
    return sortedBanks;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static void printArray(int[] array, String msg) {
    System.out.print(msg);
    for (int i = 0; i < array.length; i++) {
      if (array[i] == -1) break;
      
      System.out.print(array[i]);
      if (i != array.length - 1) System.out.println(" ");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
