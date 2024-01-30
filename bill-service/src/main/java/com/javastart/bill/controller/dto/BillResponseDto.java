package com.javastart.bill.controller.dto;

import com.javastart.bill.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class BillResponseDto {

    private Long billId;

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime createDate;

    private Boolean overdraftEnable;

    public BillResponseDto(Bill bill) {
        billId = bill.getBillId();
        accountId = bill.getAccountId();
        amount = bill.getAmount();
        isDefault = bill.getIsDefault();
        createDate = bill.getCreateDate();
        overdraftEnable = bill.getOverdraftEnable();
    }

}
