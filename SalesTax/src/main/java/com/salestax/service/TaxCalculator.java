package com.salestax.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Interfaces for calculating tax
 * 
 * @author rohit
 *
 */
public interface TaxCalculator {

	/**
	 * To calculate Tax
	 * 
	 * @param price
	 * @return
	 */
	public BigDecimal calculateTaxes(BigDecimal price);

	/**
	 * For rounding the value
	 * 
	 * @param value
	 * @return
	 */
	default BigDecimal round(BigDecimal value) {
		value = value.multiply(new BigDecimal("20"))
				.setScale(0, RoundingMode.UP).setScale(2);
		value = value.divide(new BigDecimal("20"), RoundingMode.UP);
		return value;
	}
}
