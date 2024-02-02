# YCHAT Chat Application

Welcome to the  YChat Chat Application! This application is built using Spring Boot for the backend, React for the frontend, and WebSocket for real-time communication. It utilizes JWT for secure authentication. This document will guide you through setting up the project, understanding its architecture, and deploying it using Docker.

## Project Overview

The Chat Application allows users to sign up, log in, and chat in real-time with other users. It's designed to be scalable and secure, leveraging Spring Boot's WebSocket support and JWT for authentication.

## Technology Stack

- **Backend**: Spring Boot, WebSocket, JWT
- **Frontend**: React
- **Database**: MySQL
- **Containerization**: Docker

## Getting Started

### Prerequisites

- Java JDK 11 or later
- Node.js and npm
- Docker
- A running instance of MYSQL

### Installation Steps

* **Clone the repository**

```bash
git clone https://github.com/Rytnix/ChatApplication.git
cd ChatApplication
```

### Backend Setup
* **Navigate to the backend directory and build the project using Maven.**

```bash
cd backend
./mvnw clean install
```

### Frontend Setup
* **Navigate to the frontend directory and install the necessary dependencies.**

```bash
cd ../frontend
npm install
npm start
```

### Environment Configuration
* **Configure the application.properties file for the backend to include your database and JWT settings.**

```properties
spring.datasource.url=jdbc:<YOUR_DATABASE>:<URL>
spring.datasource.username=<DB_USERNAME>
spring.datasource.password=<DB_PASSWORD>
jwt.secret=<YOUR_SECRET_KEY>
```

### Run the Application
* **Backend:** From the backend directory, run the Spring Boot application.

```bash
./mvnw spring-boot:run
```

* **Frontend:** From the frontend directory, start the React application.

```bash
npm start
```