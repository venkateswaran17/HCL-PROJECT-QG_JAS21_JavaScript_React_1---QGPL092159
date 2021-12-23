package com.example.demo.repository;



import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Bill;


public interface BillRepository extends CrudRepository<Bill, Integer>{
	

}
