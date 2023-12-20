package com.chat.with.ai.AIChat.service;

import com.chat.with.ai.AIChat.controller.parameter.LoginParam;
import com.chat.with.ai.AIChat.controller.parameter.MembershipParam;
import com.chat.with.ai.AIChat.controller.parameter.ReturnParam;
import com.chat.with.ai.AIChat.entity.Account;

import java.util.List;

public interface AccountService<T extends Account> {
    ReturnParam createAccount(MembershipParam membershipParam);
    ReturnParam login(LoginParam loginParam);
    List<T> getAccountList();
}
