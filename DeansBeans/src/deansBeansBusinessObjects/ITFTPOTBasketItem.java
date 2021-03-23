package deansBeansBusinessObjects;

import java.math.BigDecimal;

import deansBeansDataLayer.models.Format;

public interface ITFTPOTBasketItem {
        int getProductID();
        String getProductName();
        BigDecimal getWholesalePrice();
        BigDecimal getRecommendedRetailPrice();
        char[] getDiscount();
        int getQuantity();
        int getFormatID();
        int getDegreeOfRoastID();
        String getDescription();
        BigDecimal getTotalValueOfBasketItem();
        int increaseQuantity(int quantity);
        int decreaseQuantity(int quantity);
        int increaseDegreeOfRoast(int incrementalValue);
        int decreaseDegreeOfRoast(int incrementalValue);
}
