package deansBeansDataLayer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deansBeansDataLayer.models.Format;
import deansBeansDataLayer.models.Customer;
import deansBeansDataLayer.models.DegreesOfRoast;
import deansBeansDataLayer.models.Order;
import deansBeansDataLayer.models.OrderItem;
import deansBeansDataLayer.models.Product;

public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;
    //private static ServiceRegistry serviceRegistry;

    /**
     * This method creates a SessionFactory which will be used to create sessions
     * @return
     */
    private static SessionFactory createSessionFactory() {
		// create the session factory 
		// heavyweight object only create this once
		try {
			if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().
					addAnnotatedClass(Customer.class).
					addAnnotatedClass(Product.class).
					addAnnotatedClass(Order.class).
					addAnnotatedClass(OrderItem.class).
					addAnnotatedClass(Format.class).
					addAnnotatedClass(DegreesOfRoast.class).
					buildSessionFactory();
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
    	
    	return sessionFactory;
    }

    /**
     * 
     * @return returns the SessionFactory object
     */
    public static SessionFactory getSessionFactory() {
        return createSessionFactory();
    }
   

}
