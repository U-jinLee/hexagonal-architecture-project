package com.example.hexagonal.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

	private AccountId id;
	private Money money;
	private ActivityWindow activityWindow;

	public static Account withId(AccountId accountId,
		Money baselineBalance,
		ActivityWindow activityWindow) {
		return new Account(accountId, baselineBalance, activityWindow);
	}

	@Value
	public static class AccountId {
		public Long value;
	}

}
