package com.chat.with.ai.AIChat.service.impl;

import com.chat.with.ai.AIChat.controller.parameter.MessageParam;
import com.chat.with.ai.AIChat.controller.parameter.ResponseParam;
import com.chat.with.ai.AIChat.entity.Chat;
import com.chat.with.ai.AIChat.entity.ChatPK;
import com.chat.with.ai.AIChat.repository.ChatRepository;
import com.chat.with.ai.AIChat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service("ChatService")
public class ChatServiceImpl<T extends Chat> implements ChatService<T> {
    private final ChatRepository<T> chatRepository;

    @Autowired
    public ChatServiceImpl(ChatRepository<T> chatRepository) {
        this.chatRepository = chatRepository;
    }

    /*
        채팅 보내기
     */
    @Override
    public ResponseParam sendRequest(MessageParam messageParam) {
        ResponseParam responseParam = new ResponseParam();

        try {
            Chat chat = new Chat();
            chat.setChatPK(new ChatPK(messageParam.getUserId()));
            chat.setType(1);
            chat.setMessage(messageParam.getMessage());
            chat.setDate(new Date());

            chatRepository.save(chat);

            // TODO: Send message and get answer

            responseParam.setStatusCode(200);
            responseParam.setStatusMessage("Success to send request.");

        } catch (Exception e) {
            responseParam.setStatusCode(500);
            responseParam.setStatusMessage("Internal Server Error: " + e.getMessage());
        }

        return responseParam;
    }

    /*
        모든 채팅
     */
    @Override
    public List<T> getChatList() {
        return chatRepository.findAll();
    }
}
