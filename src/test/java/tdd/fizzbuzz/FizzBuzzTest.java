package tdd.fizzbuzz;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {

  @Test
  public void test() {
    assertEquals("1", FizzBuzz.result(1));
  }

  @Test
  public void fizz() {
    assertEquals("Fizz", FizzBuzz.result(3));
  }

  @Test
  public void buzz() {
    assertEquals("Buzz", FizzBuzz.result(5));
  }

  @Test
  public void fizzbuzz() {
    assertEquals("FizzBuzz", FizzBuzz.result(15));
  }
}
