package capgemini.developer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingCart {
	private final List<String> items;
	private final Map<String, BigDecimal> priceList;

	public ShoppingCart() {
		items = new ArrayList<String>();
		priceList = new HashMap<String, BigDecimal>();
		priceList.put("apple", new BigDecimal("0.60"));
		priceList.put("orange", new BigDecimal("0.25"));
	}
	
	public ShoppingCart addToCart(String item) {
		items.add(item);
		return this;
	}
	
	public ShoppingCart addToCart(List<String> multipleItems) {
		items.addAll(multipleItems);
		return this;
	}
	
	public BigDecimal checkout() {
		BigDecimal total = new BigDecimal("0.00");
		for (String item : items) {
			total = total.add(priceList.get(item));
		}
		
		return total;
	}
}
