package com.wwwgomes.customermanager.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wwwgomes.customermanager.domain.entities.Customer;
import com.wwwgomes.customermanager.domain.repository.CustomerRepository;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerResource {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping(produces = "application/json")
	public List<Customer> findByName(@RequestParam(name = "name") String customerName) {

		var customers = customerRepository.findByFullNameContaining(customerName);

		return customers;
	}

	@GetMapping(value = "/{customerId}", produces = "application/json")
	public ResponseEntity<Customer> findById(@PathVariable Long customerId) {

		var customer = customerRepository.findById(customerId);

		if (customer.isPresent())
			return ResponseEntity.ok(customer.get());

		return ResponseEntity.notFound().build();
	}


}
