package com.qa.persistance.domain;

import javax.persistence.*;

@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNum;
    @Column(length = 100)
    private String forename;
    @Column(length = 100)
    private String surname;
}
