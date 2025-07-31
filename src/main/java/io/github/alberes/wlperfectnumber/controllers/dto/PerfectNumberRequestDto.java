package io.github.alberes.wlperfectnumber.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

@Schema(name = "PerfectNumberRequest")
public record PerfectNumberRequestDto(
        @NotNull(message = "Fill this field")
        @Range(min = 1, max = Integer.MAX_VALUE, message = "Fill in this field with a value between 1 and " + Integer.MAX_VALUE)
        Integer start,
        @NotNull(message = "Fill this field")
        @Range(min = 1, max = Integer.MAX_VALUE, message = "Fill in this field with a value between 1 and " + Integer.MAX_VALUE)
        Integer end) {
}
