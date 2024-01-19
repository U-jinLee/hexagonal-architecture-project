package com.example.hexagonal.account.application.service;

import java.time.LocalDateTime;

import com.example.hexagonal.account.application.port.in.SendMoneyCommand;
import com.example.hexagonal.account.application.port.in.SendMoneyUseCase;
import com.example.hexagonal.account.application.port.out.LoadAccountPort;
import com.example.hexagonal.account.domain.Account;
import com.example.hexagonal.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {

        LocalDateTime baselineDate = LocalDateTime.now().minusDays(10);

        Account sourceAccount =
            loadAccountPort.loadAccount(command.getSourceAccountId(), baselineDate);

        //todo 비즈니스 규칙 검증
        //todo 모델 상태 조작
        //todo 출력값 반환
        return false;
    }
}
