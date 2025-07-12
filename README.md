# 📚 Library Book Catalog API

A Spring Boot-based RESTful API for managing a library's book catalog. It supports operations like adding, retrieving, updating, and deleting books, along with availability management.

---

## 🚀 How to Run the Project

### ✅ Prerequisites

- Java 21
- Maven 3.5.3
- MySQL
- IDE- Eclipse

---

### 🏁 Steps to Run

1. **Clone the repository**

```bash
git clone https://github.com/Mayureshwar2404/LibraryBookCatalog.git
cd LibraryBookCatalog

2.Run with Maven

bash
mvn spring-boot:run


3.Access the app
API Base URL: http://localhost:8080/books

Requests on postman

GET http://localhost:8080/books

GET http://localhost:8080/books/1

POST http://localhost:8080/books

DELETE http://localhost:8080/books/2

PATCH http://localhost:8080/books/1/availability?available=false
