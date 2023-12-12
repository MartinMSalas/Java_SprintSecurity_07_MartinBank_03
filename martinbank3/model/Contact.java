package com.martin.egg.martinbank3.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "contact_messages")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy="native")
    @Column(name ="contact_id")
    private String contactId;
    @Column(name ="contact_name")
    private String contactName;
    @Column(name ="contact_email")
    private String contactEmail;

    private String subject;
    private String message;
    @Column(name ="create_dt")
    private Date createDt;
}
