package com.qa.persistance.respositry;

import com.qa.persistance.domain.Account;
import com.qa.util.JSONUtil;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.HashMap;

@Alternative
public class AccountMapRepository implements IAccountInterface {
    private HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();
    private Integer accountNum;

    @Inject
    private JSONUtil util;

    @Override
    public String getAllAccounts() {
        return null;
    }

    @Override
    public String createUser(String account) {
        accountNum++;
        Account newAccount = util.getObjectForJSON(account, Account.class);
        accounts.put(accountNum, newAccount);
        return account;
    }

    @Override
    public String updateUser(Integer accountNum, String accountToUpdate) {
        Account newAccount = util.getObjectForJSON(accountToUpdate, Account.class);
        accounts.put(accountNum, newAccount);
        return accountToUpdate;
    }

    @Override
    public Integer deleteUser(Integer accountNum) {
        accounts.remove(accountNum);
        return accountNum;
    }
}
