package com.assignment11.BankTxnViewer.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.assignment11.BankTxnViewer.domain.Transaction;

@Repository
public class TransactionRepository {
	
	private List<Transaction> transactionData = new ArrayList<>(100);
	
	public TransactionRepository() {
		populateTransactionData();
	}
	
	public List<Transaction> findAll(){
		return transactionData;
	}
	
	private void populateTransactionData() {
		
		String line = "";
		BufferedReader reader =null;
		
		try {
			 reader = new BufferedReader(new FileReader("transactions.txt"));
			
			line = reader.readLine();
			
			while(line != null) {
				//System.out.println(line);
				transactionData.add(parseData(line));
				line = reader.readLine();
			}
			 
			System.out.print("The count is :"+transactionData.size());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				
	}
	
	private Transaction parseData(String data) {
		
        Transaction txn = new Transaction();
        txn.setId(Long.parseLong(data.split(",")[0]));
        txn.setRetailer(data.split(",")[1]);
        txn.setDescription(data.split(",")[2]);
        txn.setDate(LocalDateTime.parse(data.split(",")[3]));
        txn.setAmount(new BigDecimal(data.split(",")[4]));
        txn.setType(data.split(",")[5]);
		
		return txn;
	}

	public Transaction findById(Long transactionId) {
		Transaction txnRec = null;
		for(Transaction txn : transactionData)	{
			if(txn.getId().compareTo(transactionId) == 0) {
				txnRec = txn;
				break;
			}
		}
		return txnRec;
	}

}
