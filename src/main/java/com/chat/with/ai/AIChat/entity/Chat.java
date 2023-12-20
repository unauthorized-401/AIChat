package com.chat.with.ai.AIChat.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class Chat {
    @EmbeddedId
    private ChatPK chatPK;

    // 0: AI, 1: USER
    private int type;

    private String message;

    private Date date;
}
