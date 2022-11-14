package com.revenue.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revenue.model.Transaction;

public interface IFinancialsRepository extends JpaRepository<Transaction, Integer> {

}
