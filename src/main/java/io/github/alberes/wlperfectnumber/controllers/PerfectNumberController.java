package io.github.alberes.wlperfectnumber.controllers;

import io.github.alberes.wlperfectnumber.controllers.dto.PerfectNumberRequestDto;
import io.github.alberes.wlperfectnumber.controllers.dto.PerfectNumberResponseDto;
import io.github.alberes.wlperfectnumber.controllers.exceptions.dto.StandardErrorDto;
import io.github.alberes.wlperfectnumber.services.PerfectNumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/perfect-numbers")
@Tag(name = "PerfectNumber")
public class PerfectNumberController {

    private final PerfectNumberService services;

    private final static UUID id = UUID.randomUUID();

    public PerfectNumberController(PerfectNumberService services) {
        this.services = services;
    }

    @PostMapping
    @Operation(summary = "Verify perfect number.", description = "Verify perfect number.",
            operationId = "perfectNumbers")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success."),
            @ApiResponse(responseCode = "400", description = "Validation error.",
                    content = @Content(schema = @Schema(implementation = StandardErrorDto.class)))
    })
    public ResponseEntity<PerfectNumberResponseDto> verifyPerfectNumbers(@RequestBody @Valid PerfectNumberRequestDto dto){
        String host = "";
        List<Integer> perfectNumbers = this.services.perfectNumber(dto.start(), dto.end());
        if(perfectNumbers.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity
                .ok(new PerfectNumberResponseDto(id.toString(), host, perfectNumbers));
    }
}
