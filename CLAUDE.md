# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

You are assisting with a Java microservices project using Spring Boot and Spring Cloud.
All explanations, comments, and reasoning should be written in **Chinese**.
Always output complete code inside Markdown code blocks (e.g. ```java``` or ```xml```).

When editing or reading files, follow these rules:

1. If an **"error editing file"** occurs, DO NOT attempt to write again.  
   Instead, output the **entire modified file content** inside a Markdown code block,
   and include this message before the code:
   > "An error occurred while editing the file. Here is the full modified code, please save it manually."

2. If an **"error reading file"** occurs, DO NOT stop the process.  
   Regenerate the file content from scratch and output it completely,
   with this message before the code:
   > "An error occurred while reading the file. I have regenerated the complete file content, please replace it manually."

3. Always use **Chinese** when explaining, commenting, or describing your reasoning.  
   Only the code itself should remain in English.


## Project Overview

This is a Java microservices project built with Spring Boot and Spring Cloud. It uses Maven for dependency management and project lifecycle. The main application module is `order-provider-9000-service`.

The technology stack includes:
- **Frameworks**: Spring Boot, Spring Cloud, Spring Cloud Alibaba
- **Data Access**: MyBatis, tk.mybatis (Mapper), Druid for connection pooling
- **Database**: MySQL
- **API Documentation**: Swagger (springdoc-openapi)
- **Utilities**: Lombok, Hutool, Fastjson2

## Common Commands

### Build the Project
To build all modules, run the following command from the root directory:
```bash
mvn clean package
```

### Run the Application
To run the `order-provider-9000-service`, you can use the following command after building the project:
```bash
java -jar order-provider-9000-service/target/order-provider-9000-service-*.jar
```
Alternatively, you can run the `main` method in the `com.wsj.OrderConsumer8000Service` class from your IDE.

### Run Tests
To run the tests for all modules, use the following command from the root directory:
```bash
mvn test
```

## Code Architecture

The project follows a standard multi-module Maven layout.

- **`pom.xml` (root)**: The parent POM that defines the overall project structure, dependency management, and properties for all modules. It manages versions for Spring Boot, Spring Cloud, and other key libraries.
- **`order-provider-9000-service/`**: A Spring Boot microservice module. This is likely a service provider within the larger microservices architecture. It exposes RESTful APIs documented with Swagger. Data persistence is handled by MyBatis.