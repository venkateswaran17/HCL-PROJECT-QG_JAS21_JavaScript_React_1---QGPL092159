package com.example.demo.controller;
import java.sql.SQLException;
import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;



    @CrossOrigin(origins = "http://localhost:3004")
    @RestController
    @RequestMapping("/api/v1/")
    public class CustomerController {

    	@Autowired
    	private CustomerRepository customerRepository;
    	
    	// get all employees
    	@GetMapping("/customer")
    	public List<Customer> getAllCustomer(){
    		return customerRepository.findAll();
    	}		
    	
    	// create employee rest api
    	@PostMapping("/customer")
    	public Customer createCustomer(@RequestBody Customer customer) {
    		return customerRepository.save(customer);
    	}
    	
    	// get employee by id rest api
    	@GetMapping("/customer/{id}")
    	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) throws ResourceNotFoundException {
    		Customer customer = customerRepository.findById(id)
    				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
    		return ResponseEntity.ok(customer);
    	}
    	
    	// update employee rest api
    	
    	@PutMapping("/customer/{id}")
    	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customerDetails) throws ResourceNotFoundException{
    		Customer customer = customerRepository.findById(id)
    				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
    		
    		customer.setFirstName(customerDetails.getFirstName());
    		customer.setLastName(customerDetails.getLastName());
    		customer.setAge(customerDetails.getAge());
    		customer.setGender(customerDetails.getGender());
    		customer.setMobileNumber(customerDetails.getMobileNumber());
    		customer.setEmail(customerDetails.getEmail());
    		
    		Customer updatedCustomer = customerRepository.save(customer);
    		return ResponseEntity.ok(updatedCustomer);
    	}
    	
    	// delete employee rest api
    	@DeleteMapping("/customer/{id}")
    	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Integer id) throws SQLException, ResourceNotFoundException{
    		Customer customer = customerRepository.findById(id)
    				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
    		
    		customerRepository.delete(customer);
    		Map<String, Boolean> response = new HashMap<>();
    		response.put("deleted", Boolean.TRUE);
    		return ResponseEntity.ok(response);
    	}
    	
    	
    }
    
   
   
    
    
    
    