package com.http_learn.service;

import com.http_learn.dto.SuccessResponseDto;
import com.http_learn.enums.SuccessStatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Service for handling successful status code responses
 */
@Slf4j
@Service
public class SuccessStatusService {

    /**
     * Get response for a specific successful status code
     * 
     * @param statusCode the status code enum
     * @return SuccessResponseDto with status information
     */
    public SuccessResponseDto getStatusResponse(SuccessStatusCode statusCode) {
        log.debug("Generating response for status code: {}", statusCode.getFullStatus());
        
        return SuccessResponseDto.builder()
                .status(statusCode.getFullStatus())
                .message(statusCode.getMessage())
                .description(statusCode.getDescription())
                .usage(statusCode.getUsage())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
    }

    /**
     * Get HTTP status code value
     * 
     * @param statusCode the status code enum
     * @return integer status code
     */
    public int getHttpStatusCode(SuccessStatusCode statusCode) {
        return statusCode.getCode();
    }

    /**
     * Get overview of all successful status codes
     * 
     * @return SuccessResponseDto with overview information
     */
    public SuccessResponseDto getAllStatusCodes() {
        log.debug("Generating overview of all successful status codes");
        
        Map<String, String> codes = new HashMap<>();
        for (SuccessStatusCode statusCode : SuccessStatusCode.values()) {
            codes.put(statusCode.getFullStatus(), statusCode.getMessage());
        }
        
        return SuccessResponseDto.builder()
                .status("200 OK")
                .message("Overview of all successful status codes (2xx)")
                .description("This endpoint provides information about all HTTP successful status codes")
                .usage("Useful for understanding when each status code should be used")
                .codes(codes)
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
    }

    /**
     * Get response with example data for demonstration
     * 
     * @param statusCode the status code enum
     * @param method the HTTP method
     * @return SuccessResponseDto with example data
     */
    public SuccessResponseDto getStatusResponseWithData(SuccessStatusCode statusCode, String method) {
        log.debug("Generating response with data for status code: {} and method: {}", statusCode.getFullStatus(), method);
        
        Object exampleData = getExampleDataForStatusCode(statusCode);
        
        return SuccessResponseDto.builder()
                .status(statusCode.getFullStatus())
                .message(statusCode.getMessage())
                .description(statusCode.getDescription())
                .usage(statusCode.getUsage())
                .data(exampleData)
                .method(method)
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
    }

    /**
     * Generate example data based on status code
     * 
     * @param statusCode the status code enum
     * @return example data object
     */
    private Object getExampleDataForStatusCode(SuccessStatusCode statusCode) {
        switch (statusCode) {
            case OK:
                return Map.of(
                    "id", 1,
                    "name", "Example Resource",
                    "description", "This is an example resource returned with 200 OK",
                    "createdAt", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                );
            case CREATED:
                return Map.of(
                    "id", 123,
                    "name", "New Resource",
                    "status", "created",
                    "location", "/api/resources/123",
                    "createdAt", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                );
            case ACCEPTED:
                return Map.of(
                    "taskId", "task-456",
                    "status", "accepted",
                    "estimatedCompletion", LocalDateTime.now().plusMinutes(5).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    "message", "Your request has been accepted for processing"
                );
            case NO_CONTENT:
                return null; // 204 should not return content
            case PARTIAL_CONTENT:
                return Map.of(
                    "range", "bytes 0-1023/2048",
                    "contentLength", 1024,
                    "totalSize", 2048,
                    "chunkNumber", 1
                );
            default:
                return Map.of(
                    "message", "Example response for " + statusCode.getFullStatus(),
                    "timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                );
        }
    }
} 