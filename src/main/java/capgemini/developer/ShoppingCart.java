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

		total = total.add(totalApples());
		total = total.add(totalOranges());
		
//		for (String item : items) {
//			total = total.add(priceList.get(item));
//		}		
//		
//		total = total.subtract(discount("apple", 2, new BigDecimal("1")));
//		total = total.subtract(discount("orange", 3, new BigDecimal("2")));
		
		return total;
	}
	
//	private BigDecimal discount(String product, int grouping, BigDecimal multiplier) {
//		BigDecimal total = new BigDecimal("0.00");
//		int products = 0;
//		for (String item : items) {
//			if (item.equals(product)) {
//				products++;
//			}
//		}
//		
//		if (products == 0) return total;
//		
//		int pairs = products / grouping;
//		
//		BigDecimal productPrice = priceList.get("apple");
//		productPrice = productPrice.multiply(multiplier);
//		
//		for (int i = 0; i < pairs; i++) {
//			total = total.add(productPrice);
//		}
//		
//		return total;
//		
//	}
	
	private BigDecimal totalApples() {
		BigDecimal total = new BigDecimal("0.00");
		int numberOfApples = 0;
		for (String item : items) {
			if (item.equals("apple")) {
				numberOfApples++;
			}
		}
		
		if (numberOfApples == 0) return total;
		
		int pairs = numberOfApples / 2;
		int apples = (numberOfApples % pairs) + pairs;
		
		BigDecimal applePrice = priceList.get("apple");
		
		for (int i = 0; i < apples; i++) {
			total = total.add(applePrice);
		}
		
		return total;
	}
	
	private BigDecimal totalOranges() {
		BigDecimal total = new BigDecimal("0.00");
		int numberOfOranges = 0;
		for (String item : items) {
			if (item.equals("orange")) {
				numberOfOranges++;
			}
		}
		
		if (numberOfOranges == 0) return total;
		
		int pairs = numberOfOranges / 3;
		int oranges = (numberOfOranges % pairs) + pairs;
		
		BigDecimal orangePrice = priceList.get("orange");
		orangePrice = orangePrice.add(orangePrice);
		
		for (int i = 0; i < oranges; i++) {
			total = total.add(orangePrice);
		}
		
		return total;
	}
	
}
