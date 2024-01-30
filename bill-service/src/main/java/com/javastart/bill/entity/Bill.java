package com.javastart.bill.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime createDate;

    private Boolean overdraftEnable;

    public Bill(Long accountId, BigDecimal amount, Boolean isDefault, OffsetDateTime createDate, Boolean overdraftEnable) {
        this.accountId = accountId;
        this.amount = amount;
        this.isDefault = isDefault;
        this.createDate = createDate;
        this.overdraftEnable = overdraftEnable;
    }

    public Bill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnable) {
        this.accountId = accountId;
        this.amount = amount;
        this.isDefault = isDefault;
        this.overdraftEnable = overdraftEnable;
    }
}
