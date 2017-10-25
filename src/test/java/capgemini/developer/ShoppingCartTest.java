package capgemini.developer;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class ShoppingCartTest {
	
	@Test
	public void testCheckoutApple() {
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart("apple");
		
		assertEquals(new BigDecimal("0.60"), cart.checkout());
	}
	
	@Test
	public void testCheckoutFourItems() {
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart("apple");
		cart.addToCart("apple");
		cart.addToCart("orange");
		cart.addToCart("apple");
		
//		assertEquals(new BigDecimal("2.05"), cart.checkout());
		assertEquals(new BigDecimal("1.45"), cart.checkout());
	}
	
	@Test
	public void testCheckoutMultipleItems() {
		ShoppingCart cart = new ShoppingCart();
		ArrayList<String> items = new ArrayList<String>();
		items.add("apple");
		items.add("apple");
		items.add("orange");
		items.add("apple");
		
		cart.addToCart(items);
		
//		assertEquals(new BigDecimal("2.05"), cart.checkout());
		assertEquals(new BigDecimal("1.45"), cart.checkout());
	}
	
	@Test
	public void testCheckoutBuyOneGetOne() {
		ShoppingCart cart = new ShoppingCart();
		ArrayList<String> items = new ArrayList<String>();
		items.add("apple");
		items.add("apple");
		
		cart.addToCart(items);
		
		assertEquals(new BigDecimal("0.60"), cart.checkout());
	}
	
	@Test
	public void testCheckoutThreeForThePriceOfTwo() {
		ShoppingCart cart = new ShoppingCart();
		ArrayList<String> items = new ArrayList<String>();
		items.add("orange");
		items.add("orange");
		items.add("orange");
		
		cart.addToCart(items);
		
		assertEquals(new BigDecimal("0.50"), cart.checkout());
	}
	
	@Test
	public void testCheckoutBothPromo() {
		ShoppingCart cart = new ShoppingCart();
		ArrayList<String> items = new ArrayList<String>();
		items.add("orange");
		items.add("orange");
		items.add("orange");
		items.add("apple");
		items.add("apple");
		
		cart.addToCart(items);
		
		assertEquals(new BigDecimal("1.10"), cart.checkout());
	}
}
