package org.example.membership.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.example.common.PersistenceAdapter;
import org.example.membership.application.port.out.FindMembershipPort;
import org.example.membership.application.port.out.RegisterMembershipPort;
import org.example.membership.domain.Membership;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(new MembershipJpaEntity(
                membershipName.getMembershipName(),
                membershipAddress.getMembershipAddress(),
                membershipEmail.getMembershipEmail(),
                membershipIsValid.isMembershipIsValid(),
                membershipIsCorp.isMembershipIsCorp()
        ));
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
    }
}
