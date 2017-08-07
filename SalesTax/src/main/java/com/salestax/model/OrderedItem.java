package com.salestax.model;

import java.math.BigDecimal;

/**
 * This class is used to maintain the item bought by the customer,
 * 
 * @author rohit
 *
 */
public class OrderedItem {

	private final BigDecimal price;
	private final Item item;
	private final int quantity;

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return TotalAmount
	 */
	public BigDecimal getTotalAmount() {
		return price.multiply(new BigDecimal(quantity));
	}

	private OrderedItem(Item item, BigDecimal price, int quantity) {
		this.item = item;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * @param item
	 * @param price
	 * @param quantity
	 * @return
	 */
	public static OrderedItem getOrderedItem(Item item, BigDecimal price,
			int quantity) {
		return new OrderedItem(item, price, quantity);
	}

}
