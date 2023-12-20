package com.chat.with.ai.AIChat.repository;

import com.chat.with.ai.AIChat.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("AccountRepository")
public interface AccountRepository<T extends Account> extends JpaRepository<T, Long> {
    T findByUserId(String userId);
    T save(Account account);
    List<T> findAll();
}
