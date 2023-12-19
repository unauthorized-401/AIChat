# Start chatting with AI on Messenger!

## 1) Project Information

Goal
- Develop messenger service with **spring-ai** framework

Function
- Join the membership
- Login and Logout
- Chat with AI
  - Start new
  - Continue previous

Reference
- [Document](https://docs.spring.io/spring-ai/reference/index.html)
- [GitHub Repository](https://github.com/spring-projects/spring-ai)

---

## 2) Develop Information

Environment
- IntelliJ
- Java 17 + Spring Boot 3.2.0
- H2 2.2.224
- [Swagger](localhost:8080/swagger-ui.html)

Database

|TABLE|COLUMN|TYPE|DESCRIPTION|
|-----|------|----|-----------|
|ACCOUNT|USER_NAME|STRING|-|
|ACCOUNT|USER_ID|STRING|UNIQUE ID|
|ACCOUNT|PASSWORD|STRING|-|
|CHAT|ID|LONG|UNIQUE ID|
|CHAT|TYPE|INT|0: AI, 1: USER|
|CHAT|MESSAGE|STRING|-|
|CHAT|DATE|DATE|-|

API
- Join the membership
```
POST /common/account/join

{
  "userName": "jiwon",
  "userId": "jiwon",
  "password": "jiwon"
}
```

- Login
```
POST /common/account/login

{
  "userId": "jiwon",
  "password": "jiwon"
}
```

- Logout
```
GET /common/account/logout/{userId}
```

- Send the request
```
POST /common/chat/request

{
  "request": "what's your name?"
}
```

- Get response
```
POST /common/chat/response

{
  "response": "my name is olivia"
}
```

---

## 3) Service Information

How to build & run
```
// 1) bring sources
git clone https://github.com/unauthorized-401/AIChat.git

// 2) move to project and build
cd AIChat
gradlew build

// 3) run project
cd build/libs
java -jar aichat-0.0.1-SNAPSHOT.jar
```