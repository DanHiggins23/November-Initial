package com.qa.business;

import com.qa.persistance.respositry.IAccountInterface;

import javax.inject.Inject;

public class AccountServiceImpl implements AccountService {
    @Inject
    private IAccountInterface repo;

    @Override
    public String getAllAccounts() {
        return repo.getAllAccounts();
    }

    @Override
    public String createUser(String account) {
        return repo.createUser(account);
    }

    @Override
    public String updateUser(Integer accountNum, String account) {
        return repo.updateUser(accountNum, account);
    }

    @Override
    public Integer deleteUser(Integer accountNum) {
        return repo.deleteUser(accountNum);
    }
}