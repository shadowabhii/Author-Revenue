package com.revenue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revenue.model.Transaction;


@Service
public class FinancialServicesImpl implements IFinancialServices {

	@Autowired
	private IFinancialsRepository financialsRepository;
	
	@Override
	public Integer bookPurchased(Transaction transaction) {
		Transaction purchasedBook = financialsRepository.save(transaction);
		return purchasedBook.gettId();
	}

}
