package com.example.hexagonal.account.application.port.out;

import com.example.hexagonal.account.domain.Account;

public interface UpdateAccountStatePort {

	void updateActivities(Account account);

}
