package com.chat.with.ai.AIChat.controller;

import com.chat.with.ai.AIChat.controller.parameter.MessageParam;
import com.chat.with.ai.AIChat.controller.parameter.ResponseParam;
import com.chat.with.ai.AIChat.entity.Chat;
import com.chat.with.ai.AIChat.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController @Tag(name="Chat")
@RequestMapping(value={"/common/chat/"})
@Controller
public class ChatController {
    private final ChatService<Chat> chatService;

    @Autowired
    public ChatController(ChatService<Chat> chatService) {
        this.chatService = chatService;
    }

    /*
        채팅 보내기
     */
    @Operation(tags={"Chat"}, summary="Send request")
    @PostMapping(value="request")
    public ResponseEntity sendRequest(@RequestBody(required = true) MessageParam messageParam) {
        try {
            ResponseParam responseParam = chatService.sendRequest(messageParam);

            return ResponseEntity.status(responseParam.getStatusCode())
                    .body(responseParam);

        } catch (Exception e) {
            log.error("Exception : {}", e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("X-Exception-Type", e.getClass().toString())
                    .header("X-Exception-Cause", e.getMessage())
                    .build();
        }
    }

    /*
        모든 채팅
     */
    @Operation(tags={"Chat"}, summary="Select the chat list")
    @GetMapping(value="list")
    public ResponseEntity<List<Chat>> chatList() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(chatService.getChatList());

        } catch (Exception e) {
            log.error("Exception : {}", e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("X-Exception-Type", e.getClass().toString())
                    .header("X-Exception-Cause", e.getMessage())
                    .build();
        }
    }
}
