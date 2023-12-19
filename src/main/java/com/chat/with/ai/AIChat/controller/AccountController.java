package com.chat.with.ai.AIChat.controller;

import com.chat.with.ai.AIChat.controller.parameter.LoginParam;
import com.chat.with.ai.AIChat.controller.parameter.MembershipParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController @Tag(name="Account")
@RequestMapping(value={"/common/account/"})
@Controller
public class AccountController {

    /*
        회원가입
     */
    @Operation(tags={"Account"}, summary="Join the membership")
    @PostMapping(value="join")
    public ResponseEntity joinMembership(@RequestBody(required = true) MembershipParam membershipParam) {
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
        로그인
     */
    @Operation(tags={"Account"}, summary="Login")
    @PostMapping(value="login")
    public ResponseEntity login(@RequestBody(required = true) LoginParam loginParam) {
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
        로그아웃
     */
    @Operation(tags={"Account"}, summary="Logout")
    @GetMapping(value="logout")
    public ResponseEntity logout(@RequestParam(required = true) String userId) {
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
