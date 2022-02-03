package com.revature.services;

import java.util.List;
import com.revature.models.Account;
import com.revature.daos.AccountDao;
import com.revature.daos.AccountDaoImplementation;

public class AccountService {
    private final AccountDao accountDao = new AccountDaoImplementation();

    public boolean create(Account account) { return accountDao.create(account); }

    public List<Account> readAll() { return accountDao.readAll(); }

    public Account readByNumber(Account account) { return accountDao.readByNumber(account); }

    public boolean update(Account account) {
        return accountDao.update(account);
    }

    public boolean delete(Account account) {
        return accountDao.delete(account);
    }
}