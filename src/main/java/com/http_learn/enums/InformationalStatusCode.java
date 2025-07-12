package com.http_learn.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing all informational status codes (1xx)
 */
@Getter
@RequiredArgsConstructor
public enum InformationalStatusCode {
    
    CONTINUE(100, "Continue", 
        "The server has received the request headers and expects the client to send the request body",
        "This status code indicates that the server has received the request and the client should proceed to send the request body",
        "Typically used in POST requests where the client needs to send a large amount of data"),
    
    SWITCHING_PROTOCOLS(101, "Switching Protocols",
        "The server is switching protocols as requested by the client",
        "This status code is sent in response to an Upgrade request header from the client",
        "Commonly used for WebSocket connections or HTTP/2 upgrades"),
    
    PROCESSING(102, "Processing",
        "The server has received and is processing the request, but no response is available yet",
        "This status code indicates that the server has received the request and is processing it",
        "Used for long-running operations where the server needs more time to process"),
    
    EARLY_HINTS(103, "Early Hints",
        "Used to return some response headers before the final HTTP message",
        "This status code is used to return some response headers before the final HTTP message",
        "Helps with performance by allowing the client to start processing resources early"),
    
    UNASSIGNED(199, "104-199 Unassigned",
        "These status codes are reserved for future use",
        "Status codes 104-199 are unassigned and reserved for future use",
        "These codes should not be used in current implementations");
    
    private final int code;
    private final String statusText;
    private final String message;
    private final String description;
    private final String usage;
    
    /**
     * Get the full status string (e.g., "100 Continue")
     */
    public String getFullStatus() {
        return code + " " + statusText;
    }
} 