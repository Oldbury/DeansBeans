package deansBeansBusinessObjectsTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import deansBeansBusinessObjects.BasketItem;
import deansBeansBusinessObjects.IOrderBasket;
import deansBeansBusinessObjects.OrderBasket;
import deansBeansDataLayer.models.Format;
import deansBeansDataLayer.models.Customer;


class OrderBasketTests
{
	
	  Customer customer = new Customer(12345, "Smith", "1 the High Street", "Bootle",
	  "Lancs", "BOO 12T", "01273 700349", "Smith@Bootle.com", "Foo", "Bar");
	  
      /// <summary>
      ///A test for AddItem checking that the product is in the basket
      ///</summary>
	  @Test public void addItemTest() { 
		  OrderBasket orderBasket = new OrderBasket(customer);
	  
          int productID = 1;
	      String productName = "Old Knobler";
	      BigDecimal wholesalePrice = new BigDecimal(10.00);
	      BigDecimal recommendedRetailPrice = new BigDecimal(15.00);
          int quantity = 10;
          int formatID = 3;
          int degreeOfRoastID = 4;

	      String description = "Old Knobler is the original classic";
		  
		  BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
		  assertTrue(orderBasket.isProductNameInBasket(productName));
	 }
	  
      /// <summary>
      ///A test for AddItem
      ///</summary>	  
 	  @Test public void addTwoItems() { 
 		  OrderBasket orderBasket = new OrderBasket(customer);
		  
          int productID = 1;
	      String productName = "Old Knobler";
	      BigDecimal wholesalePrice = new BigDecimal(1.00);
	      BigDecimal recommendedRetailPrice = new BigDecimal(1.50);
          int quantity = 10;
          int formatID = 3;
          int degreeOfRoastID = 4;
	      String description = "Old Knobler is the original classic";
		  
		  BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	
		  orderBasket.addItem(basketItem);
		  
          productID = 2;
	      productName = "Robusta Crusta";
	      wholesalePrice = new BigDecimal(1.00);
	      recommendedRetailPrice = new BigDecimal(1.99);
	      quantity = 1;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "Robusta Crusta, the everyday coffee";
		  
		  basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
	      
	      BigDecimal expectedTotalItemValue = new BigDecimal(11.00);
	      expectedTotalItemValue = expectedTotalItemValue.setScale(2, RoundingMode.HALF_EVEN);
	      
	      BigDecimal actualTotalItemValue = orderBasket.getBasketTotal();
	      actualTotalItemValue = actualTotalItemValue.setScale(2, RoundingMode.HALF_EVEN);
	     
	      assertEquals(expectedTotalItemValue,  actualTotalItemValue);
	 }
	  
	  @Test public void ClearOrderBasketTest() { 
 		  OrderBasket orderBasket = new OrderBasket(customer);
		  
          int productID = 1;
	      String productName = "Old Knobler";
	      BigDecimal wholesalePrice = new BigDecimal(1.00);
	      BigDecimal recommendedRetailPrice = new BigDecimal(15.99);
	      int quantity = 1;
          int formatID = 3;
          int degreeOfRoastID = 4;
	      String description = "Old Knobler is the original classic";
		  
	      BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	
		  orderBasket.addItem(basketItem);
		  
		  productID = 2;
	      productName = "Robusta Crusta";
	      wholesalePrice = new BigDecimal(1.00);
	      recommendedRetailPrice = new BigDecimal(1.99);
	      quantity = 1;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "Robusta Crusta, the everyday coffee";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
	  
		  productID = 3;
	      productName = "Java Lava";
	      wholesalePrice = new BigDecimal(12.00);
	      recommendedRetailPrice = new BigDecimal(26.99);
	      quantity = 2;
          formatID = 4;
          degreeOfRoastID = 5;
	      description = "Dean's Popular breakfast coffee";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
		  
		  productID = 4;
	      productName = "Deanz Mean Beanz ";
	      wholesalePrice = new BigDecimal(13.00);
	      recommendedRetailPrice = new BigDecimal(27.99);
	      quantity = 1;
          formatID = 4;
          degreeOfRoastID = 5;
	      description = "A coffee to tide you through";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
	  
		  orderBasket.clearBasket(); 
		  
		  assertEquals(0, orderBasket.getNumberOfProducts()); 
	  }
	  
  
	  @Test public void BasketFilledWithDifferentProducts() {
 		  OrderBasket orderBasket = new OrderBasket(customer);
		  
          int productID = 1;
	      String productName = "Old Knobler";
	      BigDecimal wholesalePrice = new BigDecimal(1.00);
	      BigDecimal recommendedRetailPrice = new BigDecimal(15.99);
	      int quantity = 1;
          int formatID = 3;
          int degreeOfRoastID = 4;
	      String description = "Old Knobler is the original classic";
		  
	      BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	
		  orderBasket.addItem(basketItem);
		  
		  productID = 2;
	      productName = "Robusta Crusta";
	      wholesalePrice = new BigDecimal(1.00);
	      recommendedRetailPrice = new BigDecimal(1.99);
	      quantity = 2;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "Robusta Crusta, the everyday coffee";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
	  
		  productID = 3;
	      productName = "Java Lava";
	      wholesalePrice = new BigDecimal(12.00);
	      recommendedRetailPrice = new BigDecimal(26.99);
	      quantity = 3;
          formatID = 4;
          degreeOfRoastID = 5;
	      description = "Dean's Popular breakfast coffee";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
		  
		  productID = 4;
	      productName = "Deanz Mean Beanz ";
	      wholesalePrice = new BigDecimal(13.00);
	      recommendedRetailPrice = new BigDecimal(27.99);
	      quantity = 4;
          formatID = 4;
          degreeOfRoastID = 5;
	      description = "A coffee to tide you through";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
	  
		  orderBasket.clearBasket(); 
		  
		  assertEquals(0, orderBasket.getNumberOfProducts()); 
		  assertEquals(0, orderBasket.getNumberOfItems()); 
	  }
	  
