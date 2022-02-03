package com.revature.daos;

import java.util.List;
import com.revature.models.Account;

public interface AccountDao {
    public boolean create(Account account);
    public List<Account> readAll();
    public Account readByNumber(Account account);
    public boolean update(Account account);
    public boolean delete(Account account);
}