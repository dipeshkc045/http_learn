package com.http_learn.controller;

import com.http_learn.dto.InformationalResponseDto;
import com.http_learn.enums.InformationalStatusCode;
import com.http_learn.service.InformationalStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for informational status codes demonstration
 * Follows REST principles and proper separation of concerns
 */
@Slf4j
@RestController
@RequestMapping("/api/informational")
@RequiredArgsConstructor
@Tag(name = "Informational Status Codes", description = "APIs for demonstrating HTTP informational status codes (1xx)")
@CrossOrigin(origins = "*")
public class InformationalStatusController {

    private final InformationalStatusService informationalStatusService;

    /**
     * Get 100 Continue status response
     * 
     * @return ResponseEntity with 100 Continue status
     */
    @Operation(
        summary = "Get 100 Continue Status",
        description = "Returns a 100 Continue status response. This status code indicates that the server has received the request headers and expects the client to send the request body."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "100",
            description = "Continue - Server ready to receive request body",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = InformationalResponseDto.class),
                examples = @ExampleObject(
                    name = "Continue Response",
                    value = """
                        {
                          "status": "100 Continue",
                          "message": "The server has received the request headers and expects the client to send the request body",
                          "description": "This status code indicates that the server has received the request headers and the client should proceed to send the request body",
                          "usage": "Typically used in POST requests where the client needs to send a large amount of data"
                        }
                        """
                )
            )
        )
    })
    @GetMapping("/continue")
    public ResponseEntity<InformationalResponseDto> getContinue() {
        log.info("Handling request for 100 Continue status");
        
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.CONTINUE);
        int statusCode = informationalStatusService.getHttpStatusCode(InformationalStatusCode.CONTINUE);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 101 Switching Protocols status response
     * 
     * @return ResponseEntity with 101 Switching Protocols status
     */
    @GetMapping("/switching-protocols")
    public ResponseEntity<InformationalResponseDto> getSwitchingProtocols() {
        log.info("Handling request for 101 Switching Protocols status");
        
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.SWITCHING_PROTOCOLS);
        int statusCode = informationalStatusService.getHttpStatusCode(InformationalStatusCode.SWITCHING_PROTOCOLS);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 102 Processing status response
     * 
     * @return ResponseEntity with 102 Processing status
     */
    @GetMapping("/processing")
    public ResponseEntity<InformationalResponseDto> getProcessing() {
        log.info("Handling request for 102 Processing status");
        
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.PROCESSING);
        int statusCode = informationalStatusService.getHttpStatusCode(InformationalStatusCode.PROCESSING);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 103 Early Hints status response
     * 
     * @return ResponseEntity with 103 Early Hints status
     */
    @GetMapping("/early-hints")
    public ResponseEntity<InformationalResponseDto> getEarlyHints() {
        log.info("Handling request for 103 Early Hints status");
        
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.EARLY_HINTS);
        int statusCode = informationalStatusService.getHttpStatusCode(InformationalStatusCode.EARLY_HINTS);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 199 Unassigned status response
     * 
     * @return ResponseEntity with 199 Unassigned status
     */
    @GetMapping("/unassigned")
    public ResponseEntity<InformationalResponseDto> getUnassigned() {
        log.info("Handling request for 199 Unassigned status");
        
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.UNASSIGNED);
        int statusCode = informationalStatusService.getHttpStatusCode(InformationalStatusCode.UNASSIGNED);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get overview of all informational status codes
     * 
     * @return ResponseEntity with overview of all codes
     */
    @Operation(
        summary = "Get All Informational Status Codes",
        description = "Returns an overview of all informational status codes (1xx) with their descriptions and usage examples."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved all informational status codes",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = InformationalResponseDto.class)
            )
        )
    })
    @GetMapping("/all")
    public ResponseEntity<InformationalResponseDto> getAllInformationalCodes() {
        log.info("Handling request for all informational status codes overview");
        
        InformationalResponseDto response = informationalStatusService.getAllStatusCodes();
        
        return ResponseEntity.ok(response);
    }

    /**
     * Handle upload example demonstrating 100 Continue usage
     * 
     * @param expectHeader the Expect header value
     * @return ResponseEntity with appropriate status and response
     */
    @Operation(
        summary = "Upload Example with 100 Continue",
        description = "Demonstrates how 100 Continue works in a real scenario. Send 'Expect: 100-continue' header to see 100 Continue response."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "100",
            description = "Continue - Server ready to receive request body",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = InformationalResponseDto.class)
            )
        ),
        @ApiResponse(
            responseCode = "200",
            description = "OK - Request processed successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = InformationalResponseDto.class)
            )
        )
    })
    @PostMapping("/upload-example")
    public ResponseEntity<InformationalResponseDto> uploadExample(
            @RequestHeader(value = "Expect", required = false) String expectHeader,
            @RequestBody(required = false) String requestBody) {

        log.info("Received Expect header: {}", expectHeader);
        log.info("Received request body: {}", requestBody);

        // Handle 100-continue info for documentation only (Tomcat already handles the actual 100)
        InformationalResponseDto response;

        if ("100-continue".equalsIgnoreCase(expectHeader)) {
            log.info("Handling 100 Continue for upload example");
            log.info("requestBody: {}", requestBody);
            response = InformationalResponseDto.builder()
                    .status("100 Continue (Handled by server)")
                    .message("Server acknowledged Expect: 100-continue header. The actual 100 Continue was sent by Tomcat before this controller was called.")
                    .description("Request body has now been received: {}Proceeding with final processing.")
                    .nextStep("Response returned successfully.")
                    .build();
        } else {
            response = InformationalResponseDto.builder()
                    .status("200 OK")
                    .message("Request processed successfully")
                    .description("No Expect header detected. Normal request processed.")
                    .build();
        }

        return ResponseEntity.ok(response);
    }

} 