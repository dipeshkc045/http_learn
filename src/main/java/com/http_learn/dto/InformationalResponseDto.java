package com.http_learn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * DTO for informational status code responses
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response DTO for informational status codes")
public class InformationalResponseDto {
    
    @Schema(description = "The full status code and text (e.g., '100 Continue')", example = "100 Continue")
    private String status;
    
    @Schema(description = "Brief message describing the status code", example = "The server has received the request headers and expects the client to send the request body")
    private String message;
    
    @Schema(description = "Detailed description of what the status code means")
    private String description;
    
    @Schema(description = "Common usage scenarios for this status code")
    private String usage;
    
    @Schema(description = "Map of status codes and their descriptions (used in overview endpoint)")
    private Map<String, String> codes;
    
    @Schema(description = "Additional notes or instructions")
    private String note;
    
    @Schema(description = "Next steps for the client (used in upload example)")
    private String nextStep;
} 