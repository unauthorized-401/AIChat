package com.chat.with.ai.AIChat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class WelcomeController {

    @GetMapping(value="/")
    public String login() {
        return "login";
    }

    @GetMapping(value="/sign_up")
    public String sign_up() {
        return "sign_up";
    }

    @GetMapping(value="/chat")
    public String chat() {
        return "chat";
    }
}
