package com.assignment11.BankTxnViewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment11.BankTxnViewer.domain.Transaction;
import com.assignment11.BankTxnViewer.repository.TransactionRepository;

@Service
public class TransactionService {
	
	
	@Autowired
	private TransactionRepository txnRepo;
	
	public List<Transaction> getAllTransactions(){
		return txnRepo.findAll();
	}

	public Transaction getTransactionById(Long transactionId) {
		// TODO Auto-generated method stub
		return txnRepo.findById(transactionId);
	}

}
