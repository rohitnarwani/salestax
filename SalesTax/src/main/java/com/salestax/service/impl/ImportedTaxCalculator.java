package com.salestax.service.impl;

import java.math.BigDecimal;

import com.salestax.service.TaxCalculator;

/**
 * Class for calculating imported Tax.
 * 
 * @author rohit
 *
 */
public class ImportedTaxCalculator implements TaxCalculator {

	@Override
	public BigDecimal calculateTaxes(BigDecimal price) {
		final BigDecimal tax = price.multiply(new BigDecimal(0.05));
		final BigDecimal rounded = round(tax);
		return rounded;
	}

}
