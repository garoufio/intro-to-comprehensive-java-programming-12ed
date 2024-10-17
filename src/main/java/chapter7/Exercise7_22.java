package chapter7;

/**
 *  The program passes a string to the command line and displays the number of uppercase letters in the string.
 */
public class Exercise7_22 {
  
  public static void main(String[] args) {
    if (args.length > 0) {
      int countUpperCaseLetters = 0;
      String str = args[0];
      char[] array = str.toCharArray();
      
      for (char c : array) {
        if (c >= 'A' && c <= 'Z') countUpperCaseLetters++;
      }
      System.out.printf("The number of upper case letters in '%s' is '%d'\n", str, countUpperCaseLetters);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
