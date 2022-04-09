package com.seleniumexpress.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seleniumexpress.models.Customer;
import com.seleniumexpress.models.Order;
import com.seleniumexpress.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class StudentApp {

	private static Session session = null;

	public static void main(String[] args) {

		// 1. create configuration
		// 2. create session factory
		// 3. initialize the session object

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();
		/*
		 * Customer customer = new Customer(); customer.setCustomerMobile("7829442793");
		 * customer.setCustomerName("Prashant");
		 * 
		 * Order order = new Order(); order.setItemName("TV"); order.setCosts(4000.00);
		 * order.setCustomer(customer);
		 * 
		 * session.persist(order);
		 */

		/*
		 * Customer customer = session.get(Customer.class, 1);
		 * customer.getOrder().forEach(System.out::println);
		 */

		Customer customer = new Customer();
		customer.setCustomerMobile("8604237439");
		customer.setCustomerName("Shivam Tripathi2");

		Order order1 = new Order();
		order1.setCosts(500);
		order1.setItemName("FRIDGEs");

		Order order2 = new Order();
		order2.setCosts(601);
		order2.setItemName("PLAY STATION 5.1");
		

		customer.addOrder(order1);
		customer.addOrder(order2);
		
		session.persist(customer);

		
		// UPDATING ORDER with id::1 to id::4
		
		Customer customer4 = session.get(Customer.class, 4);
		Order order3 = session.get(Order.class, 1);
		order3.setCustomer(customer4);
		List<Order> orders2 = new ArrayList<Order>();
		orders2.add(order3);
	
		session.update(customer4);
		transaction.commit();

		session.close();
		sessionFactory.close();

	}

}
