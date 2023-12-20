package com.chat.with.ai.AIChat.repository;

import com.chat.with.ai.AIChat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("ChatRepository")
public interface ChatRepository<T extends Chat> extends JpaRepository<T, Long> {
    T save(Chat chat);
    List<T> findAll();
}
