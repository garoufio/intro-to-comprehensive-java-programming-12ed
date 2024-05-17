package chapter2;

public class ShowCurrentTime {
  
  public static void main(String[] args) {
    long totalMiliseconds = System.currentTimeMillis();
    
    long totalSeconds = totalMiliseconds / 1000;
    long currentSeconds = totalSeconds % 60;
    long totalMinutes = totalSeconds / 60;
    long currentMinutes = totalMinutes % 60;
    long totalHours = totalMinutes / 60;
    long currentHours = totalHours % 24;
    
    System.out.printf("Current time (GMT) is '%02d:%02d:%02d'\n", currentHours, currentMinutes, currentSeconds);
  }
  
}
