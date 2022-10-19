package com.nourish1709.rediscachinglargestmarspicture.handler;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException exception) {
        log.error("Exception occurred while using feign client. Response status: {}. Message: {}",
                exception.status(), exception.getMessage());
        return ResponseEntity.badRequest()
                .body("Invalid arguments. Try again later with other arguments");
    }
}
