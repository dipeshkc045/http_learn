package com.http_learn.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI configuration for Swagger documentation
 * Provides comprehensive API documentation with examples
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("HTTP Informational Status Codes API")
                        .description("""
                                This API demonstrates HTTP informational status codes (1xx) through REST endpoints.
                                
                                ## What are Informational Status Codes?
                                
                                Informational status codes (1xx) are provisional responses that indicate:
                                - The server has received the request and is continuing to process it
                                - The client should continue with the request
                                - The server is switching protocols
                                
                                ## Available Status Codes
                                
                                - **100 Continue**: The server has received the request headers and expects the client to send the request body
                                - **101 Switching Protocols**: The server is switching protocols as requested by the client
                                - **102 Processing**: The server has received and is processing the request, but no response is available yet
                                - **103 Early Hints**: Used to return some response headers before the final HTTP message
                                - **104-199 Unassigned**: These status codes are reserved for future use
                                
                                ## Real-World Usage Examples
                                
                                - **100 Continue**: Large file uploads, POST requests with large payloads
                                - **101 Switching Protocols**: WebSocket connections, HTTP/2 upgrades
                                - **102 Processing**: Long-running operations like image processing
                                - **103 Early Hints**: Performance optimization, early resource loading
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("HTTP Learning Project")
                                .email("example@http-learn.com")
                                .url("https://github.com/http-learn"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Local Development Server"),
                        new Server()
                                .url("https://api.http-learn.com")
                                .description("Production Server")
                ));
    }
} 