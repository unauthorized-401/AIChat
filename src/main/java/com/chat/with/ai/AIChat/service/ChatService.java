package com.chat.with.ai.AIChat.service;

import com.chat.with.ai.AIChat.controller.parameter.MessageParam;
import com.chat.with.ai.AIChat.controller.parameter.ResponseParam;
import com.chat.with.ai.AIChat.entity.Chat;

import java.util.List;

public interface ChatService<T extends Chat> {
    ResponseParam sendRequest(MessageParam messageParam);
    List<T> getChatList();
}
