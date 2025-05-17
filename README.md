📦 Microservices Project

📖 Overview

This project is a microservices-based architecture consisting of the following services:

Order Service - Manages order-related operations.

Customer Service - Manages customer-related operations.

Eureka Server - Service registry and discovery.

API Gateway - Acts as a single entry point for client requests.

These services work together to form a robust, scalable system.

🌟 Features

Microservices architecture with dynamic service discovery.

Centralized API Gateway for routing.

Service-to-service communication using Feign Clients.

Eureka Server for dynamic service discovery.

Centralized monitoring using Spring Boot Actuator.

Uses Spring Boot 3.4.5 and Java 17.

Includes PostgresSQL Database for data persistence.

🛠️ Technologies Used

Java 17

Spring Boot 3.4.5

Spring Cloud Netflix Eureka

Spring Cloud Gateway

Feign Client

Spring Data JPA


Maven as the build tool

🗂️ Project Structure

microservices-project/
├── order/
├── customerservice/
├── eurekaRegistry/
├── apiGateway/
└── README.md

Service Details

Order Service: Handles order creation, update, retrieval, and deletion.

Customer Service: Manages customer profiles and details.

Eureka Server: Central service registry for managing microservice instances.

API Gateway: Routes external requests to the appropriate microservice.

🚀 Getting Started

Prerequisites

Java 17+

Maven


Git (for version control)

Step 1: Clone the Repository

git clone https://github.com/YOUR_USERNAME/microservices-project.git
cd microservice

Step 2: Build the Project

mvn clean install

Step 3: Run the Services Individually

Eureka Server:

cd eureka-server
mvn spring-boot:run

Order Service:

cd order-service
mvn spring-boot:run

Customer Service:

cd customer-service
mvn spring-boot:run

API Gateway:

cd api-gateway
mvn spring-boot:run

📝 Configuration

Eureka Server

URL: http://localhost:8761/

API Gateway

Port: 8082

Routes:

/api/orders/** -> Order Service

/customers/** -> Customer Service

📡 API Endpoints

Service

Endpoint

Description

Order Service

/api/orders

Get all orders

Order Service

/api/orders/{id}

Get order by ID

Customer Service

/customers

Get all customers

Customer Service

/customers/{id}

Get customer by ID

API Gateway

/api/orders/**

Proxy to Order Service

API Gateway

/customers/**

Proxy to Customer Service

🛠️ Monitoring and Health

Access actuator endpoints via API Gateway:

Health: http://localhost:8082/actuator/health

Info: http://localhost:8082/actuator/info


📝 Troubleshooting

Service Unavailable:

Ensure Eureka Server is up before starting microservices.

API Gateway Routing Issues:

Check gateway routes configuration.

💬 Contact

For any issues, reach out to:

Author: Harshavardhan Chintala

Email: Harshavardhanchintalaa@gmail.com

