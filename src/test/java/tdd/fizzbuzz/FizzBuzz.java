package tdd.fizzbuzz;

public class FizzBuzz {

  public static String result(int num) {
    if (isDividedOfThree(num) && isDividedOfFive(num)) {
      return "FizzBuzz";
    }
    else if (isDividedOfFive(num)) {
      return "Buzz";
    }
    else if (isDividedOfThree(num)) {
      return "Fizz";
    }
    else {
      return String.valueOf(num);
    }
  }

  private static boolean isDividedOfThree(int num) {
    return num % 3 == 0;
  }

  private static boolean isDividedOfFive(int num) {
    return num % 5 == 0;
  }

}
