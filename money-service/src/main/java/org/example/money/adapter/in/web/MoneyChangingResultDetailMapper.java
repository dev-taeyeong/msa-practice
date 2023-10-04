package org.example.money.adapter.in.web;

import org.example.money.adapter.in.web.MoneyChangingResultDetail;
import org.example.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import org.example.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingResultDetailMapper {

    public MoneyChangingResultDetail mapToMoneyChangingResultDetail(MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity) {
        return new MoneyChangingResultDetail(
                moneyChangingRequestJpaEntity.getMoneyChangingRequestId() + "",
                moneyChangingRequestJpaEntity.getMoneyChangingType(),
                moneyChangingRequestJpaEntity.getChangingAmountStatus(),
                moneyChangingRequestJpaEntity.getMoneyAmount()
        );
    }
}
