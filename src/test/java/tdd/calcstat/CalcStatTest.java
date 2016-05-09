package tdd.calcstat;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalcStatTest {

  private CalcStat calcStat;

  @Before
  public void setup() {
    calcStat = new CalcStat();
  }
  
  @Test
  public void min() {
    assertEquals(-1, calcStat.getMin(new int[]{1, 30, 22, -1, 2}));
  }

  @Test
  public void max() {
    assertEquals(30, calcStat.getMax(new int[]{10, 30, 24, -30, 2}));
  }

  @Test
  public void average() {
    assertEquals(9, calcStat.getAverage(new int[]{10, 30, 26, -30}));
  }

  @Test
  public void size() {
    assertEquals(4, calcStat.getSize(new int[]{10, 30, 26, -30}));
  }
}
