package es.com.springdemo.rest;

import java.util.List;

import es.com.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.com.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();
	}

	// add mapping fot GET /customers/{customervId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer customer = customerService.getCustomer(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundExcepcion("Customer id not found " + customerId);
		}
		
		return customerService.getCustomer(customerId);
	}
	
	
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		customer.setId(0);	
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
			
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) {
			
		Customer customer = customerService.getCustomer(customerId);
		
		if(customer == null) {
			
			throw new CustomerNotFoundExcepcion("Customer id is not found() "  + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return customerService.getCustomer(customerId);
	}
		
	
	
	
	
	
	
}
