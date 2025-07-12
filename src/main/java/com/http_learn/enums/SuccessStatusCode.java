package com.http_learn.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing all successful status codes (2xx)
 */
@Getter
@RequiredArgsConstructor
public enum SuccessStatusCode {
    
    OK(200, "OK", 
        "The request has succeeded",
        "This is the standard response for successful HTTP requests. The actual response will depend on the request method used.",
        "Most common response for successful GET requests, also used for successful POST, PUT, PATCH requests"),
    
    CREATED(201, "Created",
        "The request has succeeded and a new resource has been created as a result",
        "This status code is typically sent after a POST request that creates a new resource",
        "Used when creating new resources like users, posts, orders, etc."),
    
    ACCEPTED(202, "Accepted",
        "The request has been received but not yet acted upon",
        "The request has been accepted for processing, but the processing has not been completed",
        "Commonly used for asynchronous operations, batch processing, or when the result is not immediately available"),
    
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information",
        "The returned metadata is different from what the origin server sent",
        "This status code is used when the response has been modified by a proxy or cache",
        "Rarely used in modern applications, mostly for proxy responses"),
    
    NO_CONTENT(204, "No Content",
        "The server successfully processed the request and is not returning any content",
        "The server has fulfilled the request but there is no additional content to send in the response body",
        "Commonly used for DELETE operations, or when updating a resource without needing to return the updated data"),
    
    RESET_CONTENT(205, "Reset Content",
        "The server has fulfilled the request and desires that the client reset the document view",
        "The server has processed the request and the client should reset the view that sent the request",
        "Used when the client should clear the form or reset the UI state"),
    
    PARTIAL_CONTENT(206, "Partial Content",
        "The server is delivering only part of the resource due to a range header sent by the client",
        "The server has fulfilled the partial GET request for the resource",
        "Commonly used for file downloads, video streaming, or large file transfers"),
    
    MULTI_STATUS(207, "Multi-Status",
        "The response body contains XML describing the status of multiple independent operations",
        "The response contains information about multiple resources in a single response",
        "Used in WebDAV and other protocols that need to report on multiple operations"),
    
    ALREADY_REPORTED(208, "Already Reported",
        "The members of a DAV binding have already been enumerated in a preceding part of the response",
        "Used in WebDAV to avoid enumerating the internal members of a binding multiple times",
        "Primarily used in WebDAV protocol implementations"),
    
    IM_USED(226, "IM Used",
        "The server has fulfilled a GET request for the resource, and the response is a representation of the result of one or more instance-manipulations",
        "The response is the result of applying one or more instance manipulations to the current instance",
        "Used in HTTP Delta Encoding and rarely in modern applications");
    
    private final int code;
    private final String statusText;
    private final String message;
    private final String description;
    private final String usage;
    
    /**
     * Get the full status string (e.g., "200 OK")
     */
    public String getFullStatus() {
        return code + " " + statusText;
    }
} 