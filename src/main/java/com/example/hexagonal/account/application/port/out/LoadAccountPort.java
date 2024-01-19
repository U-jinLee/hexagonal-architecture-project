package com.example.hexagonal.account.application.port.out;

import static com.example.hexagonal.account.domain.Account.*;

import java.time.LocalDateTime;

import com.example.hexagonal.account.domain.Account;

public interface LoadAccountPort {
	Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}