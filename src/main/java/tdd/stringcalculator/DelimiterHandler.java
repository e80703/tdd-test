package tdd.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterHandler {

  private static final String REGEX_KEYWORD_OR = "|";
  private static final String PREDEFINED_DELIMITER = ",|\n";
  private static final String REGEX_DEFINED_PATTERN = "^//((.)|(\\[(.+?)\\])+)\n(.*)";
  private static final String REGEX_DEFINED_MULTIPLE_CHARACTER_PATTERN = "\\[(.+?)\\]";
  private static final int DEFINED_DELIMITERS_GROUP = 1;
  private static final int DEFINED_ONE_CHARACTER_DELIMITER_GROUP = 1;
  private static final int DEFINED_SINGLE_CHARACTER_DELIMITER_GROUP = 2;
  private static final int REGEX_GROUP_NUMBER_OF_NUMBER_STRING = 5;
  
  public String getNumberString(String numbers) {
    Matcher matcher = Pattern.compile(REGEX_DEFINED_PATTERN).matcher(numbers);
    if (matcher.find()) {
      return matcher.group(REGEX_GROUP_NUMBER_OF_NUMBER_STRING);
    }
    else {
      return numbers;
    }
  }

  public String getDelimiter(String numbers) {
    Matcher matcher = Pattern.compile(REGEX_DEFINED_PATTERN).matcher(numbers);
    String delimiter = PREDEFINED_DELIMITER;
    if (matcher.find()) {
      return getUserDelimiter(matcher);
    }
    else {
      return delimiter;
    }
  }

  private String getUserDelimiter(Matcher matcher) {
    if (isSingleCharacterDelimiter(matcher)) {
      return getSingleDelimiter(matcher);     
    }
    else {
      return getMultipleDelimiter(matcher);
    }
  }

  private String getMultipleDelimiter(Matcher matcher) {
    String delimiter = matcher.group(DEFINED_DELIMITERS_GROUP);
    Matcher delimiterMatcher = Pattern.compile(REGEX_DEFINED_MULTIPLE_CHARACTER_PATTERN).matcher(delimiter);
    StringBuilder delimiters = new StringBuilder();
    while (delimiterMatcher.find()) {
      addDelimiter(delimiters, delimiterMatcher.group(DEFINED_ONE_CHARACTER_DELIMITER_GROUP));
    }
    return delimiters.toString();
  }

  private void addDelimiter(StringBuilder delimiters, String delimiter) {
    if (delimiters.length() == 0) {
      delimiters.append(quote(delimiter));
    }
    else {
      delimiters.append(REGEX_KEYWORD_OR + quote(delimiter));
    }
  }

  private String quote(String delimiter) {
    return Pattern.quote(delimiter);
  }

  private String getSingleDelimiter(Matcher matcher) {
    return quote(matcher.group(DEFINED_SINGLE_CHARACTER_DELIMITER_GROUP));
  }

  private boolean isSingleCharacterDelimiter(Matcher matcher) {
    return matcher.group(DEFINED_SINGLE_CHARACTER_DELIMITER_GROUP) != null;
  }
}
