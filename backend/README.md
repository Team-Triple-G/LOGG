# 백엔드

## 서버

### LOGG
 - port: 8080
 - 폴더 구조
 ```
 ├── main
│   ├── java
│   │   └── com
│   │       └── ggg
│   │           └── logg
│   │               ├── LoggApplication.java
│   │               ├── application
│   │               │   ├── ApplicationService.java
│   │               │   └── user
│   │               │       ├── UserService.java
│   │               │       └── UserServiceImpl.java
│   │               ├── domain
│   │               │   ├── common
│   │               │   │   ├── BaseEntity.java
│   │               │   │   ├── DomainModel.java
│   │               │   │   ├── DuplicatedException.java
│   │               │   │   ├── HashIdGenerator.java
│   │               │   │   └── ResourceNotFoundException.java
│   │               │   └── user
│   │               │       ├── User.java
│   │               │       ├── UserDetail.java
│   │               │       ├── UserEntity.java
│   │               │       ├── exception
│   │               │       │   ├── IllegalPasswordException.java
│   │               │       │   └── UserNotFoundException.java
│   │               │       └── repository
│   │               │           ├── CustomizedUserRepository.java
│   │               │           └── UserRepository.java
│   │               ├── infrastructure
│   │               │   └── domain
│   │               │       └── jpa
│   │               │           ├── config
│   │               │           │   └── QueryDslConfig.java
│   │               │           └── user
│   │               │               ├── JPAUserRepository.java
│   │               │               └── JPAUserRepositoryImpl.java
│   │               └── web
│   │                   ├── advice
│   │                   │   └── ControllerAdvice.java
│   │                   ├── controller
│   │                   │   └── UserController.java
│   │                   ├── request
│   │                   │   └── user
│   │                   │       ├── UserLoginRequest.java
│   │                   │       └── UserRegisterRequest.java
│   │                   └── response
│   │                       ├── ApiResponse.java
│   │                       └── user
│   │                           └── UserLoginResponse.java
│   └── resources
│       ├── application.yml
│       ├── static
│       └── templates
└── test
    └── java
        └── com
            └── ggg
                └── logg
                    ├── LoggApplicationTests.java
                    ├── TestConstant.java
                    ├── application
                    │   └── UserServiceTest.java
                    ├── domain
                    │   └── user
                    │       └── UserRepositoryTest.java
                    ├── infrastructure
                    │   └── domain
                    │       └── jpa
                    │           └── user
                    └── web
                        └── controller
                            ├── MockMvcFilterConfig.java
                            └── UserControllerTest.java
 ```

## 스택

### 언어 및 프레임워크

- Java 1.8
- Spring Boot 2.5.6


### 데이터베이스
- h2
  - 실서버 및 테스트 포함
- Spring Data JPA, hibernate

### 테스트 및 문서화
- Swagger-ui
- jacoco

<br/>
  
## 한거
- Dto 설계하기
  - 컨트롤러 단 response 통일하기
    - `ApiResponse.class`
  
  - 예외, Dto, Response 세부 클래스 세분화하기

- 유닛 테스트하기
  - MockMvc로 슬라이스 테스트하기

- 테스트 커버리지 채우기
  - 목표 80%
  
- 컨트롤러 Exception handling
  - `@RestController Advice`
  - aop

- Entity Repository 만들기
  - DDD로 패키지 구조 및 비즈니스로직 짜기

- 모든 클래스 문서화
  - 저자 목적 버전 기록

<br/>


## 이거도해야지

- MSA 구조 설계
  - 기능별 서버 분리 

- 테스트 커버리지로 빌드 제한걸기(커버리지 테스트 자동화)


- aop 적용하기
  - 공통처리할 부분이 생기면.,  

- redis
  - 메시지 큐(Pub-sub)
  - 캐시 DB(토큰 등..)

- mariaDB
  - 저장할 유의미한 데이터가 생기면

- security 관련 직접 한땀한땀 다짜보기
  - 권한 관련  
  - oauth2(oauth2-client)
  - 엔드포인트 필터링
  - JWT 발급(refresh 포함)
