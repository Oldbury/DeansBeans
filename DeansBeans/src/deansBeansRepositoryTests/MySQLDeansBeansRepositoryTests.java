package deansBeansRepositoryTests;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import deansBeansBusinessObjects.MySQLDeansBeansRepository;
import deansBeansDataLayer.models.DegreesOfRoast;
import deansBeansDataLayer.models.Format;
import deansBeansDataLayer.models.Order;
import deansBeansDataLayer.models.OrderItem;
import deansBeansDataLayer.models.Product;


public class MySQLDeansBeansRepositoryTests
{
	@Test
	public void testGetProducts()
	{
		//Arrange
		MySQLDeansBeansRepository repository = new MySQLDeansBeansRepository();
		
		//Act
		List<Product> products = repository.getProducts();
		
		//Assert
		Assert.assertEquals(17, products.size());
	}
	
	@Test
	public void testGetOrdersForCustomer()
	{
		//Arrange
		MySQLDeansBeansRepository repository = new MySQLDeansBeansRepository();
		
		//Act
		List<Order> orders = repository.getOrdersForCustomer(2);
		
		//Assert
		Assert.assertEquals(3, orders.size());
		Assert.assertEquals(1, ((Order)((orders).get(2))).getOrderStatus());
	}
	
	@Test
	public void testGetOrderItemsForOrder()
	{
		//Arrange
		MySQLDeansBeansRepository repository = new MySQLDeansBeansRepository();
		
		//Act
		List<OrderItem> orderItems = repository.getOrderItemsForOrder(1);
		
		//Assert
		Assert.assertEquals(3, orderItems.size());
		Assert.assertEquals(1, orderItems.get(1).getQuantity());
	}
	
	
	@Test
	public void testGetFormats()
	{
		//Arrange
		MySQLDeansBeansRepository repository = new MySQLDeansBeansRepository();
		
		//Act
		List<Format> formats = repository.getFormats();
		
		//Assert
		Assert.assertEquals(9, formats.size());
		Assert.assertEquals("Dust", formats.get(4).getFormatDescription());
	}
	
	
	@Test
	public void testGetFormatForFormatID()
	{
		//Arrange
		MySQLDeansBeansRepository repository = new MySQLDeansBeansRepository();
		
		//Act
		Format format = repository.getFormatByID(5);
		
		//Assert
		Assert.assertEquals(5, format.getFormatID());
		Assert.assertEquals("Dust", format.getFormatDescription());
	}
	
	
	@Test
	public void testGetDegreesOfRoast()
	{
		//Arrange
		MySQLDeansBeansRepository repository = new MySQLDeansBeansRepository();
		
		//Act
		List<DegreesOfRoast> formats = repository.getDegreesOfRoast();
		
		//Assert
		Assert.assertEquals(6, formats.size());
		Assert.assertEquals("Burnt", formats.get(4).getRoastType());
	}
	
	
	@Test
	public void testGetDegreeOfRoastForRoastID()
	{
		//Arrange
		MySQLDeansBeansRepository repository = new MySQLDeansBeansRepository();
		
		//Act
		DegreesOfRoast degreeOfRoast = repository.getDegreeOfRoastByID(5);
		
		//Assert
		Assert.assertEquals(5, degreeOfRoast.getDegreesOfRoastID());
		Assert.assertEquals("Burnt", degreeOfRoast.getRoastType());
	}
	

}
