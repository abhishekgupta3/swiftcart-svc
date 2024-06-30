# Swiftcart Application

Swiftcart is a E-commerce application developed using a microservices architecture. 
It allows browsing various products, adding items to cart and order products. This application is composed of several microservices developed with modern technologies.

## Functional Requirements
- user can view products based on type (mobile, laptop,...)
- user can view featured/top-selling products
- user can login/signup
- user can add products to cart
- user can view cart
- user can order products
- user can view all previous orders
- admin can view dashboard, view all orders, view all users, add new product to application

## Non-Functional Requirement
- system needs to be fault-tolerant, scalable, latency < 100ms

## Microservices

- **service-registry**: Service Registry or Discovery service using Spring Cloud Netflix Eureka.
- **api-gateway**: API Gateway using Spring Cloud Gateway.
- **product-service**: Product management microservice.
- **user-service**: Authentication of user microservice.
- **order-service**: User order management microservice.
- **cart-service**: User cart management microservice.

## Architecture

The architecture of this application is based on microservices, which allows for scalability and easier maintenance. 

## Technologies Used

### Development

- **Java**
- **Spring Boot**
- **Angular**
- **MySQL**

### Deployment

- **Docker**
- **Jenkins**
- **Maven**
- **Git**

## Prerequisites

- **Docker**: Ensure Docker is installed and running.
- **Jenkins**: Jenkins should be installed to run CI/CD pipelines.
- **Maven**: Maven should be installed to build the Java projects.
- **Git**: Git should be installed to clone repositories.

## Installation and Deployment

### Clone the Repository

```bash
git clone https://github.com/abhishekgupta3/swiftcart-svc/
```

### Build the Services

Use Maven to build the Java services:

```bash
cd service-registry
mvn clean install -DskipTests
cd ../api-gateway
mvn clean install -DskipTests
cd ../product-service
mvn clean install -DskipTests
cd ../user-service
mvn clean install -DskipTests
cd ../order-service
mvn clean install -DskipTests
cd ../cart-service
mvn clean install -DskipTests
```

## Jenkins Pipeline

The Jenkins pipeline is defined in the `Jenkinsfile` and includes the following stages:

1. **CLONE**: Clone the Git repository.
2. **BUILD**: Build the services with Maven and runs unit tests.
3. **IMAGE**: Build Docker images.
4. **PUSH**: Push Docker images to Docker Hub.

## Contributions

Contributions are welcome! Please submit a pull request for any improvements or fixes.

