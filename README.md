# Online Sponsored Ads Application

## Project Overview

This application serves as a module for ad tech companies, enabling sellers to create campaigns for promoting their products and manage product listings. It includes functionality to create advertising campaigns, serve ads based on product categories, and manage product information.

## Technologies Used

- Java
- Spring Boot
- Hibernate
- H2 In-Memory Database

## Getting Started

### Prerequisites

- Java (Version specified in `pom.xml`)
- Maven

### Setup

1. Clone the repository to your local machine.
2. Navigate to the project directory.

## Running the Application

1. To build the project, execute: `mvn clean install`.
2. To run the application, execute: `mvn spring-boot:run`.

## API Endpoints

### Create Campaign

- **Endpoint**: `/campaigns`
- **Method**: POST
- **Body**:
  ```json
  {
    "name": "Campaign Name",
    "startDate": "YYYY-MM-DDTHH:MM:SS",
    "productsSerialNumbers": [1, 2, 3],
    "bid": 1.0
  }
  ```

### Serve Ad

- **Endpoint**: `/ads/{category}`
- **Method**: GET
- **Path Variable**: `category` - String representing the category of products.

### Add Product

- **Endpoint**: `/products`
- **Method**: POST
- **Body**:
  ```json
  {
    "title": "Product Title",
    "category": "Product Category",
    "price": Product Price
  }
  ```

### Get Product by Serial Number

- **Endpoint**: `/products/{serialNumber}`
- **Method**: GET
- **Path Variable**: `serialNumber` - Long representing the serial number of the product.

### Get All Products

- **Endpoint**: `/products`
- **Method**: GET

## Database Schema

The application uses two main entities:

- **Product**: Represents a product with attributes like title, category, price, and a serial number.
- **Campaign**: Represents a group of products to promote, with attributes like start-date, bid, and name.

```

```
