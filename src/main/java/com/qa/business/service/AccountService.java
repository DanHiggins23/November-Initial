package com.qa.business.service;

public interface AccountService {
    String getAllAccounts();
    String createUser(String account);
    String updateUser(Integer accountNum, String account);
    Integer deleteUser(Integer accountNum);
}

