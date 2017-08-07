package com.salestax.model;

import java.math.BigDecimal;

public class Receipt {

	public void printProduct(OrderedItem itemList) {
		System.out.println(itemList.getQuantity() + " "
				+ itemList.getItem().getName() + " : " + itemList.getPrice());
	}

	public void printSalesTax(TaxOnOrderedItem taxOnOrderedItem) {
		System.out.println("Sales Taxes: "
				+ taxOnOrderedItem.getSalesTaxAmount());
	}

	public void printTotal(BigDecimal total) {
		System.out.println("Total: " + total);
	}

}
