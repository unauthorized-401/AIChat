package com.chat.with.ai.AIChat.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ChatPK {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    public ChatPK (String userId) {
        this.userId = userId;
    }
}
