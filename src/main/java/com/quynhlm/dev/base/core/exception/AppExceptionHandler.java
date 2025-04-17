package com.quynhlm.dev.base.core.exception;

import com.octl2.api.core.AppError;
import com.octl2.api.core.ResponseObject;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> invalid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<AppError> errors = new ArrayList<>();
        ex.getAllErrors().forEach(err -> {
            AppError error = new AppError(AppError.ErrorCode.DATA_INVALID,
                    err.getDefaultMessage());
            errors.add(error);
        });
        ResponseObject response = new ResponseObject();
        response.setMessage("Data is invalid.");
        response.setStatus(false);
        response.setErrors(errors);
        return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> notFound(Exception ex, HttpServletRequest request) {
        ResponseObject response = new ResponseObject();
        response.setStatus(false);
        response.setMessage("Not found exception.");
        response.setError(new AppError(AppError.ErrorCode.NOT_FOUND, ex.getMessage()));
        return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UnknownException.class})
    public ResponseEntity<?> unknown(Exception ex, HttpServletRequest request) {
        ResponseObject response = new ResponseObject();
        response.setStatus(false);
        response.setMessage("Something went wrong!.");
        response.setError(new AppError(AppError.ErrorCode.UNKNOWN, ex.getMessage()));
        return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<?> badRequest(Exception ex, HttpServletRequest request) {
        ResponseObject response = new ResponseObject();
        response.setStatus(false);
        response.setMessage("Bad request exception!.");
        response.setError(new AppError(AppError.ErrorCode.BAD_REQUEST, ex.getMessage()));
        return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
    }

}
