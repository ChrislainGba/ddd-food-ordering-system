package com.xl1.ddd.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money{
	private final BigDecimal amount;
	
	public Money(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(amount, other.amount);
	}
	
	public boolean isGreaterThanZero() {
		return amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
	}
	
	public boolean isGreaterThan(Money money) {
		return amount != null && this.amount.compareTo(money.getAmount()) > 0;
	}
	
	public Money add(Money money) {
		return new Money(this.amount.add(money.getAmount()));
	}
	
	public Money substruct(Money money) {
		return new Money(setScale(this.amount.subtract(money.getAmount())));
	}
	
	public Money multiply(int multiplier) {
		return new Money(setScale(this.amount.multiply(new BigDecimal(multiplier))));
	}
	//care abourt precision
	//with scale 2 the number of digits after decimal point is 2 e.g: 10.04
	private BigDecimal setScale(BigDecimal input) {
		return input.setScale(2, RoundingMode.HALF_EVEN);
	}
	
	public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }
	
}
