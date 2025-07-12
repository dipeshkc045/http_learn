package com.http_learn.service;

import com.http_learn.dto.InformationalResponseDto;
import com.http_learn.enums.InformationalStatusCode;
import com.http_learn.service.impl.InformationalStatusServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for InformationalStatusService
 * Demonstrates testing best practices and ensures code quality
 */
@ExtendWith(MockitoExtension.class)
class InformationalStatusServiceTest {

    @InjectMocks
    private InformationalStatusServiceImpl informationalStatusService;

    @Test
    @DisplayName("Should return correct response for 100 Continue")
    void shouldReturnCorrectResponseForContinue() {
        // When
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.CONTINUE);
        
        // Then
        assertNotNull(response);
        assertEquals("100 Continue", response.getStatus());
        assertEquals("The server has received the request headers and expects the client to send the request body", response.getMessage());
        assertNotNull(response.getDescription());
        assertNotNull(response.getUsage());
    }

    @Test
    @DisplayName("Should return correct response for 101 Switching Protocols")
    void shouldReturnCorrectResponseForSwitchingProtocols() {
        // When
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.SWITCHING_PROTOCOLS);
        
        // Then
        assertNotNull(response);
        assertEquals("101 Switching Protocols", response.getStatus());
        assertEquals("The server is switching protocols as requested by the client", response.getMessage());
        assertNotNull(response.getDescription());
        assertNotNull(response.getUsage());
    }

    @Test
    @DisplayName("Should return correct response for 102 Processing")
    void shouldReturnCorrectResponseForProcessing() {
        // When
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.PROCESSING);
        
        // Then
        assertNotNull(response);
        assertEquals("102 Processing", response.getStatus());
        assertEquals("The server has received and is processing the request, but no response is available yet", response.getMessage());
        assertNotNull(response.getDescription());
        assertNotNull(response.getUsage());
    }

    @Test
    @DisplayName("Should return correct response for 103 Early Hints")
    void shouldReturnCorrectResponseForEarlyHints() {
        // When
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.EARLY_HINTS);
        
        // Then
        assertNotNull(response);
        assertEquals("103 Early Hints", response.getStatus());
        assertEquals("Used to return some response headers before the final HTTP message", response.getMessage());
        assertNotNull(response.getDescription());
        assertNotNull(response.getUsage());
    }

    @Test
    @DisplayName("Should return correct response for 199 Unassigned")
    void shouldReturnCorrectResponseForUnassigned() {
        // When
        InformationalResponseDto response = informationalStatusService.getStatusResponse(InformationalStatusCode.UNASSIGNED);
        
        // Then
        assertNotNull(response);
        assertEquals("199 104-199 Unassigned", response.getStatus());
        assertEquals("These status codes are reserved for future use", response.getMessage());
        assertNotNull(response.getDescription());
        assertNotNull(response.getUsage());
    }

    @Test
    @DisplayName("Should return overview of all status codes")
    void shouldReturnOverviewOfAllStatusCodes() {
        // When
        InformationalResponseDto response = informationalStatusService.getAllStatusCodes();
        
        // Then
        assertNotNull(response);
        assertEquals("Informational Status Codes (1xx)", response.getStatus());
        assertEquals("These status codes indicate a provisional response", response.getMessage());
        assertNotNull(response.getCodes());
        assertEquals(5, response.getCodes().size());
        assertTrue(response.getCodes().containsKey("100"));
        assertTrue(response.getCodes().containsKey("101"));
        assertTrue(response.getCodes().containsKey("102"));
        assertTrue(response.getCodes().containsKey("103"));
        assertTrue(response.getCodes().containsKey("104-199"));
    }

    @Test
    @DisplayName("Should handle upload example with 100-continue header")
    void shouldHandleUploadExampleWithContinueHeader() {
        // When
        InformationalResponseDto response = informationalStatusService.handleUploadExample("100-continue");
        
        // Then
        assertNotNull(response);
        assertEquals("100 Continue", response.getStatus());
        assertEquals("Server is ready to receive the request body", response.getMessage());
        assertEquals("Client should now send the request body", response.getNextStep());
    }

    @Test
    @DisplayName("Should handle upload example without Expect header")
    void shouldHandleUploadExampleWithoutExpectHeader() {
        // When
        InformationalResponseDto response = informationalStatusService.handleUploadExample(null);
        
        // Then
        assertNotNull(response);
        assertEquals("200 OK", response.getStatus());
        assertEquals("Request processed successfully", response.getMessage());
        assertEquals("To see 100 Continue, send header: Expect: 100-continue", response.getNote());
    }

    @Test
    @DisplayName("Should return correct HTTP status codes")
    void shouldReturnCorrectHttpStatusCodes() {
        // When & Then
        assertEquals(100, informationalStatusService.getHttpStatusCode(InformationalStatusCode.CONTINUE));
        assertEquals(101, informationalStatusService.getHttpStatusCode(InformationalStatusCode.SWITCHING_PROTOCOLS));
        assertEquals(102, informationalStatusService.getHttpStatusCode(InformationalStatusCode.PROCESSING));
        assertEquals(103, informationalStatusService.getHttpStatusCode(InformationalStatusCode.EARLY_HINTS));
        assertEquals(199, informationalStatusService.getHttpStatusCode(InformationalStatusCode.UNASSIGNED));
    }
} 