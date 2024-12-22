package com.bootcamp.transaction.mapper;

import com.bootcamp.transaction.model.Transaction;
import com.bootcamp.transaction.model.TransactionRequest;
import com.bootcamp.transaction.model.TransactionResponse;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper implements EntityMapper<Transaction, TransactionResponse, TransactionRequest> {

    @Override
    public TransactionResponse toModel(Transaction domain) {
        TransactionResponse transaction = new TransactionResponse();
        transaction.setId(domain.getId());
        transaction.setTransactionType(domain.getTransactionType());
        transaction.setAccountId(domain.getAccountId());
        transaction.setAmount(domain.getAmount());
        transaction.setTransactionDate(domain.getTransactionDate());
        transaction.setDescription(domain.getDescription());
        return transaction;
    }

    @Override
    public Transaction toDocument(TransactionRequest model) {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(model.getTransactionType());
        transaction.setAccountId(model.getAccountId());
        transaction.setAmount(model.getAmount());
        transaction.setTransactionDate(model.getTransactionDate());
        transaction.setDescription(model.getDescription());
        return transaction;
    }
}