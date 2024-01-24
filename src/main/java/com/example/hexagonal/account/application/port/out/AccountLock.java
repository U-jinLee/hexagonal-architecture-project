package com.example.hexagonal.account.application.port.out;

import static com.example.hexagonal.account.domain.Account.AccountId;

public interface AccountLock {

    void lockAccount(AccountId accountId);

    void releaseAccount(AccountId accountId);

}