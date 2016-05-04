package tdd.stringcalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

  private StringCalculator calculator;
  
  @Before
  public void setup() {
    calculator = new StringCalculator();
  }
  
  @Test
  public void emptyString() {
    assertEquals(0, calculator.add(""));
  }

  @Test
  public void return_this_number() {
    assertEquals(1, calculator.add("1"));
  }
  
  @Test
  public void return_two_number() {
    assertEquals(3, calculator.add("1,2"));
  }
  
  @Test
  public void return_two_number_space() {
    assertEquals(3, calculator.add("1, 2"));
  }
  
  @Test
  public void multiple_number() {
    assertEquals(10, calculator.add("1, 2,3, 4"));
  }
  
  @Test
  public void newline() {
    assertEquals(3, calculator.add("1\n2"));
  }
  
  @Test
  public void multiple_delimiter() {
    assertEquals(6, calculator.add("1\n2,3"));
  }
  
  @Test
  public void user_defined_delimiter() {
    assertEquals(3, calculator.add("//;\n1;2"));
  }
  
  @Test
  public void user_defined_delimiter_keyword() {
    assertEquals(3, calculator.add("//?\n1?2"));
  }
  
  @Rule
  public ExpectedException exceptionEx = ExpectedException.none();
  
  @Test
  public void negative_expection() {
    exceptionEx.expect(RuntimeException.class);
    exceptionEx.expectMessage("negative not allowed -1");
    assertEquals(exceptionEx, calculator.add("-1"));
  }
  
  @Test
  public void mulitple_negative_expection() {
    exceptionEx.expect(RuntimeException.class);
    exceptionEx.expectMessage("negative not allowed -1 -2 -3");
    assertEquals(exceptionEx, calculator.add("-1,-2,-3"));
  }
  
  @Test
  public void larger_than_1000() {
    assertEquals(2, calculator.add("2, 1001"));
  }
  
  @Test
  public void defined_delimiter_multiple_character() {
    assertEquals(3, calculator.add("//[***]\n1***2"));
  }
  
  @Test
  public void defined_multiple_delimiter_single_character() {
    assertEquals(6, calculator.add("//[*][?]\n1*2?3"));
  }
  
  @Test
  public void defined_multiple_delimiter_multiple_character() {
    assertEquals(6, calculator.add("//[***][???]\n1***2???3"));
  }
}
