# EMR Backend #

This is a **Spring Boot** backend for an **Electronic Medical Records (EMR)** system, using **PostgreSQL** as the database. The project will allow users to search for patients and view detailed patient profiles, including demographics, medical conditions, allergies, medications, lab results, clinical encounters, consultant letters, and test reports.

---

## Tech Stack

- **Backend Framework:** Spring Boot  
- **Database:** PostgreSQL  
- **ORM:** Spring Data JPA / Hibernate  
- **Build Tool:** Maven  
- **Language:** Java 17+

---

## Project structure ##

emr-backend/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/emr/
│ │ │ ├── EmrBackendApplication.java # Main Spring Boot app
│ │ │ ├── model/ # JPA entities
│ │ │ ├── repository/ # Spring Data JPA repositories
│ │ │ ├── controller/ # REST controllers
│ │ └── resources/
│ │ ├── application.properties # DB and JPA config
│ │ └── schema.sql # Optional DB schema init
└── pom.xml # Maven project file

---

## Database

The project uses **PostgreSQL**. The database is named `emr_data`, and tables have been created for:

- `patients`  
- `medical_conditions`  
- `allergies`  
- `medications`  
- `lab_results`  
- `encounters`  
- `providers`  
- `consultant_letters`  
- `test_reports`  

See docs/schema.sql

---

## Getting Started

### Prerequisites

- Java 17+  
- Maven  
- PostgreSQL  
- IDE (e.g., VS Code, IntelliJ) with Java support  

### Steps

1. Clone the repository:

```bash
git clone https://github.com/your-username/emr-backend.git
cd emr-backend


2. Configure database connection in src/main/resources/application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/emr_data
spring.datasource.username=emr_user
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

3. Build and run the application:
./mvnw spring-boot:run

The backend REST API will run at http://localhost:8080
