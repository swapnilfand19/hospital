package com.task.dao;

import java.util.List;


import com.task.model.Transaction;
public interface TransactionDAO 
{

	boolean saveTransaction(Transaction Transaction);

	boolean updateTransaction(Transaction Transaction);

	boolean deleteTransaction(Transaction Transaction);

	public Transaction getTransactionById(int TransactionId);
	
	List<Transaction> getTransaction();
	
}

