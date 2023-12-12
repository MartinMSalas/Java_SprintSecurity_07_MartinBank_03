package com.martin.egg.martinbank3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "account_transactions")
public class AccountTransactions {

    @Id
    @Column(name= "transaction_id")
    private String transactionId;

    @Column(name= "account_number")
    private Long accountNumber;
    @Column(name="customer_id")
    private int customerId;
    @Column(name="transaction_type")
    private String transactionType;
    @Column(name="transaction_amt")
    private int transactionAmt;
    @Column(name="transaction_dt")
    private String transactionDt;
    @Column(name="transaction_summary")
    private String transactionSummary;
}
