package com.chat.with.ai.AIChat.controller;

import com.chat.with.ai.AIChat.controller.parameter.RequestParam;
import com.chat.with.ai.AIChat.controller.parameter.ResponseParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController @Tag(name="Chat")
@RequestMapping(value={"/common/chat/"})
@Controller
public class ChatController {

    /*
        채팅 보내기
     */
    @Operation(tags={"Chat"}, summary="Send request")
    @PostMapping(value="request")
    public ResponseEntity sendRequest(@RequestBody(required = true) RequestParam requestParam) {
        try {
            return new ResponseEntity(HttpStatus.OK);

        } catch (Exception e) {
            log.error("Exception : {}", e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("X-Exception-Type", e.getClass().toString())
                    .header("X-Exception-Cause", e.getMessage())
                    .build();
        }
    }

    /*
        채팅 받기
     */
    @Operation(tags={"Chat"}, summary="Get response")
    @PostMapping(value="response")
    public ResponseEntity getResponse(@RequestBody(required = true) ResponseParam responseParam) {
        try {
            return new ResponseEntity(HttpStatus.OK);

        } catch (Exception e) {
            log.error("Exception : {}", e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("X-Exception-Type", e.getClass().toString())
                    .header("X-Exception-Cause", e.getMessage())
                    .build();
        }
    }
}
