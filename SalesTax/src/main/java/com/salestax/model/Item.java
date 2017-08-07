package com.salestax.model;

import java.math.BigDecimal;

/**
 * @author rohit
 *
 */
public class Item {

	private long itemId;
	private String name;
	private ItemOrigin itemOrigin;
	private BigDecimal price;
	private ItemType itemType;

	public Item(String name, ItemType itemType, ItemOrigin itemOrigin,
			BigDecimal price) {
		super();
		this.name = name;
		this.itemOrigin = itemOrigin;
		this.price = price;
		this.itemType = itemType;
	}

	/**
	 * @return the itemId
	 */
	public long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the itemOrigin
	 */
	public ItemOrigin getItemOrigin() {
		return itemOrigin;
	}

	/**
	 * @param itemOrigin
	 *            the itemOrigin to set
	 */
	public void setItemOrigin(ItemOrigin itemOrigin) {
		this.itemOrigin = itemOrigin;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the itemType
	 */
	public ItemType getItemType() {
		return itemType;
	}

	/**
	 * @param itemType
	 *            the itemType to set
	 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (itemId ^ (itemId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", itemOrigin="
				+ itemOrigin + ", price=" + price + ", itemType=" + itemType
				+ "]";
	}

}
