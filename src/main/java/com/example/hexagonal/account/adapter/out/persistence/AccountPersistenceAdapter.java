package com.example.hexagonal.account.adapter.out.persistence;

import static com.example.hexagonal.account.domain.Account.*;

import java.time.LocalDateTime;
import java.util.List;

import com.example.hexagonal.account.application.port.out.LoadAccountPort;
import com.example.hexagonal.account.domain.Account;
import com.example.hexagonal.common.PersistenceAdapter;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort {

	private final SpringDataAccountRepository accountRepository;
	private final ActivityRepository activityRepository;
	private final AccountMapper accountMapper;

	@Override
	public Account loadAccount(AccountId accountId,
		LocalDateTime baselineDate) {

		AccountJpaEntity account = accountRepository.findById(accountId.getValue())
			.orElseThrow(EntityNotFoundException::new);

		List<ActivityJpaEntity> activities =
			activityRepository.findByOwnerSince(accountId.getValue(), baselineDate);

		Long withdrawalBalance = orZero(activityRepository.getWithdrawalBalanceUntil(
			accountId.getValue(),
			baselineDate
		));

		Long depositBalance = orZero(activityRepository.getDepositBalanceUntil(
			accountId.getValue(),
			baselineDate
		));

		return accountMapper.mapToDomainEntity(account,
			activities,
			withdrawalBalance,
			depositBalance);
	}

	private Long orZero(Long value) {
		return value == null ? 0L : value;
	}

}
