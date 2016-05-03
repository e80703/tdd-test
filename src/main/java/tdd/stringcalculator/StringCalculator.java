package tdd.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
  
  private static final int IGNORE_NUMBER_UPPER_BOUNDRY = 1000;
  private static final String SPACE = " ";
  private static final String NEGATIVE_MESSAGE = "negative not allowed";
  private static final String PREDEFINED_DELIMITER = ",|\n";
  private static final int REGEX_GROUP_NUMBER_OF_NUMBER_STRING = 2;
  private static final int REGEX_GROUP_NUMBER_OF_DEFINED_DELIMITER = 1;
  private static final String REGEX_DEFINED_PATTERN = "//(.)\n(.*)";

  public int add(String numbers) {
    Matcher matcher = Pattern.compile(REGEX_DEFINED_PATTERN).matcher(numbers);
    String delimiter = getDelimiter(matcher);
    String numberString = getNumberString(numbers, matcher.reset());
    return getSum(getNumbers(numberString, delimiter));
  }

  private String getNumberString(String numbers, Matcher matcher) {
    if (matcher.find()) {
      return matcher.group(REGEX_GROUP_NUMBER_OF_NUMBER_STRING);
    }
    else {
      return numbers;
    }
  }

  private String getDelimiter(Matcher matcher) {
    String delimiter = PREDEFINED_DELIMITER;
    if (matcher.find()) {
      return  Pattern.quote(matcher.group(REGEX_GROUP_NUMBER_OF_DEFINED_DELIMITER));
    }
    else {
      return delimiter;
    }
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
