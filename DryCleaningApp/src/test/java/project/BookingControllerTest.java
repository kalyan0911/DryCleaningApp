package project;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;

import project.controller.BookingController;
import project.exception.NotFoundException;
import project.models.Address;
import project.models.Booking;
import project.models.Customer;
import project.models.CustomerItem;
import project.services.IBookingService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BookingControllerTest {
	static final Logger LOGGER = LoggerFactory.getLogger(BookingControllerTest.class);
	
	@Autowired
	private BookingController bookingController;
	
	Address address=null;
	Customer customer=null;
	Booking booking=null;
	CustomerItem customerItem=null;
	
	@BeforeAll
	public  void init() {
		address=new Address("a-210","Balewadi","Baner","Pune","Maharashtra",12345);
		customer=new Customer("6","xyz","Anand","anand@gmail.com","1234567",LocalDate.parse("1994-05-12"),address);
		customerItem=new CustomerItem(7,"SalwarSuit","Black","Dress",10,"Silk","Foradults",customer);
		booking=new Booking(1,LocalDate.parse("2021-05-10"),LocalTime.parse("05:00:00"),"Online", customerItem);
	}
	
	@Test
	public void addBookingTest01() {
		LOGGER.info("addBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.addBooking(booking);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
	}
	
	@Test
	public void updateBookingTest01() throws NotFoundException {
		LOGGER.info("updateBookingTest01 method executed");
		try {
			ResponseEntity<Object> response= bookingController.updateBooking(1, booking);
			assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		}
		catch(NotFoundException ex) {
			assertEquals("Booking Id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getBookingTest01() throws Exception {
		LOGGER.info("getBookingTest01 method executed");
		try {
		ResponseEntity<Object> response= bookingController.getBooking(1);
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		}
		catch(NotFoundException ex) {
			assertEquals("Booking id is not valid",ex.getMessage());
		}
	}
	
	@Test
	public void getAllBookingTest01() {
		LOGGER.info("getAllBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.getAllBookings();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		}
	
	@Test
	public void getBookingsByDateTest01() {
		LOGGER.info("getAllBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.getBookingsByDate("2025-03-04");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		}
	
	@Test
	public void getBookingsByCustomersTest01() throws Exception {
		LOGGER.info("getAllBookingTest01 method executed");
		ResponseEntity<Object> response= bookingController.getBookingsByCustomer("7");
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		}
}
