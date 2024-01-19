package com.example.hexagonal.account.adapter.out.persistence;

import static com.example.hexagonal.account.domain.Account.*;

import java.time.LocalDateTime;

import com.example.hexagonal.account.application.port.out.LoadAccountPort;
import com.example.hexagonal.account.domain.Account;
import com.example.hexagonal.common.PersistenceAdapter;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort {

	private final SpringDataAccountRepository accountRepository;
	private final AccountMapper accountMapper;

	@Override
	public Account loadAccount(AccountId accountId, LocalDateTime baselineDate) {
		AccountJpaEntity account = accountRepository.findById(accountId.getId())
			.orElseThrow(EntityNotFoundException::new);

		return accountMapper.mapToDomainEntity();
	}
}
