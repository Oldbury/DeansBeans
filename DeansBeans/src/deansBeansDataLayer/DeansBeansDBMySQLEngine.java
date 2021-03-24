package deansBeansDataLayer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import deansBeansBusinessObjects.BasketItem;
import deansBeansBusinessObjects.IBasketItem;
import deansBeansBusinessObjects.IOrderBasket;
import deansBeansBusinessObjects.OrderBasket;
import deansBeansDataLayer.models.Format;
import deansBeansDataLayer.models.Customer;
import deansBeansDataLayer.models.DegreesOfRoast;
import deansBeansDataLayer.models.Order;
import deansBeansDataLayer.models.OrderItem;
import deansBeansDataLayer.models.Product;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DeansBeansDBMySQLEngine implements IDeansBeansDBEngine
{
	public List<Customer> getCustomers()
	{
		List<Customer> customers = new ArrayList<Customer>();
		Session session = null;
		
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
	        Query<Customer> query = session.createQuery("from Customer", Customer.class); 
	        customers = query.list();
		}
		finally {
//			session.close();
		}
    	return customers;
	}
	
	public List<Product> getProducts()
	{
		List<Product> products = new ArrayList<Product>();
		Session session = null;
		
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
	        Query<Product> query = session.createQuery("from Product", Product.class); 
	        products = query.list();
		}
		finally {
			session.close();
		}
    	return products;
	}
	
	public List<Order> getOrdersForCustomer(int customerID)
	{
		List<Order> orders = new ArrayList<Order>();
		Session session = null;
		
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
	        Query<Order> query = session.createQuery("from Order where CustomerID = " + customerID, Order.class); 
	        orders = query.list();
		}
		finally {
			session.close();
		}
    	return orders;
	}
	
	public List<OrderItem> getOrderItemsForOrder(int orderID){

		List<OrderItem> orderItems = new ArrayList<OrderItem>();		
		Session session = null;
		
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
	        Query<OrderItem> query = session.createQuery("from OrderItem where OrderID = " + orderID, OrderItem.class); 
	        orderItems = query.list();
		}
		finally {
			session.close();
		}
    	return orderItems;
	}
	
    public List<Format> getFormats()
    {
		List<Format> formats = new ArrayList<Format>();
		Session session = null;
		
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
	        Query<Format> query = session.createQuery("from Format", Format.class); 
	        formats =  query.list();
		}
		finally {
//			session.close();
		}    	
        return formats;
    }

	@Override
	public Format getFormatByID(int formatID) {
		List<Format> formats = new ArrayList<Format>();
		Session session = null;
		
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
	        Query<Format> query = session.createQuery("from Format where FormatID = " + formatID, Format.class); 
	        formats = query.list();
		}
		finally {
			session.close();
		} 
    	return formats.get(0);
	}

	@Override
	public List<DegreesOfRoast> getDegreesOfRoast() {
		List<DegreesOfRoast> degreesOfRoast = new ArrayList<DegreesOfRoast>();
		Session session = null;
		
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
	        Query<DegreesOfRoast> query = session.createQuery("from DegreesOfRoast"); 
	        degreesOfRoast = query.list();
		}
		finally {
			session.close();
		}   	
        return degreesOfRoast;
	}

	@Override
	public DegreesOfRoast getDegreeOfRoastByID(int degreeOfRoastID) {
		List<DegreesOfRoast> degreesOfRoast = new ArrayList<DegreesOfRoast>();
		Session session = null;
		
		try {
			session = SessionFactoryUtil.getSessionFactory().openSession();
	        Query<DegreesOfRoast> query = session.createQuery("from DegreesOfRoast where DegreeOfRoastID = " + degreeOfRoastID, DegreesOfRoast.class); 
	        degreesOfRoast = query.list();
		}
		finally {
			session.close();
		}  
    	return degreesOfRoast.get(0);
	}
	
	
	public void createOrder(IOrderBasket orderBasket, Customer customer) {
		Session session = null;
		
		try {
			// open the hibernate session
			session = SessionFactoryUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// get the items in the basket
			orderBasket.getBasketItems();
			System.out.println(orderBasket.getNumberOfProducts() + " number of products to checkout");
			// create a new order and orderItem
			Order order = new Order();
			OrderItem ordItem = new OrderItem();
			// create a new date for the order
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			// set the order date, total price and customerID
			order.setOrderDate(date);
			order.setOrderTotal(orderBasket.getBasketTotal());
			order.setCustomerID(customer.getCustomerID());
			
			// for each item in the basket add a new order item and add to the order
			for (IBasketItem basketItem : orderBasket.getBasketItems()) {
				ordItem.setOrderItemID((int) Math.random());
				ordItem.setProductID(basketItem.getProductID());
				ordItem.setPurchasePrice(basketItem.getWholesalePrice());
				ordItem.setFormatID(basketItem.getFormatID());
				ordItem.setQuantity(basketItem.getQuantity());
				ordItem.setRoastID(basketItem.getDegreeOfRoastID());
				ordItem.setOrder(order);
				order.addOrderItem(ordItem);
			}
			
			System.out.println("Items in order: " + order.getOrderItems().size());
			// saves to the database
			session.save(order);
			session.save(ordItem);
			
		} finally {
			// commit the transaction and close the session
			session.getTransaction().commit();
			session.close();
		}
	}
}
