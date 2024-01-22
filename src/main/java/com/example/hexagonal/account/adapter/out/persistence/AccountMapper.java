package com.example.hexagonal.account.adapter.out.persistence;

import static com.example.hexagonal.account.domain.Account.*;
import static com.example.hexagonal.account.domain.Activity.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexagonal.account.domain.Account;
import com.example.hexagonal.account.domain.Activity;
import com.example.hexagonal.account.domain.ActivityWindow;
import com.example.hexagonal.account.domain.Money;

@Component
public class AccountMapper {

	Account mapToDomainEntity(AccountJpaEntity account,
		List<ActivityJpaEntity> activities,
		Long withdrawalBalance,
		Long depositBalance) {

		Money baselineBalance =
			Money.subtract(Money.of(depositBalance), Money.of(withdrawalBalance));

		return withId(
			new AccountId(account.getId()),
			baselineBalance,
			mapToActivityWindow(activities)
		);
	}

	ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
		List<Activity> mappedActivities = new ArrayList<>();

		for (ActivityJpaEntity activity : activities) {
			mappedActivities.add(new Activity(
				new ActivityId(activity.getId()),
				new AccountId(activity.getOwnerAccountId()),
				new AccountId(activity.getSourceAccountId()),
				new AccountId(activity.getTargetAccountId()),
				activity.getTimestamp(),
				Money.of(activity.getAmount())));
		}

		return new ActivityWindow(mappedActivities);
	}

}
