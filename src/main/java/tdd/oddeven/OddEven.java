package tdd.oddeven;

public class OddEven {

  private static final String MESSAGE_ODD = "Odd";
  private static final String MESSAGE_EVEN = "Even";

  public String result(int number) {
    
    if (isPrime(number)) {
      if (isEven(number)) {
        return MESSAGE_EVEN;
      }
      else {
        return MESSAGE_ODD;
      }
    }
    else {
      return returnNum(number);
    }
  }

  public String returnNum(int number) {
    return String.valueOf(number);
  }

  public boolean isEven(int number) {
    return number % 2 == 0;
  }

  public boolean isPrime(int number) {
    int count = 0;
    
    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        count++;
      }
    }
    return count > 2;
  }

}
