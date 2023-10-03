package org.example.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.banking.application.port.in.RegisterBankAccountCommand;
import org.example.banking.application.port.in.RegisterBankAccountUseCase;
import org.example.banking.domain.RegisteredBankAccount;
import org.example.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/register")
    RegisteredBankAccount registeredBankAccount(@RequestBody RegisterBankAccountRequest registerBankAccountRequest) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(registerBankAccountRequest.getMembershipId())
                .bankName(registerBankAccountRequest.getBankName())
                .bankAccountNumber(registerBankAccountRequest.getBankAccountNumber())
                .isValid(registerBankAccountRequest.isValid())
                .build();
        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerMembership(command);
        if (registeredBankAccount == null) {
            // TODO: Error Handling
            return null;
        }
        return registeredBankAccount;
    }
}
