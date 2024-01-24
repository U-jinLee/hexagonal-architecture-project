package com.example.hexagonal.account.application.service;

import com.example.hexagonal.account.application.port.in.GetAccountBalanceQuery;
import com.example.hexagonal.account.domain.Account;
import com.example.hexagonal.account.domain.Money;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

	@Override
	public Money getAccountBalance(Account.AccountId accountId) {
		return null;
	}
}
