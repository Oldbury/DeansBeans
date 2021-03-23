package deansBeansDataLayer.models;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "orderitems", schema = "deansBeans")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItemID", unique = true, nullable = false)
    private int orderItemID;

    //@Column(name = "OrderID", nullable = false, )
    //private int orderID;

    //@Column(name = "ProductID", nullable = false)
    private int productID;
    

    @Column(name = "PurchasePrice", nullable = false)
    private BigDecimal purchasePrice;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "FormatID", nullable = false)
    private int formatID;

//    @Column(name = "RoastID", nullable = false)
//    private int roastID;

    public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
  
    public OrderItem() {
    	
    }
    
    public OrderItem(Order order, int productID, BigDecimal purchasePrice, int quantity, int formatID, int roastID) {
		super();
		this.order = order;
		this.productID = productID;
		this.purchasePrice = purchasePrice;
		this.quantity = quantity;
		this.formatID = formatID;
//		this.roastID = roastID;
	}
	
    public int getOrderItemID() {
		return orderItemID;
	}
    
	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}
	
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	@ManyToOne
	// If the @JoinColumn is omitted, Hibernate assumes the join column is theatre_theatregroupID - 'table + primary key' for the theatregroups table, so we need to be explicit
	@JoinColumn(name = "OrderID", referencedColumnName = "OrderID", nullable = false)
	private Order order;
	
	// Newly added methods specifically for the Hibernate functionality:
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	@ManyToOne
	// If the @JoinColumn is omitted, Hibernate assumes the join column is theatre_theatregroupID - 'table + primary key' for the theatregroups table, so we need to be explicit
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
	private Product product;
	
	// Newly added methods specifically for the Hibernate functionality:
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getFormatID() {
		return formatID;
	}

	public void setFormatID(int formatID) {
		this.formatID = formatID;
	}

//	public int getRoastID() {
//		return roastID;
//	}
//
//	public void setRoastID(int roastID) {
//		this.roastID = roastID;
//	}
	
}