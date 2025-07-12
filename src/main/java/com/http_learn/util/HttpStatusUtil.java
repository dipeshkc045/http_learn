package com.http_learn.util;

import com.http_learn.enums.InformationalStatusCode;
import org.springframework.http.HttpStatus;

/**
 * Utility class for HTTP status code operations
 * Provides helper methods for working with status codes
 */
public final class HttpStatusUtil {

    private HttpStatusUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Convert InformationalStatusCode enum to Spring HttpStatus
     * 
     * @param statusCode the informational status code enum
     * @return Spring HttpStatus
     */
    public static HttpStatus toHttpStatus(InformationalStatusCode statusCode) {
        return switch (statusCode) {
            case CONTINUE -> HttpStatus.CONTINUE;
            case SWITCHING_PROTOCOLS -> HttpStatus.SWITCHING_PROTOCOLS;
            case PROCESSING -> HttpStatus.PROCESSING;
            case EARLY_HINTS -> HttpStatus.EARLY_HINTS;
            case UNASSIGNED -> HttpStatus.valueOf(199);
        };
    }

    /**
     * Check if a status code is informational (1xx)
     * 
     * @param statusCode the status code to check
     * @return true if informational, false otherwise
     */
    public static boolean isInformational(int statusCode) {
        return statusCode >= 100 && statusCode < 200;
    }

    /**
     * Get the status text for a given status code
     * 
     * @param statusCode the status code
     * @return the status text
     */
    public static String getStatusText(int statusCode) {
        return HttpStatus.valueOf(statusCode).getReasonPhrase();
    }
} 