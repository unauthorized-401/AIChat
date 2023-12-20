package com.chat.with.ai.AIChat.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ChatPK {
    private String userId;
    private Date date;

    public ChatPK () {}

    public ChatPK (String userId, Date date) {
        this.userId = userId;
        this.date = date;
    }
}
