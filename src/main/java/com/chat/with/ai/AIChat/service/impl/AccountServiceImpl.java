package com.chat.with.ai.AIChat.service.impl;

import com.chat.with.ai.AIChat.controller.parameter.LoginParam;
import com.chat.with.ai.AIChat.controller.parameter.MembershipParam;
import com.chat.with.ai.AIChat.controller.parameter.ReturnParam;
import com.chat.with.ai.AIChat.entity.Account;
import com.chat.with.ai.AIChat.repository.AccountRepository;
import com.chat.with.ai.AIChat.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service("AccountService")
public class AccountServiceImpl<T extends Account> implements AccountService<T> {
    private final AccountRepository<T> accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository<T> accountRepository) {
        this.accountRepository = accountRepository;
    }

    /*
        회원가입
     */
    @Override
    public ReturnParam createAccount(MembershipParam membershipParam) {
        ReturnParam returnParam = new ReturnParam();

        try {
            // Check user id is unique
            Optional<Account> accountOptional = Optional.ofNullable(accountRepository.findByUserId(membershipParam.getUserId()));

            if (accountOptional.isPresent()) {
                returnParam.setStatusCode(226);
                returnParam.setStatusMessage("This user ID already exists. Please use another one.");

            } else {
                Account account = new Account();
                account.setUserName(membershipParam.getUserName());
                account.setUserId(membershipParam.getUserId());
                account.setPassword(membershipParam.getPassword());

                accountRepository.save(account);

                returnParam.setStatusCode(200);
                returnParam.setStatusMessage("Success to create a new account.");
            }

        } catch (Exception e) {
            returnParam.setStatusCode(500);
            returnParam.setStatusMessage("Internal Server Error: " + e.getMessage());
        }

        return returnParam;
    }

    /*
        로그인
     */
    @Override
    public ReturnParam login(LoginParam loginParam) {
        ReturnParam returnParam = new ReturnParam();

        try {
            // Check user id
            Optional<Account> accountOptional = Optional.ofNullable(accountRepository.findByUserId(loginParam.getUserId()));

            if (accountOptional.isPresent()) {
                // Check password
                if (accountOptional.get().getPassword().equals(loginParam.getPassword())) {
                    returnParam.setStatusCode(200);
                    returnParam.setStatusMessage("Success to login.");
                } else {
                    returnParam.setStatusCode(405);
                    returnParam.setStatusMessage("This password is not correct. Please check your Password.");
                }
            } else {
                returnParam.setStatusCode(404);
                returnParam.setStatusMessage("This user ID is not exists. Please check your ID.");
            }

        } catch (Exception e) {
            returnParam.setStatusCode(500);
            returnParam.setStatusMessage("Internal Server Error: " + e.getMessage());
        }

        return returnParam;
    }

    /*
        회원 조회
     */
    @Override
    public List<T> getAccountList() {
        return accountRepository.findAll();
    }
}
