package tdd.renthouse;

import java.math.BigDecimal;

public class House {
  private BigDecimal ping;
  private Region region;

  public House(BigDecimal ping, Region region) {
    this.ping = ping;
    this.region = region;
  }

  public int rent(Tenant normal) {
    
    return ping.multiply(region.getPrice()).multiply(normal.getDiscount())
               .setScale(1, BigDecimal.ROUND_HALF_UP).intValue();
  }
  
}