	  @Test public void RemoveBasketItemFromBasket() { 
 		  OrderBasket orderBasket = new OrderBasket(customer);
		  
          int productID = 1;
	      String productName = "Old Knobler";
	      BigDecimal wholesalePrice = new BigDecimal(1.00);
	      BigDecimal recommendedRetailPrice = new BigDecimal(15.99);
	      int quantity = 1;
          int formatID = 3;
          int degreeOfRoastID = 4;
	      String description = "Old Knobler is the original classic";
		  
	      BasketItem basketItem1 = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	
		  orderBasket.addItem(basketItem1);
		  
		  productID = 2;
	      productName = "Robusta Crusta";
	      wholesalePrice = new BigDecimal(1.00);
	      recommendedRetailPrice = new BigDecimal(1.99);
	      quantity = 2;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "Robusta Crusta, the everyday coffee";
		  
	      BasketItem basketItem2 = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem2); 
	  
		  productID = 3;
	      productName = "Java Lava";
	      wholesalePrice = new BigDecimal(12.00);
	      recommendedRetailPrice = new BigDecimal(26.99);
	      quantity = 3;
          formatID = 4;
          degreeOfRoastID = 5;
	      description = "Dean's Popular breakfast coffee";
		  
	      BasketItem basketItem3 = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	      BasketItem basketItemToBeRemoved = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
 	      
		  orderBasket.addItem(basketItem3); 
		  
		  productID = 4;
	      productName = "Deanz Mean Beanz ";
	      wholesalePrice = new BigDecimal(13.00);
	      recommendedRetailPrice = new BigDecimal(27.99);
	      quantity = 4;
          formatID = 4;
          degreeOfRoastID = 5;
	      description = "A coffee to tide you through";
		  
	      BasketItem basketItem4 = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
 	  
		  orderBasket.addItem(basketItem4); 
		  
		  
	      
		  orderBasket.removeItem(basketItemToBeRemoved);
	  
