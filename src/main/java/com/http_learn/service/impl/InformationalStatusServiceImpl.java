package com.http_learn.service.impl;

import com.http_learn.dto.InformationalResponseDto;
import com.http_learn.enums.InformationalStatusCode;
import com.http_learn.service.InformationalStatusService;
import com.http_learn.util.HttpStatusUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Implementation of InformationalStatusService
 * Contains business logic for handling informational status codes
 */
@Slf4j
@Service
public class InformationalStatusServiceImpl implements InformationalStatusService {
    
    @Override
    public InformationalResponseDto getStatusResponse(InformationalStatusCode statusCode) {
        log.info("Generating response for status code: {}", statusCode.getFullStatus());
        
        return InformationalResponseDto.builder()
                .status(statusCode.getFullStatus())
                .message(statusCode.getMessage())
                .description(statusCode.getDescription())
                .usage(statusCode.getUsage())
                .build();
    }
    
    @Override
    public InformationalResponseDto getAllStatusCodes() {
        log.info("Generating overview of all informational status codes");
        
        Map<String, String> codesMap = Map.of(
            "100", "Continue - Client should proceed with request body",
            "101", "Switching Protocols - Server is switching protocols",
            "102", "Processing - Server is processing the request",
            "103", "Early Hints - Returning headers before final response",
            "104-199", "Unassigned - Reserved for future use"
        );
        
        return InformationalResponseDto.builder()
                .status("Informational Status Codes (1xx)")
                .message("These status codes indicate a provisional response")
                .description("Informational responses are provisional and indicate that the client should continue with the request")
                .codes(codesMap)
                .note("Informational responses are provisional and indicate that the client should continue with the request")
                .build();
    }
    
    @Override
    public InformationalResponseDto handleUploadExample(String expectHeader) {
        log.info("Handling upload example with Expect header: {}", expectHeader);
        
        if ("100-continue".equals(expectHeader)) {
            return InformationalResponseDto.builder()
                    .status(InformationalStatusCode.CONTINUE.getFullStatus())
                    .message("Server is ready to receive the request body")
                    .description("This indicates that the server has received the request headers and is ready for the body")
                    .nextStep("Client should now send the request body")
                    .build();
        } else {
            return InformationalResponseDto.builder()
                    .status("200 OK")
                    .message("Request processed successfully")
                    .description("Normal request processing without Expect header")
                    .note("To see 100 Continue, send header: Expect: 100-continue")
                    .build();
        }
    }
    
    @Override
    public int getHttpStatusCode(InformationalStatusCode statusCode) {
        return HttpStatusUtil.toHttpStatus(statusCode).value();
    }
} 