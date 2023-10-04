package org.example.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

    private String moneyChangingRequestId;

    // 증액, 감액
    private int moneyChangingType; // 0: 증액, 1: 감액

    private int moneyChangingResultStatus;

    private int amount;
}
