package com.example.hexagonal.account.application.port.in;

import com.example.hexagonal.account.domain.Money;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import static com.example.hexagonal.account.domain.Account.AccountId;

@Getter

public class SendMoneyCommand {
    @NotNull
    private final AccountId sourceAccountId;
    @NotNull
    private final AccountId targetAccountId;
    @NotNull
    private final Money money;

    public SendMoneyCommand(
            AccountId sourceAccountId,
            AccountId targetAccountId,
            Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
    }

}
