package com.example.hexagonal.account.domain;

import lombok.Value;

public class Account {

	private AccountId id;
	private Money money;
	private ActivityWindow activityWindow;

	@Value
	public static class AccountId {
		public Long id;
	}

}
