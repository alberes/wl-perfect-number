package io.github.alberes.wlperfectnumber.controllers.exceptions.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "FieldError")
public record FieldErrorDto(String field, String message){
}