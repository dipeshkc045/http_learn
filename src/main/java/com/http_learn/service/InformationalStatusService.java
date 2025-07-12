package com.http_learn.service;

import com.http_learn.dto.InformationalResponseDto;
import com.http_learn.enums.InformationalStatusCode;

/**
 * Service interface for handling informational status codes
 */
public interface InformationalStatusService {
    
    /**
     * Get response for a specific informational status code
     * 
     * @param statusCode the informational status code
     * @return response DTO with status information
     */
    InformationalResponseDto getStatusResponse(InformationalStatusCode statusCode);
    
    /**
     * Get overview of all informational status codes
     * 
     * @return response DTO with all codes overview
     */
    InformationalResponseDto getAllStatusCodes();
    
    /**
     * Handle upload example with Expect header
     * 
     * @param expectHeader the Expect header value
     * @return response DTO indicating next steps
     */
    InformationalResponseDto handleUploadExample(String expectHeader);
    
    /**
     * Get status code by enum
     * 
     * @param statusCode the status code enum
     * @return the HTTP status code value
     */
    int getHttpStatusCode(InformationalStatusCode statusCode);
} 