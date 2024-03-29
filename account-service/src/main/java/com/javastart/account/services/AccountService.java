package com.javastart.account.services;

import com.javastart.account.entity.Account;
import com.javastart.account.exception.AccountNotFoundException;
import com.javastart.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(
                () -> new AccountNotFoundException("Unable to find account with id: " + accountId)
        );
    }

    public Long createAccount(String name, String email, String phone, List<Long> bills) {
        Account account = new Account(name, email, phone, OffsetDateTime.now(), bills);
        return accountRepository.save(account).getAccountId();
    }

    public Account updateAccount(Long accountId, String name, String email, String phone, List<Long> bills) {
        Account account = new Account();
        account.setAccountId(accountId);
        account.setEmail(email);
        account.setPhone(phone);
        account.setName(name);
        return accountRepository.save(account);
    }

    public Account deleteAccount(Long accountId) {
        Account deleteAccount = getAccountById(accountId);
        accountRepository.deleteById(accountId);

        return deleteAccount;
    }
}