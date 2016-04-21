package tdd.renthouse;

import java.math.BigDecimal;

public enum Tenant {
  Normal(new BigDecimal(1.0)), 
  Student(new BigDecimal(0.8)), 
  Company(new BigDecimal(10/9.));
  
  public final BigDecimal discount;
  
  Tenant(BigDecimal discount) {
    this.discount = discount;
  }

  public BigDecimal getDiscount() {
    return discount;
  }
  
  
}
