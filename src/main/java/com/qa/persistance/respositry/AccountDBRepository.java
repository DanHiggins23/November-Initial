package com.qa.persistance.respositry;

import com.qa.persistance.domain.Account;
import com.qa.util.JSONUtil;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements IAccountInterface {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Inject
    private JSONUtil util;

    @Override
    public String getAllAccounts() {
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.accountNum ASC", Account.class);
        return util.getJSONForObject(query.getResultList());
    }

    @Override
    @Transactional(REQUIRED)
    public String createUser(String jsonString) {
        Account newAccount = util.getObjectForJSON(jsonString, Account.class);
        em.persist(newAccount);
        return "{message: account created}";
    }

    @Override
    @Transactional(REQUIRED)
    public String updateUser(Integer accountNum, String account) {
        Account newAccount = util.getObjectForJSON(account, Account.class);
        em.merge(newAccount);
        return account;
    }

    @Override
    @Transactional(REQUIRED)
    public Integer deleteUser(Integer accountNum) {
        em.remove(accountNum);
        return accountNum;
    }
}
