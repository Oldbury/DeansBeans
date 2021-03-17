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
	  


}
