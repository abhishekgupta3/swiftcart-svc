# Swiftcart Application

Swiftcart is an E-commerce application developed using a microservices architecture. 
It allows browsing various products, adding items to a cart, and ordering products. This application is composed of several microservices developed with modern technologies.

## Functional Requirements
- users can view products based on type (mobile, laptop, etc.)
- user can view featured/top-selling products
- user can log in/signup
- user can add products to the cart
- user can view the cart
- user can order products
- user can view all previous orders
- admin can view the dashboard
- admin can view all orders, users
- admin can add new products to the application

## Non-Functional Requirements
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

![Screenshot 2024-06-30 211544](https://github.com/abhishekgupta3/swiftcart-svc/assets/54908686/dc6b03c8-9485-43b3-8943-14087abde48a)


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

## API Endpoints

### Product Service
| HTTP Verb | Endpoint                         | Details                        |
|-----------|----------------------------------|--------------------------------|
| GET       | /product?productId=id            | Get Product by id              |
| GET       | /products/all                    | Get all products               |
| GET       | /product/search?search=searchKey | Get all products by search key |
| GET       | /product/featured-products       | Get featured products          |
| POST      | /product                         | Add product                    |

### Order Service
| HTTP Verb | Endpoint      | Details                        |
|-----------|---------------|--------------------------------|
| GET       | /order/all    | Get all Orders                 |
| GET       | /order        | Get order of customer          |
| POST      | /order        | Add order for customer         |

### Cart Service
| HTTP Verb | Endpoint          | Details                    |
|-----------|-------------------|----------------------------|
| GET       | /cart             | Get user cart              |
| POST      | /cart/{productId} | Add item to user cart      |
| DELETE    | /cart/{productId} | Delete item from user cart |

### User Service
| HTTP Verb | Endpoint              | Details                    |
|-----------|-----------------------|----------------------------|
| GET       | /auth/users           | Get all Users              |
| GET       | /auth/user/{username} | Get user info for username |
| GET       | /auth/register        | Register user              |
| GET       | /auth/login           | Login user                 |


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

