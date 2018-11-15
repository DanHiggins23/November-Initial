package com.qa.persistance.respositry;

import com.qa.util.JSONUtil;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return null;
    }

    @Override
    @Transactional(REQUIRED)
    public String createUser(String account) {
        em.persist(account);
        return account;
    }

    @Override
    @Transactional(REQUIRED)
    public String updateUser(Integer accountNum, String account) {
        em.merge(account);
        return account;
    }

    @Override
    @Transactional(REQUIRED)
    public Integer deleteUser(Integer accountNum) {
        em.remove(accountNum);
        return accountNum;
    }
}
