package tdd.leapyear;

public class LeapYear {

  public static boolean isLeapYear(int year) {
    
    if (isDivided(year, 400) || (isDivided(year, 4) && !isDivided(year, 100))) {
      return true;
    }
    else {
      return false;      
    }
  }
  
  public static boolean isDivided(int year, int num) {
    return year % num == 0;
  }
}
