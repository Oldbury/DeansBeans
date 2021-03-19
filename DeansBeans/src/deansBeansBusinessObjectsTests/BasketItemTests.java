package deansBeansBusinessObjectsTests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import deansBeansBusinessObjects.BasketItem;
import deansBeansBusinessObjects.IBasketItem;
import deansBeansDataLayer.models.Format;

class BasketItemTests
{

    /// <summary>
    ///A test for BasketItem Constructor
    ///</summary>
    @Test
    public void basketItemHappyConstructorTest()
    {
        int productID = 1;
        String productName = "Old Knobler";
        BigDecimal wholesalePrice = new BigDecimal(2.49);
        BigDecimal recommendedRetailPrice = new BigDecimal(11.49);
        int quantity = 10;
        int formatID = 5;
        int degreeOfRoastID = 2;
        String description = "Old Knobler is the original classic";

        BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);

        BigDecimal expected = new BigDecimal(24.90);
      
        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
        
        BigDecimal actual = basketItem.getTotalValueOfBasketItem();
        actual = actual.setScale(2, RoundingMode.HALF_EVEN);
        
        assertEquals(expected, actual);
    }
    

    /// <summary>
    ///A test for BasketItem Constructor
    ///</summary>
    @Test
    public void basketItemAlternativeHappyConstructorTest()
    {
        int productID = 5;
        String productName = "Justa Robusta";
        BigDecimal wholesalePrice = new BigDecimal(1.60);
        BigDecimal recommendedRetailPrice = new BigDecimal(11.00);
        int quantity = 2;
        int formatID = 5;
        int degreeOfRoastID = 2;
        String description = "Justa Robusta, the everyday coffee";

        BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);

        BigDecimal expected = new BigDecimal(3.20);
        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
        
        BigDecimal actual = basketItem.getTotalValueOfBasketItem();
        actual = actual.setScale(2, RoundingMode.HALF_EVEN);
        
        assertEquals(expected, actual);
    }
    
    /// <summary>
    ///A test for BasketItem Constructor
    ///</summary>
    @Test
    public void basketItemNegativeQuantityConstructorTest()
    {
        int productID = 1;
        String productName = "Old Knobler";
        BigDecimal wholesalePrice = new BigDecimal(2.49);
        BigDecimal recommendedRetailPrice = new BigDecimal(11.49);
        int quantity = -10;
        int formatID = 5;
        int degreeOfRoastID = 2;
        String description = "Old Knobler is the original classic";

        BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);

        BigDecimal expected = new BigDecimal(2.49);
      
        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
        
        BigDecimal actual = basketItem.getTotalValueOfBasketItem();
        actual = actual.setScale(2, RoundingMode.HALF_EVEN);
        
        assertEquals(expected, actual);
    }
    
    /// <summary>
    ///A test for BasketItem Constructor
    ///</summary>
    @Test
    public void basketItemQuantityZeroConstructorTest()
    {
        int productID = 1;
        String productName = "Old Knobler";
        BigDecimal wholesalePrice = new BigDecimal(2.49);
        BigDecimal recommendedRetailPrice = new BigDecimal(11.49);
        int quantity = 0;
        int formatID = 5;
        int degreeOfRoastID = 2;
        String description = "Old Knobler is the original classic";

        BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);

        BigDecimal expected = new BigDecimal(2.49);
      
        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
        
        BigDecimal actual = basketItem.getTotalValueOfBasketItem();
        actual = actual.setScale(2, RoundingMode.HALF_EVEN);
        
        assertEquals(expected, actual);
    }
    
    /// <summary>
    ///A test for BasketItem Constructor where the quantity set is invalid as it is too high
    ///</summary>
    @Test
    public void basketItemQuantityTooHighConstructorTest()
    {
        int productID = 1;
        String productName = "Old Knobler";
        BigDecimal wholesalePrice = new BigDecimal(2.49);
        BigDecimal recommendedRetailPrice = new BigDecimal(11.49);
        /// THE MAX VALUE ACCEPTABLE QUANTITY IS 100 MEANING THAT THE QUANTITY 999 IS INVALID
        int quantity = 999;
        int formatID = 5;
        int degreeOfRoastID = 2;
        String description = "Old Knobler is the original classic";

        BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);
        /// THE QUANTITY SETTER WILL DEFAULT ANY QUANTITY GREATER THAN 100 TO 100
        /// MEANING THAT THE EXPECTED VALUE SHOULD BE 100 * WHOLESALEPRICE(2.49)
        BigDecimal expected = new BigDecimal(249.00);
      
        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
        
        BigDecimal actual = basketItem.getTotalValueOfBasketItem();
        actual = actual.setScale(2, RoundingMode.HALF_EVEN);
        
        assertEquals(expected, actual);
    }
    
    /// <summary>
    ///A test for LatestPrice
    ///</summary>
    @Test
    public void totalValueOfBasketItemTest()
    {
        int productID = 5;
        String productName = "Justa Robusta";
        BigDecimal wholesalePrice = new BigDecimal(1.60);
        BigDecimal recommendedRetailPrice = new BigDecimal(11.00);
        int quantity = 5;
        int formatID = 5;
        int degreeOfRoastID = 2;
        String description = "Justa Robusta, the everyday coffee";

        BasketItem basketItem = new BasketItem(productID, productName, wholesalePrice, recommendedRetailPrice, quantity, formatID, degreeOfRoastID, description);

        BigDecimal expected = new BigDecimal(1.60).multiply(new BigDecimal(5));
        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
        
        BigDecimal actual = basketItem.getTotalValueOfBasketItem();
        actual = actual.setScale(2, RoundingMode.HALF_EVEN);
        
        assertEquals(expected, actual);
    }    
    
 
   
}
