package com.example.hexagonal.account.application.port.in;

import static com.example.hexagonal.account.domain.Account.*;

import com.example.hexagonal.account.domain.Account;
import com.example.hexagonal.account.domain.Money;

public interface GetMoneyBalanceQuery {
	Money getAccountBalance(AccountId accountId);

}
