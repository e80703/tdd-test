package tdd.oddeven;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OddEvenTest {
  private OddEven oddEven;

  @Before
  public void setup() {
    oddEven = new OddEven();
  }
  
  @Test
  public void one() {
    assertEquals("1", oddEven.result(1));
  }

  @Test
  public void two() {
    assertEquals("2", oddEven.result(2));
  }  

  @Test
  public void three() {
    assertEquals("3", oddEven.result(3));
  }

  @Test
  public void four() {
    assertEquals("Even", oddEven.result(4));
  }

  @Test
  public void five() {
    assertEquals("5", oddEven.result(5));
  }

  @Test
  public void six() {
    assertEquals("Even", oddEven.result(6));
  }

  @Test
  public void seven() {
    assertEquals("7", oddEven.result(7));
  }

  @Test
  public void eight() {
    assertEquals("Even", oddEven.result(8));
  }

  @Test
  public void nine() {
    assertEquals("Odd", oddEven.result(9));
  }


}
