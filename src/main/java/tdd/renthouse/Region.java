package tdd.renthouse;

import java.math.BigDecimal;

public class Region {
  private BigDecimal price;
  private String name;
  
  public Region(String name, BigDecimal price) {
    this.price = price;
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

}
