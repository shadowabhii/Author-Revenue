package com.revenue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.revenue.model.Transaction;
import com.revenue.service.FinancialServicesImpl;
import com.revenue.service.IFinancialServices;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RevenueController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private IFinancialServices financialServices;
	
	@GetMapping("/revenue/{author}")
	public Double getTotalRevenue(@PathVariable("author") String author) {

		System.out.println("inside reader");
		// code for linking 2 microservice where record list will be set to Book

		Double totalPrice  = this.restTemplate.getForObject("http://localhost:8084/totalrevenue/" + author, Double.class);
		// List record =
		// this.restTemplate.getForObject("http://RECORD-SERVICE/record/emp/"+eId,
		// List.class);

		return totalPrice;
	}
	
	@PostMapping("/transaction")
	public Integer bookPurchasedTransaction(@RequestBody Transaction transaction) {

		Integer id = financialServices.bookPurchased(transaction);
		return id;
	}

}
