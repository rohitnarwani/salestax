package com.salestax.service.impl;

import java.math.BigDecimal;

import com.salestax.service.TaxCalculator;

/**
 * This class will return tax as 0 if no tax is there for an item
 * 
 * @author rohit
 *
 */
public class NoTaxCalculator implements TaxCalculator {

	@Override
	public BigDecimal calculateTaxes(BigDecimal price) {
		return new BigDecimal(0);
	}

}
