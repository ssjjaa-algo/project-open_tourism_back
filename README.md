# 프로젝트명

- Indecisivness (군것질팀)
    - 많은 기능이 아닌 **비기능에 집중**💥
    - 기간이 짧은 만큼 하나를 똑바로 알아보자
    - 이것 저것 해보며 아무거나 기록한다 👋
- 팀원
    
    
    | 강병선 | BE |
    | --- | --- |
    | 김성재 | BE |
- 진행일자
    - 2023.05.18 ~ 05.26

# 목표

- 전반적인 Web Architecture 이해
- 로그인 기능 관련 보안 로직을 설계한다.
- 처리율 제한 장치를 설계하고 작동 방식을 이해한다.
- XSS 스크립트 방어

## 개발 언어

- JAVA
- MYSQL

## 사용 툴

- Intellij
- MySQL
- Visual Studio Code

## Archiecture Diagram

![Untitled](https://github.com/ssjjaa-algo/CafeProjectBack/assets/57981401/ee7db21e-b57d-48d2-95b4-ecf4f8c2acb5)

## ERD

![Untitled (1)](https://github.com/ssjjaa-algo/CafeProjectBack/assets/57981401/b6dd8f8c-f71d-473e-af63-9874cb992fc2)

# 프로젝트 핵심

## 1. User의 비밀번호 해싱, Decoding시 필요한 salt 분리

- User의 정보가 들어있는 데이터베이스가 만약에 해킹당한다면?
    - 그 데이터베이스가 해킹당하더라도, 적어도 로그인은 못하게 할 수 있을까?
    - User 정보가 들어있는 DB에는 비밀번호를 해싱한 값을 저장한다.
    - 해싱한 값을 Decoding할 때 사용되는 salt는 다른 DB에 저장한다.
    - 목적
    
    <aside>
    💡 DB의 분리를 통해 1차 해킹 시 다른 DB의 정보라도 탈취 못하게 한다.
    
    </aside>
    

## 2. 처리율 제한 장치 설계

- 규모가 큰 서비스들은 하루 사이에도 엄청나게 많은 요청을 받는다.
- 현 프로젝트에서는 **미들웨어의 로드밸런싱 등은 이용하지 않음**
    - 개발 시간이 너무 적다!!!
- **토큰 버킷 알고리즘**으로 사용자의 접근 제한 횟수를 막아보자.
- 토큰 버킷 알고리즘의 작동 방식은 그나마 버스트 요청 처리가 가능하니 사용자도 상대적으로 덜 불편할 거라 생각
    - 참고서적 : 가상 면접 사례로 배우는 대규모 시스템 설계 기초
        - **4장 - `처리율 제한 장치의 설계`**

### 토큰 버킷 알고리즘 작동 박식

- 일정 시간마다 버킷을 생성
- 각 IP마다 버킷 생성
- 각 버킷에 일정 시간마다 토큰을 추가
- 버킷이 비어있을 때 요청이 날아오면 요청을 수행하지 않음

![Untitled (2)](https://github.com/ssjjaa-algo/CafeProjectBack/assets/57981401/eef2c42f-1d55-4ec1-8cd1-52b19c90a16a)

![Untitled (3)](https://github.com/ssjjaa-algo/CafeProjectBack/assets/57981401/f28a452b-0dd2-4266-b4e2-838749875df4)

## 3. Exception 세분화

- 장점
    - 가독성을 높이고 유지보수가 편리해진다.
    - 클라이언트 - 서버 통신 간의 편리성을 제공한다.
- 단점
    - 너무 많은 세분화는 오히려 유지보수를 어렵게 할 수 있다.
- 결론
    - 적당한 수준에 대해서 서로 합의 후 지정
    - RestContollerAdvice를 이용하여 예외를 한 곳에서 깔끔하게 관리한다.
    - Runtime Exception 상속도는 아래와 같음.

![Untitled (4)](https://github.com/ssjjaa-algo/CafeProjectBack/assets/57981401/c866a789-8adb-4a2d-a567-e819792e450b)
