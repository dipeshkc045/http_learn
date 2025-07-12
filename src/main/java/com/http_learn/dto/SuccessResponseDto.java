package com.http_learn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * DTO for successful status code responses
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response DTO for successful status codes")
public class SuccessResponseDto {
    
    @Schema(description = "The full status code and text (e.g., '200 OK')", example = "200 OK")
    private String status;
    
    @Schema(description = "Brief message describing the status code", example = "The request has succeeded")
    private String message;
    
    @Schema(description = "Detailed description of what the status code means")
    private String description;
    
    @Schema(description = "Common usage scenarios for this status code")
    private String usage;
    
    @Schema(description = "Map of status codes and their descriptions (used in overview endpoint)")
    private Map<String, String> codes;
    
    @Schema(description = "Additional notes or instructions")
    private String note;
    
    @Schema(description = "Example response data (for demonstration purposes)")
    private Object data;
    
    @Schema(description = "Timestamp of the response")
    private String timestamp;
    
    @Schema(description = "Request method that triggered this response")
    private String method;
} 