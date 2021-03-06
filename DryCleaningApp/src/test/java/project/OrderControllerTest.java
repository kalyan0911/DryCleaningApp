package project;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import project.controller.OrderController;
import project.exception.NotFoundException;
import project.models.Address;
import project.models.Booking;
import project.models.Customer;
import project.models.CustomerItem;
import project.models.Order;
import project.services.IOrderService;

@SpringBootTest
public class OrderControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderControllerTest.class);
	@Autowired
	private OrderController orderController;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	Order order=null;
	CustomerItem customerItem=null;
	
	@Test
	public void addOrderTest01() {
		LOGGER.info("addOrderTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(2,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		assertEquals (orderController.addOrder(order).getStatusCode(),HttpStatus.CREATED);
	}
	
	@Test
	public void updateOrderTest01() throws Exception{
		LOGGER.info("updateOrderTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(2,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		try {
		assertEquals (orderController.updateOrder(2, order).getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getOrderDetailsTest01() throws Exception{
		LOGGER.info("getOrderDetailsTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		try {
		assertEquals (orderController.getOrderDetails(2).getStatusCode(),HttpStatus.OK);
		}
		catch(NotFoundException ex) {
			assertEquals("Order id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllOrdersTest01(){
		LOGGER.info("getAllOrderTest01 method executed");
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
		order=new Order(1,5000.00,LocalDate.parse("2021-05-03"),customer,"Online",booking);
		assertEquals (orderController.getAllOrders().getStatusCode(),HttpStatus.OK);
	}
}
