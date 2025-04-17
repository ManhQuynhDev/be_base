package com.quynhlm.dev.be.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ResponseObject <T> {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private boolean status;
    private String message;
    private T data;
    private List<AppError> errors;
    private AppError error;
}
