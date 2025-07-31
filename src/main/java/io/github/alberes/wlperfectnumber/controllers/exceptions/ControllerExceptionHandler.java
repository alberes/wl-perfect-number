package io.github.alberes.wlperfectnumber.controllers.exceptions;

import io.github.alberes.wlperfectnumber.controllers.exceptions.dto.FieldErrorDto;
import io.github.alberes.wlperfectnumber.controllers.exceptions.dto.StandardErrorDto;
import io.github.alberes.wlperfectnumber.services.exceptions.PerfectNumberException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorDto> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException,
                                                                            HttpServletRequest httpServletRequest){

        List<FieldError> fieldErrors = methodArgumentNotValidException.getFieldErrors();
        List<FieldErrorDto> fields = fieldErrors.stream().map(
                        fe -> new FieldErrorDto(fe.getField(), fe.getDefaultMessage()))
                .toList();

        StandardErrorDto standardErrorDto = new StandardErrorDto(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                methodArgumentNotValidException.getMessage(),
                httpServletRequest.getRequestURI(),
                fields);

        return ResponseEntity
                .status(standardErrorDto.getStatus()).body(standardErrorDto);

    }

    @ExceptionHandler(PerfectNumberException.class)
    public ResponseEntity<StandardErrorDto> perfectNumberException(PerfectNumberException perfectNumberException,
                                                                   HttpServletRequest httpServletRequest){

        StandardErrorDto standardErrorDto = new StandardErrorDto(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                perfectNumberException.getMessage(),
                httpServletRequest.getRequestURI(),
                perfectNumberException.getFields());

        return ResponseEntity
                .status(standardErrorDto.getStatus()).body(standardErrorDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardErrorDto> httpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException,
                                                                            HttpServletRequest httpServletRequest){
        StandardErrorDto standardErrorDto = new StandardErrorDto(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                httpMessageNotReadableException.getMessage(),
                httpServletRequest.getRequestURI(),
                List.of());

        return ResponseEntity
                .status(standardErrorDto.getStatus()).body(standardErrorDto);
    }

}