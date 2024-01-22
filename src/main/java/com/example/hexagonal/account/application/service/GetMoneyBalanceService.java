package com.example.hexagonal.account.application.service;

import com.example.hexagonal.account.application.port.in.GetMoneyBalanceQuery;
import com.example.hexagonal.account.application.port.out.LoadAccountPort;
import com.example.hexagonal.account.domain.Account;
import com.example.hexagonal.account.domain.Money;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetMoneyBalanceService implements GetMoneyBalanceQuery {


	@Override
	public Money getAccountBalance(Account.AccountId accountId) {
		return null;
	}
}
