package com.javastart.bill.controller;

import com.javastart.bill.controller.dto.BillRequestDto;
import com.javastart.bill.controller.dto.BillResponseDto;
import com.javastart.bill.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping("/{billId}")
    public BillResponseDto getBill(@PathVariable Long billId) {
        return new BillResponseDto(billService.getBillById(billId));
    }

    @PostMapping("/")
    public Long creatBill(@RequestBody BillRequestDto billRequestDto) {
        return billService.createBill(billRequestDto.getAccountId(), billRequestDto.getAmount(),
                billRequestDto.getIsDefault(), billRequestDto.getOverdraftEnable());
    }

    @PutMapping("/{billId}")
    public BillResponseDto updateBill(@PathVariable Long billId,
                                      @RequestBody BillRequestDto billRequestDto) {
        return new BillResponseDto(billService.updateBill(billId, billRequestDto.getAccountId(),
                billRequestDto.getAmount(), billRequestDto.getIsDefault(), billRequestDto.getOverdraftEnable()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDto deleteBill(@PathVariable Long billId) {
        return new BillResponseDto(billService.deleteBill(billId));
    }

}
