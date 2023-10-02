package org.example.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.common.WebAdapter;
import org.example.membership.application.port.in.RegisterMembershipCommand;
import org.example.membership.application.port.in.RegisterMembershipUseCase;
import org.example.membership.domain.Membership;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest registerMembershipRequest) {
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(registerMembershipRequest.getName())
                .address(registerMembershipRequest.getAddress())
                .email(registerMembershipRequest.getEmail())
                .isValid(true)
                .isCorp(registerMembershipRequest.isCorp())
                .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
