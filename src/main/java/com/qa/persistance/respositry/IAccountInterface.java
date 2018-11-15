package com.qa.persistance.respositry;

public interface IAccountInterface {
    String getAllAccounts();
    String createUser(String jsonString);
    String updateUser(Integer accountNum, String account);
    Integer deleteUser(Integer accountNum);
}
