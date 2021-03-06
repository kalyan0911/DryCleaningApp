package project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import project.models.CustomerItem;
import project.services.ICustomerItemService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customeritem")
public class CustomerItemController {
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerItemController.class);
	
	@Autowired
	private ICustomerItemService customerItemService;
	
	//Add CustomerItem 
	@PostMapping("/add")
	public ResponseEntity<Object> addItem(@RequestBody CustomerItem item) {
		ResponseEntity<Object> response=null;
		LOGGER.info("/customeritem/add URL is opened");
		LOGGER.info("add Customer method executed");
		CustomerItem ci=customerItemService.addItem(item);
		response= new ResponseEntity<Object>(ci,HttpStatus.CREATED);
		return response;
	}
	
	//Remove CustomerItem by id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeItem(@PathVariable long id)throws Exception {
		LOGGER.info("/customeritem//remove/{id} URL is opened");
		LOGGER.info("Remove Customer method executed");
		ResponseEntity<Object> response = null;
		CustomerItem ci= customerItemService.removeItem(id);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
	
	//Update CustomerItem by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateItem(@PathVariable long id,@RequestBody CustomerItem item) throws Exception{
		LOGGER.info("/customeritem/update/{id} URL is opened");
		LOGGER.info("Update Customer method executed");
		ResponseEntity<Object> response = null;
		CustomerItem ci=customerItemService.updateItem(id, item);
		response = new ResponseEntity<Object>(ci, HttpStatus.ACCEPTED);
		return response;
	}
	
	//Get Item by id
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getItem(@PathVariable long id) throws Exception{
		LOGGER.info("/customeritem/get/{id} URL is opened");
		LOGGER.info("Get Customer method executed");
		ResponseEntity<Object> response = null;
		CustomerItem ci= customerItemService.getItem(id);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
	
	//Get by customerId
	@GetMapping("/getbycustomer/{customerId}")
	public ResponseEntity<Object> getItemsByCustomer(@PathVariable String customerId)throws Exception{
		LOGGER.info("/customeritem/getbycustomer/{customerId URL is opened");
		LOGGER.info("Get Customer method executed");
		ResponseEntity<Object> response = null;
		List<CustomerItem> ci= customerItemService.getItemsByCustomer(customerId);
		response = new ResponseEntity<Object>(ci, HttpStatus.OK);
		return response;
	}
}
