package com.bootcamp.transaction.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String transactionType;
    private String accountId;
    private String amount;
    private String transactionDate;
    private String description;
}