# HTTP Informational Status Codes API

This Spring Boot application demonstrates HTTP informational status codes (1xx) through a REST API. Informational status codes indicate provisional responses that tell the client to continue with the request or that the server is switching protocols.

## What are Informational Status Codes?

Informational status codes (1xx) are provisional responses that indicate:
- The server has received the request and is continuing to process it
- The client should continue with the request
- The server is switching protocols

## Available Endpoints

### 1. 100 Continue
- **Endpoint**: `GET /api/informational/continue`
- **Description**: The server has received the request headers and expects the client to send the request body
- **Usage**: Typically used in POST requests where the client needs to send a large amount of data

### 2. 101 Switching Protocols
- **Endpoint**: `GET /api/informational/switching-protocols`
- **Description**: The server is switching protocols as requested by the client
- **Usage**: Commonly used for WebSocket connections or HTTP/2 upgrades

### 3. 102 Processing
- **Endpoint**: `GET /api/informational/processing`
- **Description**: The server has received and is processing the request, but no response is available yet
- **Usage**: Used for long-running operations where the server needs more time to process

### 4. 103 Early Hints
- **Endpoint**: `GET /api/informational/early-hints`
- **Description**: Used to return some response headers before the final HTTP message
- **Usage**: Helps with performance by allowing the client to start processing resources early

### 5. 104-199 Unassigned
- **Endpoint**: `GET /api/informational/unassigned`
- **Description**: These status codes are reserved for future use
- **Usage**: These codes should not be used in current implementations

### 6. All Codes Overview
- **Endpoint**: `GET /api/informational/all`
- **Description**: Get an overview of all informational status codes and their meanings

### 7. 100 Continue Example
- **Endpoint**: `POST /api/informational/upload-example`
- **Description**: Simulates a scenario where 100 Continue would be used
- **Headers**: 
  - `Expect: 100-continue` - Returns 100 Continue status
  - No header - Returns 200 OK status

## How to Run

1. **Prerequisites**: Java 21 and Gradle

2. **Build and Run**:
   ```bash
   ./gradlew bootRun
   ```

3. **Access the Application**:
   - Web Interface: http://localhost:8080
   - API Base URL: http://localhost:8080/api/informational
   - **Swagger UI**: http://localhost:8080/swagger-ui.html
   - **OpenAPI JSON**: http://localhost:8080/api-docs

## Testing the API

### Using cURL

```bash
# Test 100 Continue
curl -X GET http://localhost:8080/api/informational/continue

# Test 101 Switching Protocols
curl -X GET http://localhost:8080/api/informational/switching-protocols

# Test 102 Processing
curl -X GET http://localhost:8080/api/informational/processing

# Test 103 Early Hints
curl -X GET http://localhost:8080/api/informational/early-hints

# Test 199 Unassigned
curl -X GET http://localhost:8080/api/informational/unassigned

# Test 100 Continue with Expect header
curl -X POST http://localhost:8080/api/informational/upload-example \
  -H "Expect: 100-continue" \
  -H "Content-Type: application/json" \
  -d '{"test": "data"}'
```

### Using the Web Interface

1. Open http://localhost:8080 in your browser
2. Click on any of the test buttons to see the responses
3. The response will show both the status code and the JSON response

### Using Swagger UI

1. Open http://localhost:8080/swagger-ui.html in your browser
2. Explore the interactive API documentation
3. Test endpoints directly from the Swagger interface
4. View request/response schemas and examples

## Response Format

All endpoints return JSON responses with the following structure:

```json
{
  "status": "100 Continue",
  "message": "The server has received the request headers and expects the client to send the request body",
  "description": "This status code indicates that the server has received the request headers and the client should proceed to send the request body",
  "usage": "Typically used in POST requests where the client needs to send a large amount of data"
}
```

## Real-World Usage Examples

### 100 Continue
- Large file uploads where the client wants to check if the server is ready before sending the file
- POST requests with large payloads where the client wants confirmation before proceeding

### 101 Switching Protocols
- WebSocket connections: Client sends an upgrade request, server responds with 101
- HTTP/2 upgrades: When upgrading from HTTP/1.1 to HTTP/2

### 102 Processing
- Long-running operations like image processing or data analysis
- When the server needs time to process the request before providing a final response

### 103 Early Hints
- Performance optimization: Server can send resource hints before the main response
- Allows clients to start loading resources early

## Technical Details

- **Framework**: Spring Boot 3.5.3
- **Java Version**: 21
- **Build Tool**: Gradle
- **Dependencies**: Spring Boot Web Starter, Lombok, SpringDoc OpenAPI
- **Documentation**: Swagger/OpenAPI 3.0

## Project Structure

```
src/
├── main/
│   ├── java/com/http_learn/
│   │   ├── HttpLearnApplication.java
│   │   ├── controller/
│   │   │   └── InformationalStatusController.java
│   │   ├── service/
│   │   │   ├── InformationalStatusService.java
│   │   │   └── impl/
│   │   │       └── InformationalStatusServiceImpl.java
│   │   ├── dto/
│   │   │   └── InformationalResponseDto.java
│   │   ├── enums/
│   │   │   └── InformationalStatusCode.java
│   │   ├── config/
│   │   │   └── WebConfig.java
│   │   ├── exception/
│   │   │   └── GlobalExceptionHandler.java
│   │   └── util/
│   │       └── HttpStatusUtil.java
│   └── resources/
│       └── static/
│           └── index.html
└── test/
    └── java/com/http_learn/
        └── service/
            └── InformationalStatusServiceTest.java
```

## Learning Objectives

This API demonstrates:
1. How to return specific HTTP status codes in Spring Boot
2. The meaning and usage of each informational status code
3. Real-world scenarios where these codes are used
4. How to handle different response types in web applications
5. **Best Programming Practices:**
   - Separation of Concerns (Controller, Service, DTO layers)
   - Dependency Injection and Interface-based design
   - Exception handling with global exception handler
   - Unit testing with proper test structure
   - Utility classes for common operations
   - Enum usage for type safety
   - Builder pattern for object creation
   - Logging with SLF4J
   - CORS configuration
   - RESTful API design principles
   - **API Documentation with Swagger/OpenAPI**
   - **Interactive API testing through Swagger UI**

## Further Reading

- [HTTP Status Codes - MDN](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)
- [RFC 7231 - HTTP/1.1](https://tools.ietf.org/html/rfc7231)
- [RFC 7540 - HTTP/2](https://tools.ietf.org/html/rfc7540) # http_learn
