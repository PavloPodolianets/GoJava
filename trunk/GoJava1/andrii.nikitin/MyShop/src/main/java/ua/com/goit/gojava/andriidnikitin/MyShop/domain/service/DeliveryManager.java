package ua.com.goit.gojava.andriidnikitin.MyShop.domain.service;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;


public interface DeliveryManager {
	
	/**
	 * This method creates new record of some good with it's price and quantity.
	 * 
	 * @param good is good that being delivered
	 * @param quantity is quantity of delivered good
	 * @param price is price of -//-
	 * @return newly created record with (generated by DB) ID 
	 * @throws MyShopException if something goes wrong 
	 */
	public GoodRecord deliverGood(Good good, Integer quantity, Integer price) throws MyShopException;

}
