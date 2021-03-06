package project.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import project.exception.NotFoundException;
import project.models.Booking;
import project.services.IBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
	@Autowired
	private IBookingService bookingService;
	
	//Add a booking
	@PostMapping("/add")
	public ResponseEntity<Object> addBooking(@RequestBody Booking booking) {
		LOGGER.info("/bookings/add URL is opened");
		LOGGER.info("add Booking method executed");
		Booking b=bookingService.addBooking(booking);
		ResponseEntity<Object> response=new ResponseEntity<Object>(b,HttpStatus.CREATED);
		return response;
	}
	//Remove all the booking by id
	@DeleteMapping("/remove/{bookingId}")
	public ResponseEntity<Object> removeBooking(@PathVariable long bookingId) throws Exception {
		LOGGER.info("/bookings/add URL is opened");
		LOGGER.info("RemoveBooking method executed");
		ResponseEntity<Object> response=null;
		Booking b = bookingService.removeBooking(bookingId);
		response=new ResponseEntity<Object>(b,HttpStatus.OK);
		return response;
	}
	
	//Update all the booking by id
	@PutMapping("/update/{bookingId}")
	public ResponseEntity<Object> updateBooking(@PathVariable long bookingId, @RequestBody Booking booking) throws NotFoundException {
		LOGGER.info("/bookings//update/{bookingId} URL is opened");
		LOGGER.info("add Booking method executed");
		ResponseEntity<Object>response=null;
		Booking b = bookingService.updateBooking(bookingId, booking);
		response=new ResponseEntity<>(b, HttpStatus.ACCEPTED);
		return response;
}

	//Get by booking id
	@GetMapping("/get/{bookingId}")
	public ResponseEntity <Object> getBooking(@PathVariable long bookingId) throws Exception{
		LOGGER.info("/bookings///get/{bookingId} URL is opened");
		LOGGER.info("Get Booking method executed");
		ResponseEntity <Object>response=null;
		Booking b=bookingService.getBooking(bookingId);
		response=new ResponseEntity<>(b, HttpStatus.ACCEPTED);		
		return response;
	}
	//Get all the bookings
	@GetMapping("/get")
	public ResponseEntity<Object> getAllBookings(){
		ResponseEntity<Object> response=null;
		LOGGER.info("/bookings/add URL is opened");
		LOGGER.info("getAllBookings method executed");
		List<Booking> lb= bookingService.getAllBookings();
		response=new ResponseEntity<Object>(lb,HttpStatus.OK);
		return response;
	}
	
	//Get all the bookings for a specific date
	@GetMapping("/getbydate/{date}")
	public ResponseEntity<Object> getBookingsByDate(@PathVariable String date){
		ResponseEntity<Object> response=null;
		LOGGER.info("/bookings/getbydate/"+date+ " URL is opened");
		LOGGER.info("getbydate method executed");
		LocalDate myDate=LocalDate.parse(date);
		List<Booking> lb=bookingService.getBookingsByDate(myDate);
		response=new ResponseEntity<Object>(lb,HttpStatus.OK);
		return response;
	}
	
	//Get bookings by customer id
	
	@GetMapping("/getbycustomer/{customerId}")
	public ResponseEntity<Object> getBookingsByCustomer(@PathVariable String customerId) throws Exception{
		LOGGER.info("/bookings/getbycustomer/{customerId} URL is opened");
		LOGGER.info("getbycustomer method executed");
		ResponseEntity<Object>response=null;
		List<Booking> lb=bookingService.getBookingsByCustomer(customerId);
		response=new ResponseEntity<>(lb, HttpStatus.ACCEPTED);		
		return response;
	}
}
	
