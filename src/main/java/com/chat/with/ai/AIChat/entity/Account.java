package com.chat.with.ai.AIChat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Account {
    // 유저 이름
    private String userName;

    // 유저 아이디
    @Id
    private String userId;

    // 유저 패스워드
    private String password;
}
