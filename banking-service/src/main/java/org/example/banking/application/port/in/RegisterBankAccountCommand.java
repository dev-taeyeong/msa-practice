package org.example.banking.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.example.common.SelfValidating;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    @NonNull
    private final String membershipId;

    @NonNull
    private final String bankName;

    @NonNull
    @NotBlank
    private final String bankAccountNumber;

    private final boolean isValid;

    public RegisterBankAccountCommand(@NonNull String membershipId, @NonNull String bankName, @NonNull String bankAccountNumber, boolean isValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;

        validateSelf();
    }
}
