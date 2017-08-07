package com.salestax.model;

/**
 * ItemType containing information about item type and its exemption
 * 
 * @author rohit
 *
 */
public enum ItemType {

	BOOK(true), FOOD(true), MEDICAL(true), COSMETICS(false);

	private final boolean isExempted;

	private ItemType(boolean isExempted) {
		this.isExempted = isExempted;
	}

	public boolean isExempted() {
		return isExempted;
	}

}
