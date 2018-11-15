package com.qa.persistance.respositry;

        import com.qa.persistance.domain.Account;
        import com.qa.persistance.util.JSONUtil;

        import javax.persistence.*;
        import javax.transaction.Transactional;
        import java.util.List;

        import static javax.transaction.Transactional.TxType.REQUIRED;
        import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class Service {
    @PersistenceContext(unitName = "primary")
    private EntityManager em;

//    public List<Account> findAllAccounts() {
//        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.accountNum", Account.class);
//        return query.getResultList();
//    }
//
//    public List<Account> deleteAccount() {
//        TypedQuery<Account> query = em.createQuery("DELETE FROM Account a", Account.class);
//        return query.getResultList();
//    }

    public Account findUser(Long accountNum) {
        return em.find(Account.class, accountNum);
    }

//    @Transactional(REQUIRED)
//    public String createAcccount(String acc) {
//        JSONUtil util = new JSONUtil();
//        Account account = util.getObjectForJSON(acc, Account.class);
//        em.persist(account);
//        return "{\"message\": \"account sucessfully added\"}";
//    } 10

    @Transactional(REQUIRED)
    public Account createUser(Account account) {
        em.persist(account);
        return account;
    }

    @Transactional(REQUIRED)
    public Account deleteUser(Account account) {
        em.remove(account);
        return account;
    }

    @Transactional(REQUIRED)
    public Account updateUser(Account account) {
        em.merge(account);
        return account;
    }
}
