package com.bootcamp.transaction.service;

import com.bootcamp.transaction.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Flux<Transaction> getTransactions();
    Mono<Transaction> getTransaction(String id);
    Mono<Transaction> registerTransaction(Mono<Transaction> transaction);
    Mono<Transaction> updateTransaction(String id, Mono<Transaction> transaction);
    Mono<Void> removeTransaction(String id);
}