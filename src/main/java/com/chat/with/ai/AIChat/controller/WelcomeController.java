package com.chat.with.ai.AIChat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class WelcomeController {

    // Login Page
    @GetMapping(value="/")
    public String login() {
        return "login";
    }

    // Sign Up Page
    @GetMapping(value="/sign_up")
    public String sign_up() {
        return "sign_up";
    }

    // AI Chat Page
    @GetMapping(value="/chat")
    public String chat() {
        return "chat";
    }
}
