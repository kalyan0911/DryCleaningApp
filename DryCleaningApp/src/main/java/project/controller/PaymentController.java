package project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.models.Payment;
import project.services.IPaymentService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/Payment")
public class PaymentController {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private IPaymentService paymentService;
	
	//Add Payment
	@PostMapping("/add")
	public ResponseEntity<Object> addPayment(@RequestBody Payment payment) {
		ResponseEntity<Object> response=null;
		LOGGER.info("/Payment/add URL is opened");
		LOGGER.info("addPayment method executed");
		Payment p= paymentService.addPayment(payment);
		response = new ResponseEntity<Object>(p,HttpStatus.CREATED);
		return response;
	}
	
	//Remove Payment by id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removePayment(@PathVariable long id) throws Exception {
		LOGGER.info("/Payment/remove/{id} URL is opened");
		LOGGER.info("Remove method executed");
		ResponseEntity<Object> response=null;
		Payment p= paymentService.removePayment(id);
		response = new ResponseEntity<Object>(p,HttpStatus.OK);
		return response;
	}
	
	//Update Payment by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updatePayment(@PathVariable long id,@RequestBody Payment payment) throws Exception {
		LOGGER.info("/Payment/update/{id} URL is opened");
		LOGGER.info("Update method executed");
		ResponseEntity<Object> response=null;
		Payment p= paymentService.updatePayment(id, payment);
		response = new ResponseEntity<Object>(p,HttpStatus.OK);
		return response;
	}
	
	//Get payment details by id
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getPaymentDetails(@PathVariable long id)throws Exception {
		LOGGER.info("/Payment/get/{id} URL is opened");
		LOGGER.info("Get method executed");
		ResponseEntity<Object> response=null;
		Payment p= paymentService.getPaymentDetails(id);
		response = new ResponseEntity<Object>(p,HttpStatus.OK);
		return response;
	}
	
	//Get all payment details
	@GetMapping("/get")
	public ResponseEntity<Object> getAllPaymentDetails(){
		ResponseEntity<Object> response = null;
		LOGGER.info("/Payment/get URL is opened");
		LOGGER.info("Get method executed");
		List<Payment> lp= paymentService.getAllPaymentDetails();
		response=new ResponseEntity<Object>(lp,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getbycustomer/{custId}")
	public ResponseEntity<Object> getCustomerPaymentDetails(@PathVariable String custId)throws Exception{
		ResponseEntity<Object> response = null;
		LOGGER.info("/Payment/getbycustomer URL is opened");
		LOGGER.info("Get method executed");
		List<Payment> lp= paymentService.getCustomerPaymentDetails(custId);
		response=new ResponseEntity<Object>(lp,HttpStatus.OK);
		return response;
	}
}
