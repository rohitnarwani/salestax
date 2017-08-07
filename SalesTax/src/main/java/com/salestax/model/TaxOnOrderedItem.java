package com.salestax.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.salestax.service.TaxCalculator;
import com.salestax.service.impl.ImportedTaxCalculator;
import com.salestax.service.impl.SalesTaxCalculator;

/**
 * This class is used for storing tax on items ordered by the customer.
 * 
 * @author rohit
 *
 */
public class TaxOnOrderedItem {

	private final OrderedItem orderedItem;
	private final List<TaxCalculator> taxCalculators = new ArrayList<>();
	private final BigDecimal amount;

	private TaxOnOrderedItem(OrderedItem orderedItem, BigDecimal amount) {
		this.orderedItem = orderedItem;
		this.amount = amount;
		addTax(orderedItem);
	}

	/**
	 * @return the orderedItem
	 */
	public OrderedItem getOrderedItem() {
		return orderedItem;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @return SalesTaxAmount
	 */
	public BigDecimal getSalesTaxAmount() {
		BigDecimal taxAmount = new BigDecimal(0);
		for (TaxCalculator taxCalculator : taxCalculators) {
			taxAmount = taxAmount.add(taxCalculator.calculateTaxes(orderedItem
					.getPrice()));
		}
		return taxAmount;
	}

	/**
	 * @param orderedItem
	 */
	private void addTax(OrderedItem orderedItem) {

		if (orderedItem.getItem().getItemOrigin().equals(ItemOrigin.IMPORTED)) {
			taxCalculators.add(new ImportedTaxCalculator());
		}
		if (!orderedItem.getItem().getItemType().isExempted()) {
			taxCalculators.add(new SalesTaxCalculator());
		}

	}

	/**
	 * @param orderedItem
	 * @param amount
	 * @return
	 */
	public static TaxOnOrderedItem getTaxOnOrderedItem(OrderedItem orderedItem,
			BigDecimal amount) {
		return new TaxOnOrderedItem(orderedItem, amount);
	}
}
