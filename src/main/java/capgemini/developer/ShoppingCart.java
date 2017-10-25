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
		
		total = total.subtract(discount("apple", 2, new BigDecimal("0.60")));
		total = total.subtract(discount("orange", 3, new BigDecimal("0.25")));
		
		return total;
	}
	
	private BigDecimal discount(String product, int grouping, BigDecimal priceDiscount) {
		BigDecimal total = new BigDecimal("0.00");
		int products = 0;
		for (String item : items) {
			if (item.equals(product)) {
				products++;
			}
		}
		
		if (products == 0) return total;
		
		int pairs = products / grouping;
		
		for (int i = 0; i < pairs; i++) {
			total = total.add(priceDiscount);
		}
		
		return total;
		
	}
}
