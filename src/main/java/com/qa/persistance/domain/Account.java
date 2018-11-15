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

    public Account(Long accountNum, String forename, String surname) {
        this.accountNum = accountNum;
        this.forename = forename;
        this.surname = surname;
    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}


