package com.http_learn.controller;

import com.http_learn.dto.SuccessResponseDto;
import com.http_learn.enums.SuccessStatusCode;
import com.http_learn.service.SuccessStatusService;
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
 * REST Controller for successful status codes demonstration
 * Covers all 2xx status codes with practical examples
 */
@Slf4j
@RestController
@RequestMapping("/api/success")
@RequiredArgsConstructor
@Tag(name = "Successful Status Codes", description = "APIs for demonstrating HTTP successful status codes (2xx)")
@CrossOrigin(origins = "*")
public class SuccessStatusController {

    private final SuccessStatusService successStatusService;

    /**
     * Get 200 OK status response
     */
    @Operation(
        summary = "Get 200 OK Status",
        description = "Returns a 200 OK status response. This is the standard response for successful HTTP requests."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "OK - The request has succeeded",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class),
                examples = @ExampleObject(
                    name = "OK Response",
                    value = """
                        {
                          "status": "200 OK",
                          "message": "The request has succeeded",
                          "description": "This is the standard response for successful HTTP requests",
                          "usage": "Most common response for successful GET requests",
                          "timestamp": "2024-01-15T10:30:00"
                        }
                        """
                )
            )
        )
    })
    @GetMapping("/ok")
    public ResponseEntity<SuccessResponseDto> getOk() {
        log.info("Handling request for 200 OK status");
        
        SuccessResponseDto response = successStatusService.getStatusResponseWithData(SuccessStatusCode.OK, "GET");
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.OK);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 201 Created status response
     */
    @Operation(
        summary = "Get 201 Created Status",
        description = "Returns a 201 Created status response. Used when a new resource has been created."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Created - The request has succeeded and a new resource has been created",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @PostMapping("/created")
    public ResponseEntity<SuccessResponseDto> getCreated() {
        log.info("Handling request for 201 Created status");
        
        SuccessResponseDto response = successStatusService.getStatusResponseWithData(SuccessStatusCode.CREATED, "POST");
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.CREATED);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 202 Accepted status response
     */
    @Operation(
        summary = "Get 202 Accepted Status",
        description = "Returns a 202 Accepted status response. Used for asynchronous operations."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "202",
            description = "Accepted - The request has been received but not yet acted upon",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @PostMapping("/accepted")
    public ResponseEntity<SuccessResponseDto> getAccepted() {
        log.info("Handling request for 202 Accepted status");
        
        SuccessResponseDto response = successStatusService.getStatusResponseWithData(SuccessStatusCode.ACCEPTED, "POST");
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.ACCEPTED);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 204 No Content status response
     */
    @Operation(
        summary = "Get 204 No Content Status",
        description = "Returns a 204 No Content status response. Used when no content should be returned."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "204",
            description = "No Content - The server successfully processed the request and is not returning any content",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @DeleteMapping("/no-content")
    public ResponseEntity<SuccessResponseDto> getNoContent() {
        log.info("Handling request for 204 No Content status");
        
        SuccessResponseDto response = successStatusService.getStatusResponse(SuccessStatusCode.NO_CONTENT);
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.NO_CONTENT);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 206 Partial Content status response
     */
    @Operation(
        summary = "Get 206 Partial Content Status",
        description = "Returns a 206 Partial Content status response. Used for range requests."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "206",
            description = "Partial Content - The server is delivering only part of the resource",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @GetMapping("/partial-content")
    public ResponseEntity<SuccessResponseDto> getPartialContent(
            @RequestHeader(value = "Range", required = false) String rangeHeader) {
        log.info("Handling request for 206 Partial Content status with range: {}", rangeHeader);
        
        SuccessResponseDto response = successStatusService.getStatusResponseWithData(SuccessStatusCode.PARTIAL_CONTENT, "GET");
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.PARTIAL_CONTENT);
        
        return ResponseEntity.status(statusCode)
                .header("Content-Range", "bytes 0-1023/2048")
                .body(response);
    }

    /**
     * Get 205 Reset Content status response
     */
    @Operation(
        summary = "Get 205 Reset Content Status",
        description = "Returns a 205 Reset Content status response. Used when the client should reset the view."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "205",
            description = "Reset Content - The server has fulfilled the request and desires that the client reset the document view",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @PostMapping("/reset-content")
    public ResponseEntity<SuccessResponseDto> getResetContent() {
        log.info("Handling request for 205 Reset Content status");
        
        SuccessResponseDto response = successStatusService.getStatusResponse(SuccessStatusCode.RESET_CONTENT);
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.RESET_CONTENT);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 203 Non-Authoritative Information status response
     */
    @Operation(
        summary = "Get 203 Non-Authoritative Information Status",
        description = "Returns a 203 Non-Authoritative Information status response. Used when response is modified by proxy."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "203",
            description = "Non-Authoritative Information - The returned metadata is different from what the origin server sent",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @GetMapping("/non-authoritative")
    public ResponseEntity<SuccessResponseDto> getNonAuthoritativeInformation() {
        log.info("Handling request for 203 Non-Authoritative Information status");
        
        SuccessResponseDto response = successStatusService.getStatusResponse(SuccessStatusCode.NON_AUTHORITATIVE_INFORMATION);
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.NON_AUTHORITATIVE_INFORMATION);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 207 Multi-Status status response
     */
    @Operation(
        summary = "Get 207 Multi-Status Status",
        description = "Returns a 207 Multi-Status status response. Used in WebDAV for multiple operations."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "207",
            description = "Multi-Status - The response body contains XML describing the status of multiple independent operations",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @PostMapping("/multi-status")
    public ResponseEntity<SuccessResponseDto> getMultiStatus() {
        log.info("Handling request for 207 Multi-Status status");
        
        SuccessResponseDto response = successStatusService.getStatusResponse(SuccessStatusCode.MULTI_STATUS);
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.MULTI_STATUS);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 208 Already Reported status response
     */
    @Operation(
        summary = "Get 208 Already Reported Status",
        description = "Returns a 208 Already Reported status response. Used in WebDAV to avoid duplicate enumeration."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "208",
            description = "Already Reported - The members of a DAV binding have already been enumerated",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @GetMapping("/already-reported")
    public ResponseEntity<SuccessResponseDto> getAlreadyReported() {
        log.info("Handling request for 208 Already Reported status");
        
        SuccessResponseDto response = successStatusService.getStatusResponse(SuccessStatusCode.ALREADY_REPORTED);
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.ALREADY_REPORTED);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get 226 IM Used status response
     */
    @Operation(
        summary = "Get 226 IM Used Status",
        description = "Returns a 226 IM Used status response. Used in HTTP Delta Encoding."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "226",
            description = "IM Used - The server has fulfilled a GET request for the resource with instance manipulations",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @GetMapping("/im-used")
    public ResponseEntity<SuccessResponseDto> getImUsed() {
        log.info("Handling request for 226 IM Used status");
        
        SuccessResponseDto response = successStatusService.getStatusResponse(SuccessStatusCode.IM_USED);
        int statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.IM_USED);
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get overview of all successful status codes
     */
    @Operation(
        summary = "Get All Successful Status Codes",
        description = "Returns an overview of all successful status codes (2xx) with their descriptions and usage examples."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved all successful status codes",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SuccessResponseDto.class)
            )
        )
    })
    @GetMapping("/all")
    public ResponseEntity<SuccessResponseDto> getAllSuccessCodes() {
        log.info("Handling request for all successful status codes overview");
        
        SuccessResponseDto response = successStatusService.getAllStatusCodes();
        
        return ResponseEntity.ok(response);
    }

    /**
     * Demonstrate different status codes based on HTTP method
     */
    @Operation(
        summary = "Demonstrate Status Codes by Method",
        description = "Demonstrates how different HTTP methods can return different successful status codes."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK - For GET requests"),
        @ApiResponse(responseCode = "201", description = "Created - For POST requests"),
        @ApiResponse(responseCode = "204", description = "No Content - For DELETE requests")
    })
    @RequestMapping(value = "/method-demo", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
    public ResponseEntity<SuccessResponseDto> methodDemo() {
        String method = getCurrentMethod();
        log.info("Handling {} request for method demonstration", method);
        
        SuccessResponseDto response;
        int statusCode;
        
        switch (method) {
            case "GET":
                response = successStatusService.getStatusResponseWithData(SuccessStatusCode.OK, method);
                statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.OK);
                break;
            case "POST":
                response = successStatusService.getStatusResponseWithData(SuccessStatusCode.CREATED, method);
                statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.CREATED);
                break;
            case "DELETE":
                response = successStatusService.getStatusResponse(SuccessStatusCode.NO_CONTENT);
                response.setMethod(method);
                statusCode = successStatusService.getHttpStatusCode(SuccessStatusCode.NO_CONTENT);
                break;
            default:
                response = successStatusService.getStatusResponse(SuccessStatusCode.OK);
                statusCode = 200;
        }
        
        return ResponseEntity.status(statusCode).body(response);
    }

    /**
     * Get the current HTTP method
     */
    private String getCurrentMethod() {
        // This is a simplified approach - in a real application, you might use HttpServletRequest
        return "GET"; // Default for demonstration
    }
} 