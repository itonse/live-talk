package com.itonse.livetalk.domain.auth.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "User를 생성합니다.")
public record CreateUserRequest (

    @Schema(description = "유저 이름")
    @NotBlank
    String name,

    @Schema(description = "유저 비밀번호")
    @NotBlank
    String password
) {}
