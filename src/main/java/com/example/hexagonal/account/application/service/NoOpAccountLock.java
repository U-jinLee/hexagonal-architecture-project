package com.example.hexagonal.account.application.service;

import com.example.hexagonal.account.application.port.out.AccountLock;
import com.example.hexagonal.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class NoOpAccountLock implements AccountLock {
    @Override
    public void lockAccount(Account.AccountId accountId) {
        //do nothing
    }

    @Override
    public void releaseAccount(Account.AccountId accountId) {
        //do nothing
    }
}
