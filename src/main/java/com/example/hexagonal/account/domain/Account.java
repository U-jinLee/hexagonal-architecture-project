package com.example.hexagonal.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

	private final AccountId id;
	private final Money money;
	private final ActivityWindow activityWindow;

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
