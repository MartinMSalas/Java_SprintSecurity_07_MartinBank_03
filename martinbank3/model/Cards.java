package com.martin.egg.martinbank3.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cards")
@Data
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy="native")
    @Column(name = "card_id")
    private int cardId;

    @Column(name = "customer_id")
    private int customerId;
    @Column(name= "card_number")
    private String cardNumber;
    @Column(name= "card_type")
    private String cardType;
    @Column(name= "card_limit")
    private int cardLimit;
    @Column(name="amount_used")
    private int amountUsed;
}
