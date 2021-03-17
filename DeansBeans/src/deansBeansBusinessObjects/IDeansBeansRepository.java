package deansBeansBusinessObjects;

import java.util.List;

import deansBeansDataLayer.models.Format;
import deansBeansDataLayer.models.Customer;
import deansBeansDataLayer.models.DegreesOfRoast;
import deansBeansDataLayer.models.Order;
import deansBeansDataLayer.models.OrderItem;
import deansBeansDataLayer.models.Product;

public interface IDeansBeansRepository
{
	List<Customer> getCustomers();
    List<Product> getProducts();
    List<Order> getOrdersForCustomer(int customerID);
    List<OrderItem> getOrderItemsForOrder(int orderID);
    List<Format> getFormats();
    Format getFormatByID(int formatID);
    List<DegreesOfRoast> getDegreesOfRoast();
    DegreesOfRoast getDegreeOfRoastByID(int degreeOfRoastID);
    
    int saveOrderToDatabase(IOrderBasket orderBasket, Customer customer);
}
