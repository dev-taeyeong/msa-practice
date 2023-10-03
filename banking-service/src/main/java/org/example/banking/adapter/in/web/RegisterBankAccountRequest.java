package org.example.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NonNull
public class RegisterBankAccountRequest {

    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;
}
