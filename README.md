# Start chatting with AI on Messenger!

## 1) Project Information

Goal
- Develop messenger service with **spring-ai** framework

Function
- Sign Up
- Log In
- Chat with AI

Reference
- [Document](https://docs.spring.io/spring-ai/reference/index.html)
- [GitHub Repository](https://github.com/spring-projects/spring-ai)


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
|CHAT|USER_ID|STRING|UNIQUE ID|
|CHAT|TYPE|INT|0: AI, 1: USER|
|CHAT|MESSAGE|STRING|-|
|CHAT|DATE|DATE|-|

API
- Sign Up
```
POST /common/account/join

{
  "userName": "jiwon",
  "userId": "jiwon",
  "password": "jiwon"
}
```

- Log In
```
POST /common/account/login

{
  "userId": "jiwon",
  "password": "jiwon"
}
```

- Chat with AI
```
POST /common/chat/request

{
  "message": "what's your name?"
}
```


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