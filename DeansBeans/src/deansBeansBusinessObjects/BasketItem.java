package deansBeansBusinessObjects;
import java.math.BigDecimal;

import deansBeansDataLayer.models.Format;

public class BasketItem implements IBasketItem {
    private int productID;
    private String productName;
    private BigDecimal wholesalePrice;
    private BigDecimal recommendedRetailPrice;
    private int quantity;
    private int formatID;
    private int degreeOfRoastID;
    private String description;

    public BasketItem(int productID, String productName, BigDecimal wholesalePrice, BigDecimal recommendedRetailPrice, int quantity, int formatID, int roastID, String description) {
        this.setProductID(productID);
        this.setProductName(productName);
        this.setWholesalePrice(wholesalePrice);
        this.setRecommendedRetailPrice(recommendedRetailPrice);
        this.setQuantity(quantity);
        this.setFormatID(formatID);
        this.setDegreeOfRoastID(roastID);
        this.setDescription(description);
    }

	public int getProductID(){
        return productID;
    }
	
    private void setProductID(int productID) {
    	this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }
    
    private void setProductName(String productName) {
    	this.productName = productName;
    }
    
    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    private void setWholesalePrice(BigDecimal wholesalePrice) {
    	this.wholesalePrice = wholesalePrice;
    }

    public BigDecimal getRecommendedRetailPrice() {
        return recommendedRetailPrice;
    }

    private void setRecommendedRetailPrice(BigDecimal recommendedRetailPrice) {
    	if (recommendedRetailPrice.compareTo(new BigDecimal(0)) >= 0)
    	this.recommendedRetailPrice = recommendedRetailPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
    	// minimum order quantity should be 1
    	// attempts to set quantity to less than will be set to 1
    	if(quantity <= 0) {
    		this.quantity = 1;
    	}
    	// the maximum quantity for a single basket item is 100
    	// this prevents any accidental or malicious attempts to order an unachievable amount of items
    	else if(quantity > 100) {
    		this.quantity = 100;
    	}
    	// if the quantity is between 1 and 100 then set to the value
    	else {
    		this.quantity = quantity;
    	}
    	
    }

	public int getFormatID() {
		return formatID;
	}

	private void setFormatID(int formatID) {
		this.formatID = formatID;
	}

	public int getDegreeOfRoastID() {
		return degreeOfRoastID;
	}

	private void setDegreeOfRoastID(int degreeOfRoastID) {
		this.degreeOfRoastID = degreeOfRoastID;
	}

    public String getDescription() {
        return description;
    }
     
    private void setDescription(String description) {
        this.description = description;
    }
    
    public BigDecimal getTotalValueOfBasketItem(){
        BigDecimal totalPrice = wholesalePrice.multiply(new BigDecimal(quantity));
        return totalPrice;
     }
    
    public int increaseQuantity(int quantity) {
    	this.setQuantity(this.getQuantity() + quantity);
    	return this.getQuantity();
    }
    
    public int decreaseQuantity(int quantity) {
    	this.setQuantity(this.getQuantity() - quantity);
    	return this.getQuantity();
    }

	public int increaseDegreeOfRoast(int incrementalValue) {
    	this.setDegreeOfRoastID(this.getDegreeOfRoastID() + incrementalValue);
    	return this.getDegreeOfRoastID();
	}

	public int decreaseDegreeOfRoast(int incrementalValue) {
    	this.setDegreeOfRoastID(this.getDegreeOfRoastID() - incrementalValue);
    	return this.getDegreeOfRoastID();
	}


}