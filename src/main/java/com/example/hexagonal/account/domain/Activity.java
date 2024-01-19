package com.example.hexagonal.account.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Getter
@NonNull
@RequiredArgsConstructor
@Value
public class Activity {

	private ActivityId id;

	private final Account.AccountId ownerAccountId;

	private final Account.AccountId sourceAccountId;

	private final Account.AccountId targetAccountId;

	private final LocalDateTime timeStamp;

	private final Money money;

	public Activity(
		@NonNull Account.AccountId ownerAccountId,
		@NonNull Account.AccountId sourceAccountId,
		@NonNull Account.AccountId targetAccountId,
		@NonNull LocalDateTime timeStamp,
		@NonNull Money money) {
		this.id = null;
		this.ownerAccountId = ownerAccountId;
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.timeStamp = timeStamp;
		this.money = money;
	}

	@Value
	public static class ActivityId {
		private final Long value;
	}

}