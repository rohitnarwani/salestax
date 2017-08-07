package com.salestax.service.impl;

import java.math.BigDecimal;

import com.salestax.service.TaxCalculator;

/**
 * Class for calculating salesTax
 * 
 * @author rohit
 *
 */
public class SalesTaxCalculator implements TaxCalculator {

	@Override
	public BigDecimal calculateTaxes(BigDecimal price) {
		final BigDecimal tax = price.multiply(new BigDecimal(0.1));
		final BigDecimal rounded = round(tax);
		return rounded;
	}

}
