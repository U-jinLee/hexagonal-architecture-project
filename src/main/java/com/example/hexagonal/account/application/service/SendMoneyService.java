package com.example.hexagonal.account.application.service;

import com.example.hexagonal.account.application.port.in.SendMoneyUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    @Override
    public boolean sendMoney() {
        //todo 비즈니스 규칙 검증
        //todo 모델 상태 조작
        //todo 출력값 반환
        return false;
    }
}
