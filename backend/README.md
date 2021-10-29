# 백엔드

한땀한땀 직접 짜보기 복붙하면사형

## 서버 친구들

- LOGG
  - port: 8080

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

<br/>


## 이거도해야지
- Entity Repository 만들기

- 테스트 커버리지로 빌드 제한걸기(커버리지 테스트 자동화)

- 모든 클래스 문서화
  - 저자 목적 버전 기록



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
