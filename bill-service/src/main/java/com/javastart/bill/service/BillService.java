package com.javastart.bill.service;

import com.javastart.bill.entity.Bill;
import com.javastart.bill.exception.BillNotFountException;
import com.javastart.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public Bill getBillById(Long billId) {
        return billRepository.findById(billId).orElseThrow(
                () -> new BillNotFountException("Unable to find bill with id: " + billId)
        );
    }

    public Long createBill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnable) {
        Bill bill = new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overdraftEnable);
        return billRepository.save(bill).getBillId();
    }

    public Bill updateBill(Long billId, Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnable) {
        Bill bill = new Bill(accountId, amount, isDefault, overdraftEnable);
        bill.setBillId(billId);
        return billRepository.save(bill);
    }

    public Bill deleteBill(Long billId) {
        Bill deletedBill = getBillById(billId);
        billRepository.delete(deletedBill);
        return deletedBill;
    }

}
