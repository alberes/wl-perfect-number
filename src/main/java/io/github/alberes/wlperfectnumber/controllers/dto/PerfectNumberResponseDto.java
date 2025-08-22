package io.github.alberes.wlperfectnumber.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "PerfectNumberResponse")
public record PerfectNumberResponseDto(String id, String host, List<Integer> perfectNumbers) {
}
