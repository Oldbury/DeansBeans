package deansBeansDataLayer.models;


import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders", schema = "deansBeans")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID", unique = true, nullable = false)
    private int orderID;

    @Column(name = "CustomerID", nullable = false)
    private int customerID;

    @Column(name = "OrderDate", nullable = false)
    private Date orderDate;

    @Column(name = "OrderTotal", nullable = false, precision = 2)
    private BigDecimal orderTotal;

    @Column(name = "OrderStatus", nullable = false)
    private int orderStatus;
     
    public Order() {
    	
    }

    public Order(int customerID, Date orderDate, BigDecimal orderTotal, int orderStatus) {
		super();
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.orderStatus = orderStatus;
	}
	public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderNumber) {
        this.orderID = orderNumber;
    }

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerNumber) {
        this.customerID = customerNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }
    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    
	@OneToMany  (mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	
	// Newly added methods specifically for the Hibernate functionality:
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem );
	}
}
