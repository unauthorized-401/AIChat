package com.chat.with.ai.AIChat.controller.parameter;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseParam {
    private String response;
    private int statusCode;
    private String statusMessage;
}
