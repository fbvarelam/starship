# Starship API

## Author

- **Fernando Varela Martínez**

## Overview

The Starship API is a RESTful service for managing starships from movies and series. It allows users to create,
retrieve, update, and delete starships, as well as search for starships by name.

## Technologies Used

- Java
- Spring Boot
- Maven
- Docker

## Getting Started

### Prerequisites

- Java 22 or higher
- Maven 3.6.0 or higher
- H2 Database

### Installation

1. Build the project:
    ```sh
    mvn clean install
    ```

2. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## API Endpoints

### Get All Starships

- **URL:** `/api/starships`
- **Method:** `GET`
- **Query Parameters:**
    - `page` (optional): Page number (default: 0)
    - `size` (optional): Number of items per page (default: 10)
- **Responses:**
    - `200 OK`: A paginated list of starships
    - `500 Internal Server Error`: Internal server error

### Create a New Starship

- **URL:** `/api/starships`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
      "name": "X-Wing",
      "type": "attack"
    }
    ```
- **Responses:**
    - `201 Created`: Starship created
    - `400 Bad Request`: Bad response
    - `500 Internal Server Error`: Internal server error

### Get a Starship by ID

- **URL:** `/api/starships/{id}`
- **Method:** `GET`
- **Path Parameters:**
    - `id`: ID of the starship to retrieve
- **Responses:**
    - `200 OK`: Starship found
    - `400 Bad Request`: Starship not found
    - `500 Internal Server Error`: Internal server error

### Update an Existing Starship

- **URL:** `/api/starships/{id}`
- **Method:** `PUT`
- **Path Parameters:**
    - `id`: ID of the starship to update
- **Request Body:**
    ```json
    {
      "name": "X-Wing",
      "type": "attack"
    }
    ```
- **Responses:**
    - `200 OK`: Starship updated
    - `400 Bad Request`: Starship not found
    - `500 Internal Server Error`: Internal server error

### Delete a Starship

- **URL:** `/api/starships/{id}`
- **Method:** `DELETE`
- **Path Parameters:**
    - `id`: ID of the starship to delete
- **Responses:**
    - `204 No Content`: Starship deleted
    - `400 Bad Request`: Bad response
    - `404 Not Found`: Not found
    - `500 Internal Server Error`: Internal server error

### Search for Starships by Name

- **URL:** `/api/starships/search`
- **Method:** `GET`
- **Query Parameters:**
    - `name`: Substring to search in starship names
- **Responses:**
    - `200 OK`: List of matching starships
    - `500 Internal Server Error`: Internal server error

## Running Tests

To run the integration tests, use the following command:

```sh
mvn test
```

## Docker Instructions

### Prerequisites

- Docker installed on your machine

1. Start the services:
    ```sh
    docker-compose up -d
    ```

2. Stop the services:
    ```sh
    docker-compose down
    ```