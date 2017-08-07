package com.salestax.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for creating the order.
 * 
 * @author rohit
 *
 */
public class Order {

	private final List<OrderedItem> orderedItemList = new ArrayList<>();
	private final List<TaxOnOrderedItem> taxOnOrderedItemList = new ArrayList<>();

	/**
	 * This method will add all the items with the respective quantities into
	 * orderedItemList and taxOnOrderedItemList
	 * 
	 * @param item
	 * @param quantity
	 */
	public void add(Item item, int quantity) {
		OrderedItem orderedItem = OrderedItem.getOrderedItem(item,
				item.getPrice(), quantity);
		orderedItemList.add(orderedItem);
		taxOnOrderedItemList.add(TaxOnOrderedItem.getTaxOnOrderedItem(
				orderedItem, item.getPrice()));
	}

	/**
	 * To get total tax on the basis of taxOnOrderedItemList
	 * 
	 * @param taxOnOrderedItemList
	 * @return
	 */
	private BigDecimal getTaxTotal(List<TaxOnOrderedItem> taxOnOrderedItemList) {
		BigDecimal total = new BigDecimal("0.00");
		for (TaxOnOrderedItem taxOnOrderedItem : taxOnOrderedItemList) {
			total = total.add(taxOnOrderedItem.getSalesTaxAmount());
		}
		return total;
	}

	/**
	 * To get total of Ordered Items
	 * 
	 * @param orderedItems
	 * @return
	 */
	private BigDecimal getSubTotal(List<OrderedItem> orderedItems) {
		BigDecimal total = new BigDecimal("0.00");
		for (OrderedItem items : orderedItems) {
			total = total.add(items.getTotalAmount());
		}
		return total;
	}

	/**
	 * Sub Total
	 * 
	 * @return
	 */
	public BigDecimal getSubTotal() {
		return getSubTotal(orderedItemList).setScale(2,
				BigDecimal.ROUND_HALF_EVEN);
	}

	/**
	 * Tax Total
	 * 
	 * @return
	 */
	public BigDecimal getTaxTotal() {
		return getTaxTotal(taxOnOrderedItemList).setScale(2,
				BigDecimal.ROUND_HALF_EVEN);
	}

	/**
	 * Total Amount with Tax
	 * 
	 * @return
	 */
	public BigDecimal getTotal() {
		return getSubTotal().add(getTaxTotal()).setScale(2,
				BigDecimal.ROUND_HALF_EVEN);
	}

	/**
	 * Method to print Receipt
	 * 
	 * @param receipt
	 */
	public void print(Receipt receipt) {
		for (OrderedItem orderedItem : orderedItemList) {
			receipt.printProduct(orderedItem);
		}
		for (TaxOnOrderedItem taxOnOrderedItem : taxOnOrderedItemList) {
			receipt.printSalesTax(taxOnOrderedItem);
		}
		receipt.printTotal(getTotal());

	}

}