package org.example.money.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class MoneyChangingRequest {

    @Getter
    private final String moneyChangingRequestId;

    // 어떤 고객의 증액/감액 요청을 요청했는지의 멤버 정보
    @Getter
    private final String targetMembershipId;

    // 그 요청이 증액 요청인지 / 감액 요청인지
    @Getter
    private final int changingType; // enum. 0: 증액, 1: 감액

    // 증액 또는 감액 요청의 금액
    @Getter
    private final int changingMoneyAmount; // enum. 0: 요청, 1: 성공, 2: 실패

    // money 변액 요청에 대한 상태
    @Getter
    private final int changingMoneyStatus;

    @Getter private final String uuid;

    @Getter private final Date createdAt;

    public static MoneyChangingRequest generateMoneyChangingRequest(
            MoneyChangingRequestId moneyChangingRequestId,
            TargetMembershipId targetMembershipId,
            MoneyChangingType moneyChangingType,
            ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingStatus moneyChangingStatus,
            Uuid uuid
    ) {
        return new MoneyChangingRequest(
                moneyChangingRequestId.getMoneyChangingRequestId(),
                targetMembershipId.getTargetMembershipId(),
                moneyChangingType.getMoneyChangingType(),
                changingMoneyAmount.getChangingMoneyAmount(),
                moneyChangingStatus.getMoneyChangingStatus(),
                uuid.toString(),
                new Date()
        );
    }

    @Value
    public static class MoneyChangingRequestId {
        public MoneyChangingRequestId(String value) {
            this.moneyChangingRequestId = value;
        }

        private final String moneyChangingRequestId;
    }

    @Value
    public static class TargetMembershipId {
        public TargetMembershipId(String value) {
            this.targetMembershipId = value;
        }

        private final String targetMembershipId;
    }

    @Value
    public static class MoneyChangingType {
        public MoneyChangingType(int value) {
            this.moneyChangingType = value;
        }

        private final int moneyChangingType;
    }

    @Value
    public static class ChangingMoneyAmount {
        public ChangingMoneyAmount(int value) {
            this.changingMoneyAmount = value;
        }

        private final int changingMoneyAmount;
    }

    @Value
    public static class MoneyChangingStatus {
        public MoneyChangingStatus(int value) {
            this.moneyChangingStatus = value;
        }

        private final int moneyChangingStatus;
    }

    @Value
    public static class Uuid {
        public Uuid(UUID uuid) {
            this.uuid = uuid.toString();
        }

        private final String uuid;
    }
}
