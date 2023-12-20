package com.chat.with.ai.AIChat.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class ChatPK {
    private Long id;

    private String userId;
}
