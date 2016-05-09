package tdd.leapyear;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeapYearTest {

  @Test
  public void leap_1600() {
    assertTrue(LeapYear.isLeapYear(1988));
  }

  @Test
  public void leap_1700() {
    assertFalse(LeapYear.isLeapYear(1700));
  }

  @Test
  public void leap_2000() {
    assertTrue(LeapYear.isLeapYear(2000));
  }

  @Test
  public void leap_1991() {
    assertFalse(LeapYear.isLeapYear(1991));
  }
}
