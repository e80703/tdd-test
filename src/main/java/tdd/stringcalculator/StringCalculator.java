package tdd.stringcalculator;


public class StringCalculator {

  private static final int IGNORE_NUMBER_UPPER_BOUNDRY = 1000;
  private static final String SPACE = " ";
  private static final String NEGATIVE_MESSAGE = "negative not allowed";

  public int add(String numbers) {
    DelimiterHandler delimiterHandler = new DelimiterHandler();
    String delimiter = delimiterHandler.getDelimiter(numbers);
    String numberString = delimiterHandler.getNumberString(numbers);
    return getSum(getNumbers(numberString, delimiter));
  }

  private String[] getNumbers(String numbers, String delimiter) {
    if (numbers.isEmpty()) {
      return new String[0];
    }
    else {
      return numbers.split(delimiter);
    }
  }

  private int getSum(String[] nums) {
    int sum = 0;
    StringBuilder error = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      sum += toInt(nums[i], error);
    }
    negativeExpection(error);
    return sum;
  }

  private void negativeExpection(StringBuilder error) {
    if (error.length() > 0) {
      throw new RuntimeException(NEGATIVE_MESSAGE + error);
    }
  }

  private int toInt(String number, StringBuilder error) {
    int num = Integer.parseInt(number.trim());
    if (num < 0) {
      error.append(SPACE + num);
    }
    return ignoreNumberUpperBoundry(num);
  }

  private int ignoreNumberUpperBoundry(int num) {
    if (num > IGNORE_NUMBER_UPPER_BOUNDRY) {
      return 0;
    }
    else {
      return num;
    }
  }
  
}
