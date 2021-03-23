package deansBeansBusinessObjects;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import deansBeansDataLayer.DeansBeansDBMySQLEngine;
import deansBeansDataLayer.SessionFactoryUtil;
import deansBeansDataLayer.models.Format;
import deansBeansDataLayer.models.Customer;
import deansBeansDataLayer.models.DegreesOfRoast;
import deansBeansDataLayer.models.Order;
import deansBeansDataLayer.models.OrderItem;
import deansBeansDataLayer.models.Product;

public class MySQLDeansBeansRepository implements IDeansBeansRepository
{

	DeansBeansDBMySQLEngine engine = new DeansBeansDBMySQLEngine();
    List<Format> formats = null;
    List<DegreesOfRoast> degreesOfRoast = null;
    
	public MySQLDeansBeansRepository() {
        //Generate once (for efficiency)
        formats = engine.getFormats();
        degreesOfRoast = engine.getDegreesOfRoast();
	}
	
    public List<Customer> getCustomers()
    {
	 	List<Customer> customers = null;
	 	customers = engine.getCustomers();
        return customers;
    }

    public List<Product> getProducts()
    {
	 	List<Product> products = null;
	 	products = engine.getProducts();
        return products;
    }
 
    public List<Format> getFormats()
    {
        return formats;
    }
    
	@Override
	public Format getFormatByID(int formatID) {
		Format format = formats.stream().filter(f -> f.getFormatID() == formatID).findFirst().orElse(null);
		return format;
	}

	@Override
	public List<DegreesOfRoast> getDegreesOfRoast() {
        return degreesOfRoast;
	}

	@Override
	public DegreesOfRoast getDegreeOfRoastByID(int degreeOfRoastID) {
		DegreesOfRoast degreeOfRoast = degreesOfRoast.stream().filter(r -> r.getDegreesOfRoastID() == degreeOfRoastID).findFirst().orElse(null);
		return degreeOfRoast;
	}
    
	@Override
	public List<Order> getOrdersForCustomer(int customerID) {
	 	List<Order> orders = null;
	 	orders = engine.getOrdersForCustomer(customerID);
        return orders;
    }

	@Override
	public List<OrderItem> getOrderItemsForOrder(int orderID) {
	 	List<OrderItem> orderItems = null;
	 	orderItems = engine.getOrderItemsForOrder(orderID);
        return orderItems;
	}

	@Override
	public int saveOrderToDatabase(IOrderBasket orderBasket, Customer customer) {
		
		try {
			System.out.println("Attempting to create order and persist to DB");
			engine.createOrder(orderBasket, customer);
		}
		catch(HibernateException hibernateEx) {
			System.out.println("Failed to created order");
			System.out.println(hibernateEx);
		}
		
		long millis = System.currentTimeMillis(); // Gets system date and time
	 	return -1;
	}




}