		  assertEquals(3, orderBasket.getNumberOfProducts()); 
		  assertEquals(7, orderBasket.getNumberOfItems()); 
	  }
	  
	  @Test public void RemoveProductThatsNotInBasketTest() { 
 		  OrderBasket orderBasket = new OrderBasket(customer);
		  
          int productID = 1;
	      String productName = "Old Knobler";
	      BigDecimal wholesalePrice = new BigDecimal(1.00);
	      BigDecimal recommendedRetailPrice = new BigDecimal(15.99);
	      int quantity = 1;
          int formatID = 3;
          int degreeOfRoastID = 4;
	      String description = "Old Knobler is the original classic";
		  
	      BasketItem basketItem1 = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	
		  orderBasket.addItem(basketItem1);
		  
		  productID = 2;
	      productName = "Robusta Crusta";
	      wholesalePrice = new BigDecimal(1.00);
	      recommendedRetailPrice = new BigDecimal(1.99);
	      quantity = 2;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "Robusta Crusta, the everyday coffee";
		  
	      BasketItem basketItem2 = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem2); 
	  
		  productID = 3;
	      productName = "Java Lava";
	      wholesalePrice = new BigDecimal(12.00);
	      recommendedRetailPrice = new BigDecimal(26.99);
	      quantity = 3;
          formatID = 4;
          degreeOfRoastID = 5;
	      description = "Dean's Popular breakfast coffee";
		  
	      BasketItem basketItemThatIsNotInBasket = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
 	      
	      productID = 4;
	      productName = "Deanz Mean Beanz ";
	      wholesalePrice = new BigDecimal(13.00);
	      recommendedRetailPrice = new BigDecimal(27.99);
	      quantity = 4;
          formatID = 4;
          degreeOfRoastID = 5;
	      description = "A coffee to tide you through";
		  
	      BasketItem basketItem4 = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
 	  
		  orderBasket.addItem(basketItem4); 
 
	      
		  orderBasket.removeItem(basketItemThatIsNotInBasket);
	  
		  assertEquals(3, orderBasket.getNumberOfProducts()); 
		  assertEquals(7, orderBasket.getNumberOfItems()); 
	  }
	  
	  /* Test to check if adding 2 of the same products with differing formats add as separate basket items
	   * The reasoning behind this is that whilst still being the same coffee i.e. Lava Java, by changing the format they are different products
	   * For example, Lava Java in Pod format is a different product to Lava Java in Ground Beans
	   */
	  @Test public void AddProductWithMultipleFormats() {
 		  OrderBasket orderBasket = new OrderBasket(customer);
		  
          int productID = 1;
	      String productName = "Lava Java";
	      BigDecimal wholesalePrice = new BigDecimal(4.05);
	      BigDecimal recommendedRetailPrice = new BigDecimal(8.17);
	      int quantity = 2;
          int formatID = 3;
          int degreeOfRoastID = 4;
	      String description = "Lava Java is made from molten beans generated by geothermal energy and expelled through fractures in planetary crust or eruptions, usually at temperatures from 700 to 1,200 °C (1,292 to 2,192 °F). The structures resulting from subsequent solidification and cooling are then harvested, washed and tumbled before being reconstituted back into beans and then treated like any other bean. Bagged in our own factories.";
		  
	      BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	
		  orderBasket.addItem(basketItem);
		  
		  productID = 1;
	      productName = "Lava Java";
	      wholesalePrice = new BigDecimal(4.05);
	      recommendedRetailPrice = new BigDecimal(8.17);
	      quantity = 2;
          formatID = 2;
          degreeOfRoastID = 4;
	      description = "Lava Java is made from molten beans generated by geothermal energy and expelled through fractures in planetary crust or eruptions, usually at temperatures from 700 to 1,200 °C (1,292 to 2,192 °F). The structures resulting from subsequent solidification and cooling are then harvested, washed and tumbled before being reconstituted back into beans and then treated like any other bean. Bagged in our own factories.";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
		  
		  assertEquals(2, orderBasket.getNumberOfProducts()); 
		  assertEquals(4, orderBasket.getNumberOfItems()); 
	  }
	  
	  /* Test to check if adding 2 of the same products with the same formats only results in one basket item with an updated quantity
	   * The reasoning behind this is that whilst still being the same coffee i.e. Lava Java, by changing the format they are different products
	   * For example, Lava Java in Pod format is a different product to Lava Java in Ground Beans
	   */
	  @Test public void AddProductsWithSameFormats() {
 		  OrderBasket orderBasket = new OrderBasket(customer);
		  
          int productID = 1;
	      String productName = "Lava Java";
	      BigDecimal wholesalePrice = new BigDecimal(4.05);
	      BigDecimal recommendedRetailPrice = new BigDecimal(8.17);
	      int quantity = 2;
          int formatID = 3;
          int degreeOfRoastID = 4;
	      String description = "Lava Java is made from molten beans generated by geothermal energy and expelled through fractures in planetary crust or eruptions, usually at temperatures from 700 to 1,200 °C (1,292 to 2,192 °F). The structures resulting from subsequent solidification and cooling are then harvested, washed and tumbled before being reconstituted back into beans and then treated like any other bean. Bagged in our own factories.";
		  
	      BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	
		  orderBasket.addItem(basketItem);
		  
		  productID = 1;
	      productName = "Lava Java";
	      wholesalePrice = new BigDecimal(4.05);
	      recommendedRetailPrice = new BigDecimal(8.17);
	      quantity = 2;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "Lava Java is made from molten beans generated by geothermal energy and expelled through fractures in planetary crust or eruptions, usually at temperatures from 700 to 1,200 °C (1,292 to 2,192 °F). The structures resulting from subsequent solidification and cooling are then harvested, washed and tumbled before being reconstituted back into beans and then treated like any other bean. Bagged in our own factories.";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
		  orderBasket.addItem(basketItem); 
		  
		  // as the basket items are identical the code should simply increase the quantity on the original basket item instead of adding a new one
		  // check that there is only 1 product in the order basket
		  assertEquals(1, orderBasket.getNumberOfProducts()); 
		  // check that the quantity is correct on the basket item
		  assertEquals(4, orderBasket.getNumberOfItems()); 
	  }
	  
	  /* Test to check if adding 2 sets of the same products with differing formats add as separate basket items and returns a third basket item for 
	   * the product with a different formatiD
	   * Test with 5 basket items
	   * 2 x 2 identical products, 1x with different formatID
	   * Expects the orderBasket to contain 3 products with a quantity of 5
	   * The reasoning behind this is that whilst still being the same coffee i.e. Lava Java, by changing the format they are different products
	   * For example, Lava Java in Pod format is a different product to Lava Java in Ground Beans
	   */
	  @Test public void AddTwoProductsWithDifferentFormats() {
 		  OrderBasket orderBasket = new OrderBasket(customer);
		  
 		  // create product 1
          int productID = 1;
	      String productName = "Lava Java";
	      BigDecimal wholesalePrice = new BigDecimal(4.05);
	      BigDecimal recommendedRetailPrice = new BigDecimal(8.17);
	      int quantity = 1;
          int formatID = 3;
          int degreeOfRoastID = 4;
	      String description = "Lava Java is made from molten beans generated by geothermal energy and expelled through fractures in planetary crust or eruptions, usually at temperatures from 700 to 1,200 °C (1,292 to 2,192 °F). The structures resulting from subsequent solidification and cooling are then harvested, washed and tumbled before being reconstituted back into beans and then treated like any other bean. Bagged in our own factories.";
		  
	      BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
	
	      // add to the order basket
		  orderBasket.addItem(basketItem);
		  
		  //create product 2 - identical to product 1
		  
		  productID = 1;
	      productName = "Lava Java";
	      wholesalePrice = new BigDecimal(4.05);
	      recommendedRetailPrice = new BigDecimal(8.17);
	      quantity = 1;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "Lava Java is made from molten beans generated by geothermal energy and expelled through fractures in planetary crust or eruptions, usually at temperatures from 700 to 1,200 °C (1,292 to 2,192 °F). The structures resulting from subsequent solidification and cooling are then harvested, washed and tumbled before being reconstituted back into beans and then treated like any other bean. Bagged in our own factories.";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
	      // add to the order basket
		  orderBasket.addItem(basketItem); 
		  
		  // create product 3 - different coffee to products 1 & 2
		  productID = 2;
	      productName = "Arabica Erotica";
	      wholesalePrice = new BigDecimal(6.00);
	      recommendedRetailPrice = new BigDecimal(12.00);
	      quantity = 1;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "The queen of coffee, possibly the best aphrodisiac out there. Hint's of Dior, Canel, Klien and Versace...";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
	      // add to the order basket
		  orderBasket.addItem(basketItem); 
		  
		  // create product 4 - identical to product 3
		  productID = 2;
	      productName = "Arabica Erotica";
	      wholesalePrice = new BigDecimal(6.00);
	      recommendedRetailPrice = new BigDecimal(12.00);
	      quantity = 1;
          formatID = 3;
          degreeOfRoastID = 4;
	      description = "The queen of coffee, possibly the best aphrodisiac out there. Hint's of Dior, Canel, Klien and Versace...";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
	      // add to the order basket
		  orderBasket.addItem(basketItem); 
		  
		  // create product 5 - same as products 3 & 4 with different formatID
		  productID = 2;
	      productName = "Arabica Erotica";
	      wholesalePrice = new BigDecimal(6.00);
	      recommendedRetailPrice = new BigDecimal(12.00);
	      quantity = 1;
          formatID = 6;
          degreeOfRoastID = 4;
	      description = "The queen of coffee, possibly the best aphrodisiac out there. Hint's of Dior, Canel, Klien and Versace...";
		  
	      basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
		  
	      // add to the order basket
		  orderBasket.addItem(basketItem); 
		  
		  /*  expects there to be 3 products in the basket
		   *  as products 1 & 2 should be one basketItem and products 3 & 4 should also be one basketItem
		   *  product 5 (with differing formatID) should be added as its own basket item
		  */
		  assertEquals(3, orderBasket.getNumberOfProducts()); 
		  assertEquals(5, orderBasket.getNumberOfItems()); 
	  }

}
