package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	public List<Customer> findAll();

}
