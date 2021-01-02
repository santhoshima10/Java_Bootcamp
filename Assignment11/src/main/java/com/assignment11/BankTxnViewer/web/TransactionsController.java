package com.assignment11.BankTxnViewer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assignment11.BankTxnViewer.domain.Transaction;
import com.assignment11.BankTxnViewer.repository.TransactionRepository;
import com.assignment11.BankTxnViewer.service.TransactionService;

@Controller
public class TransactionsController {
	
	@Autowired
	private TransactionService txnService;
	
	@GetMapping("/transactions")
	public String getAllTransactions(ModelMap map) {
		
		List<Transaction> txnList = txnService.getAllTransactions();
		System.out.println(txnList.get(1).getType());
		map.put("transactions", txnList);
		
		
		return "transaction";
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getTransactionById(@PathVariable Long transactionId, ModelMap map) {
		
		Transaction txnRecord = txnService.getTransactionById(transactionId );
		
		
		
		map.put("transaction", txnRecord);
		
		
		return "transaction_detail";
	}

}
