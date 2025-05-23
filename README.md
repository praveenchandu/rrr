# Spring Boot REST API Project (RRR)

This is a Spring Boot application that provides REST APIs for user management.

## Features

- REST API for managing users
- CORS configuration for cross-origin requests
- Sample user data loaded at startup

## Endpoints

- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get a specific user
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update a user
- `DELETE /api/users/{id}` - Delete a user

## Configuration

- Application runs on port 8099 by default
- CORS is configured to allow requests from http://localhost:3000

## Technologies Used

- Java 17
- Spring Boot 3.4.6
- Maven
- Spring Web
- Spring CORS

## How to Run

1. Clone this repository
2. Navigate to the project directory
3. Run `./mvnw spring-boot:run`
4. Access the API at http://localhost:8099/api/users

## Frontend

This API is designed to work with the React frontend application located in the reactPravPydi repository. 