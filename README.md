# Franchise Management Application

## Overview

The **Franchise Management Application** is a Spring Boot-based application designed to manage franchises, branches, and products efficiently.

---

## Features

- Create, Read, Update, and Delete (CRUD) operations for:
  - Franchises
  - Branches
  - Products
- Entity mapping using DTOs and Mappers for seamless data conversion.
- Reactive programming with Spring WebFlux for asynchronous processing.
- Integration with relation database in cloud
---

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Spring WebFlux**: Reactive programming for APIs.
- **Spring Data R2DBC**: Reactive database integration.
- **PostgreSQL**: Database for data persistence.
- **AWS RDS**
- **Maven**: Build and dependency management.
- **Postman**: For API testing and documentation.
- **Docker** Run app in a container.

---

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java** (version 17 or later)
- **Maven** (version 3.6 or later)
- **PostgreSQL** (version 15 or later)
- **Postman** (optional, for testing APIs)
- **Docker** (optional for running application)
---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/t1xgo/backend-nequi.git
cd franchises
```
## 2. Database

The database is already deployed with the services of AWS using RDS with a postgresql connection. So you do not have to setup anything related to databases.

## 3. Build the project
# Using mvn
```bash
mvn clean install
```
# Run the application
```bash
mvn spring-boot:run
```
If you do not want to use mvn, you can use docker instead because we have a DOCKERFILE that will help us with that.
# Using Docker
Inside the folder of the project. Run this in the terminal to install an image of the app.
```bash
cd franchises
docker build -t franchises .
```

Now to create a container. That is where the app will be running.
```bash
docker run -d -p 8080:8080 franchises
```
Now the app will be running in the port that was exposed in the localhost.

## 4. Sample playloads
In postman, I made a collection of some endpoints that will help you to get use to it. You just have to import in Postman Application and with the project running there will not be a problem.

---
## Contributors
Santiago Cano





