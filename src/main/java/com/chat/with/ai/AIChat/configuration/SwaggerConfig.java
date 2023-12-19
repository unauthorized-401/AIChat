package com.chat.with.ai.AIChat.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "AI 채팅 API 명세서",
                description = "AI 메신저를 위한 인터페이스 제공",
                version = "v1"))
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {
                "/common/account/join",             // 회원가입
                "/common/account/login",            // 로그인
                "/common/account/logout",           // 로그아웃
                "/common/chat/request",             // 채팅 보내기
                "/common/chat/response",            // 답변 받기
        };

        return GroupedOpenApi.builder()
                .group("AIChat API v1")
                .pathsToMatch(paths)
                .build();
    }
}