package org.example.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.example.common.UseCase;
import org.example.membership.adapter.out.persistence.MembershipJpaEntity;
import org.example.membership.adapter.out.persistence.MembershipMapper;
import org.example.membership.application.port.in.FindMembershipCommand;
import org.example.membership.application.port.in.FindMembershipUserCase;
import org.example.membership.application.port.out.FindMembershipPort;
import org.example.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class FindMembershipService implements FindMembershipUserCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomainEntity(entity);
    }
}
