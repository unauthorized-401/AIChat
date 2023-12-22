package com.chat.with.ai.AIChat.controller;

import com.chat.with.ai.AIChat.controller.parameter.MessageParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class WelcomeController {

    @GetMapping(value="/")
    public String welcome() {
        return "login";
    }
}
