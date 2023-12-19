package com.chat.with.ai.AIChat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class Chat {
    @Id
    private Long id;

    // 0: AI, 1: USER
    private int type;

    private String message;

    private Date date;
}
