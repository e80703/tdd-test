package tdd.renthouse;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class RentHouseTest {
  
  private House house;
  private Region region;
  
  @Before
  public void setup() {
    region = new Region("蘆洲", new BigDecimal(1000));
    house = new House(new BigDecimal(40), region);
  }
  
  @Test
  public void testRegion() {
    assertEquals(1000, region.getPrice().intValue());
    assertEquals("蘆洲", region.getName());    
  }
  
  @Test
  public void testRent() {
    assertEquals(40000, house.rent(Tenant.Normal));
    assertEquals(32000, house.rent(Tenant.Student));
    assertEquals(44444, house.rent(Tenant.Company));
  }

}
