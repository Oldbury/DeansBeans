package deansBeansDataLayer.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "products", schema = "deansBeans")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", nullable = false)
    private int productID;

    @Column(name = "ProductName", nullable = false, length = 50)
    private String productName;

    @Column(name = "Description", nullable = false, length = 200)
    private String description;

    @Column(name = "RecommendedRetailPrice", nullable = false, precision = 2)
    private BigDecimal recommendedRetailPrice;
    
    @Column(name = "WholesalePrice", nullable = false, precision = 2)
    private BigDecimal wholesalePrice;
    
	@Column(name = "DiscountType", nullable = true, length=1)
    private String discountType;
    
    @Column(name = "DiscountPercentage", nullable = true)
    private Integer discountPercentage;

    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) { this.productID = productID; }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRecommendedRetailPrice() {
        return recommendedRetailPrice.setScale(2, RoundingMode.UP);
    }
    
    public void setRecommendedRetailPrice(BigDecimal recommendedRetailPrice) {
        this.recommendedRetailPrice = recommendedRetailPrice;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice.setScale(2, RoundingMode.UP);
    }
    
    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }
    
	public String getDiscountType() {
		return discountType;
	}
	
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	
	public Integer getDiscountPercentage() {
		return discountPercentage;
	}
	
	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
    
    public String toString() {
    	return productName;
    }
}


