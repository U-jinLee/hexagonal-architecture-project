package com.example.hexagonal.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

	private final AccountId id;
	private final Money baselineBalance;
	private final ActivityWindow activityWindow;

	public static Account withoutId(Money baselineBalance,
								 ActivityWindow activityWindow) {
		return new Account(null, baselineBalance, activityWindow);
	}

	public static Account withId(AccountId accountId,
		Money baselineBalance,
		ActivityWindow activityWindow) {
		return new Account(accountId, baselineBalance, activityWindow);
	}

	public Money calculateBalance() {
		return Money.add(
				this.baselineBalance,
				this.activityWindow.calculateBalance(this.id));
	}

	public boolean withdraw(Money money, AccountId targetAccountId) {
		if(!mayWithdraw(money)) return false;

		Activity withdrawal = new Activity(
				this.id,
				this.id,
				targetAccountId,
				LocalDateTime.now(),
				money);

		this.activityWindow.addActivity(withdrawal);

		return true;
	}

	private boolean mayWithdraw(Money money) {
		return money.add(
				this.calculateBalance(),
				money.negate()
		).isPositiveOrZero();
	}

	public boolean deposit(Money money, AccountId sourceAccountId) {
		Activity deposit = new Activity(
				this.id,
				sourceAccountId,
				this.id,
				LocalDateTime.now(),
				money);

		this.activityWindow.addActivity(deposit);

		return true;
	}

	@Value
	public static class AccountId {
		public Long value;
	}

}
