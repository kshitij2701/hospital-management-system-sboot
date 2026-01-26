package com.learningSpringBoot.spring_boot_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SlotAlreadyBookedException extends RuntimeException {
    public SlotAlreadyBookedException(String message) {
        super(message);
    }
}

