package com.bootcamp.transaction.service;

import com.bootcamp.transaction.model.Transaction;
import com.bootcamp.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Flux<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Mono<Transaction> getTransaction(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Mono<Transaction> registerTransaction(Mono<Transaction> transaction) {
        return transaction.flatMap(transactionRepository::insert);
    }

    @Override
    public Mono<Transaction> updateTransaction(String id, Mono<Transaction> transaction) {
        return transactionRepository.findById(id)
                .flatMap(t -> transaction)
                .doOnNext(e -> e.setId(id))
                .flatMap(transactionRepository::save);
    }

    @Override
    public Mono<Void> removeTransaction(String id) {
        return transactionRepository.deleteById(id);
    }
}