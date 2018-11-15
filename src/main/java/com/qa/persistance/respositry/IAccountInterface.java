package com.qa.persistance.respositry;

public interface IAccountInterface {
    String getAllAccounts();
    String createUser(String account);
    String updateUser(Integer accountNum, String account);
    Integer deleteUser(Integer accountNum);
}
