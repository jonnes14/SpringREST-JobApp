# React + Spring Boot Job App Setup

This guide walks through creating a full-stack project with **Spring Boot (Backend)** and **React (Frontend)** from scratch, with clear structure and no extra clutter.

---

## 📌 Project Structure
```
project-root/
│
├── backend/        # Spring Boot API
│   ├── src/
│   ├── pom.xml
│
└── frontend/       # React app
    ├── src/
    ├── package.json
```

---

## 1️⃣ Create Spring Boot Backend

1. Go to [Spring Initializr](https://start.spring.io/).
2. Select:
   - **Project:** Maven
   - **Language:** Java
   - **Spring Boot Version:** 3.x (or 2.7.x if needed)
   - **Dependencies:** Spring Web, Spring Data JPA, PostgreSQL Driver, Lombok
3. Click **Generate** → unzip to `backend/` folder.

---

## 2️⃣ Configure `application.properties`
In `backend/src/main/resources/application.properties`:
```properties
spring.application.name=SpringDataJPA-ex
spring.datasource.url=jdbc:postgresql://localhost:5432/Springjdbc
spring.datasource.username=postgres
spring.datasource.password=admin
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 3️⃣ Create a Simple REST Controller
Example: `backend/src/main/java/com/example/demo/controller/HelloController.java`
```java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
```

Run backend:
```bash
cd backend
mvn spring-boot:run
```
Test at: [http://localhost:8080/api/hello](http://localhost:8080/api/hello)

---

## 4️⃣ Create React Frontend

From `project-root/`:
```bash
npx create-react-app frontend
```

---

## 5️⃣ Remove Unnecessary Files in `frontend/src/`
Delete:
- `App.test.js`
- `logo.svg`
- `reportWebVitals.js`
- `setupTests.js`

Replace `App.js` with:
```jsx
import React, { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch("/api/hello")
      .then((res) => res.text())
      .then((data) => setMessage(data));
  }, []);

  return (
    <div>
      <h1>React + Spring Boot</h1>
      <p>{message}</p>
    </div>
  );
}

export default App;
```

---

## 6️⃣ Setup Proxy for Backend Calls
In `frontend/package.json`:
```json
"proxy": "http://localhost:8080"
```

---

## 7️⃣ Run Frontend
```bash
cd frontend
npm start
```
The app should show:
```
React + Spring Boot
Hello from Spring Boot!
```

---

## 8️⃣ Build Frontend for Production
```bash
cd frontend
npm run build
```
This will create a `frontend/build` folder with static files.

---

## 9️⃣ Serve React from Spring Boot
Copy React build to Spring Boot’s `resources/static`:
```bash
rm -rf backend/src/main/resources/static/*
cp -r frontend/build/* backend/src/main/resources/static/
```

Update backend controller to serve `index.html` for all unknown routes:
```java
@Controller
public class WebController {
    @RequestMapping("/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
}
```

---

## 🔹 Notes
- `%PUBLIC_URL%` in `public/index.html` is replaced automatically during build.
- You **can delete** the `public/` folder if you don’t need favicons or meta tags.
- `exclude.txt` errors mean file not found in gitignore process — can be ignored if not used.

---

✅ Done — now your React app and Spring Boot API run together.
