package org.example.membership.application.port.in;

import org.example.membership.domain.Membership;

public interface FindMembershipUserCase {

    Membership findMembership(FindMembershipCommand command);
}
