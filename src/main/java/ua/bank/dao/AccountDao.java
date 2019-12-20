package ua.bank.dao;

import ua.bank.entity.Account;
import ua.bank.entity.Transaction;

public abstract interface AccountDao {
    Account getAccount(Integer id);

    void updateAccount(Account account, Transaction transaction);
    void updateAccount(Account fromAcc, Account toAcc, Transaction transaction);
}

