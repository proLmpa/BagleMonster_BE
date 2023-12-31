﻿# BagleMonster_BE
<h2>01. 프로젝트 소개</h2>

<h3>서비스 명: BagleMonster</h3>

**BagleMonster는 전국 베이글 전문점에서 하루에 발생하는 1 백만 건 이상의 주문을 처리하기 위한 커머스 서비스입니다.**

> FE 깃헙 주소 : https://github.com/proLmpa/BagelMonster_FE

<br>

<h3>목표</h3>

[ 백엔드 ]
1. 프론트엔드 - 백엔드 개발자 간 협업을 위한 CORS 설정 경험
2. 대용량 트래픽을 다루기 위해 Redis Cache를 적용하여 조회 속도 향상 및 DB 과부하 예방
3. 대용량 데이터를 다루기 위해 FETCH JOIN을 이용한 JPA N + 1 문제 해결 (진행 중)

[ 프론트엔드 ]
1. 반응형 UI
2. Next.js 적용 후 리팩토링 및 최적화

<br>

<h3>주요 기능</h3>

[ 공통 ]
- 회원 가입, 로그인

[ 소비자 ]
1. 가게, 상품 전체/단일 조회
2. 장바구니 CRUD

[ 판매자 ]
1. 가게 CRUD
2. 상품 CRUD
3. 주문 RUD
   <br><br>

<h2>02. 팀 구성 및 업무 소개</h2>

* 프로젝트 수행 기간 (**2주**) : 11.06(월) ~ 11.17(금)
* 프로젝트 인원 구성 (**6인**) : 백엔드 2인, 프론트엔드 3인, 디자이너 1인

| 팀 구성 | 역할        | 담당한 업무                                                                                                             |
|------|-----------|--------------------------------------------------------------------------------------------------------------------|
| 조해나  | 백엔드 로직 구현 | -  Store, Product, Cart, CartProduct 도메인 CRUD 구현 <br> - AWS S3 통한 이미지 등록/삭제 <br> - SSE를 활용한 알림 기능 구현               |
| 김희열  | AWS 배포    | - Order 도메인 RUD 구현  <br> - AWS EC2, AWS Amplify를 통한 애플리케이션 배포 <br> - CORS 설정 <br> - 도메인에 대한 SSL 인증서를 발급받아 https 적용 |

<br>

<h2>03. 기술 스택</h2>

<h6>back-end</h6>
<p style="display: block;">
    <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&amp;logoColor=white">
    <img src="https://camo.githubusercontent.com/c1fc168684171582321954905e8b9dc4f59810243ed85e645f3b7938ee3145cb/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&amp;logo=mysql&amp;logoColor=white">
    <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white">
    <img src="https://img.shields.io/badge/Spring%20Security-6DB33F.svg?style=for-the-badge&logo=Spring-Security&logoColor=white">
    <img src="https://camo.githubusercontent.com/a4797e4acda6db88d63a7a0ef7332bd6a3e7cf9282fa0d7d1af6605efe11929c/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f537072696e672044617461204a50412d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=for-the-badge&amp;logo=&amp;logoColor=white">
    <img src="https://camo.githubusercontent.com/78f3152017f7dae410d842069791c2518dfc6d1a842e50b99ad5c4ed30ee0ae4/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f48696265726e6174652d3539363636433f7374796c653d666f722d7468652d6261646765266c6f676f3d68696265726e617465266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&amp;logo=hibernate&amp;logoColor=white">
    <img src="https://camo.githubusercontent.com/c0f71772804c86d0f144ce923027aff25e8d761c6b791d2de6698607e21c5465/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f677261646c652d3032333033413f7374796c653d666f722d7468652d6261646765266c6f676f3d677261646c65266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&amp;logo=gradle&amp;logoColor=white">
    <img src="https://camo.githubusercontent.com/5af78a02d0f7a4b8a759f9580ce718287a0626f80a55c38ad0bac83e0b31f94d/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d3030303030303f7374796c653d666f722d7468652d6261646765266c6f676f3d6a736f6e776562746f6b656e73266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&amp;logo=jsonwebtokens&amp;logoColor=white">
  </p>

<h6>server</h6>
  <p style="display: block;">
    <img src="https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white">
    <img src="https://img.shields.io/badge/AWS EC2-f90?style=for-the-badge&logo=amazon-awsec2&logoColor=white">
    <img src="https://img.shields.io/badge/AWS RDS-f90?style=for-the-badge&logo=amazon-aws-RDS-f90&logoColor=blue">
    <img src="https://img.shields.io/badge/AWS S3-f90.svg?style=for-the-badge&logo=amazon-aws-S3&logoColor=green">
    <img src="https://img.shields.io/badge/AWS Amplify-f90.svg?style=for-the-badge&logo=amazon-aws-Amplify&logoColor=red">
    <img src="https://img.shields.io/badge/AWS Route53-f90.svg?style=for-the-badge&logo=amazon-aws-Route53&logoColor=purple">
  </p>

<h6>develop</h6>
  <p style="display: block;">
    <img src="https://camo.githubusercontent.com/699cfd7f3bb6a4e1764449f9b0da88a99a8d46bee71b93752b15ee8fbca5026a/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f496e74656c6c694a20494445412d3030303030303f7374796c653d666f722d7468652d6261646765266c6f676f3d496e74656c6c694a2049444541266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=for-the-badge&amp;logo=IntelliJ IDEA&amp;logoColor=white">
    <img src="https://img.shields.io/badge/GitHub-181717.svg?style=for-the-badge&logo=GitHub&logoColor=white">
    <img src="https://img.shields.io/badge/Git-F05032.svg?style=for-the-badge&logo=Git&logoColor=white">

  </p>

<h6>tools</h6>
  <p style="display: block;">
    <img src="https://camo.githubusercontent.com/3f0e26b0951bab845a1bb9a7198ecca0da272e462921b6edd85879f3673b6927/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f506f73746d616e2d4646364333373f7374796c653d666f722d7468652d6261646765266c6f676f3d706f73746d616e266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&amp;logo=postman&amp;logoColor=white">
    <img src="https://img.shields.io/badge/Swagger-85EA2D.svg?style=for-the-badge&logo=Swagger&logoColor=black">
    <img src="https://camo.githubusercontent.com/c37f52fc7f77f8a8fd16a733a91c75278dcb3149e14c24a2203d7f7217bb4643/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f536c61636b2d3441313534423f7374796c653d666f722d7468652d6261646765266c6f676f3d536c61636b266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&amp;logo=Slack&amp;logoColor=white">
    <img src="https://img.shields.io/badge/Notion-000000.svg?style=for-the-badge&logo=Notion&logoColor=white">
  </p>

<br>

<h2>04. 서비스 아키텍처</h2>

![베이글몬스터 서비스 아키텍처](https://github.com/proLmpa/BagleMonster_BE/assets/52267654/db55dad0-c04f-4c85-b011-b4d105979a27)

<br>

<h2>05. 기술적 의사결정</h2>

| 기술 스택             | 사용 이유                                               |
|-------------------|-----------------------------------------------------|
| JWT               | 서버 메모리에 부담을 주지 않고 서버 확장에 용이한 인증/인가 방식               |
| AWS EC2           | 백엔드 서버 배포를 위해 사용                                    |
| AWS Amplify       | 프론트 뷰 배포를 위해 사용                                     |
| AWS Route53 & ACM | 도메인 구매 후 SSL 인증서를 발급 받아 https 적용                    |
| SSE               | 사용자 주문 완료 및 가게의 주문 취소 event를 단방향으로 프론트에게 전달하기 위해 적용 |

<details>
<summary>SSE</summary>
<div markdown="1">

* ❗발단

    1. 프론트엔드 측에서 고객이 주문 완료 시 가게에 알림이 실시간으로 전송될 것을 요청
    2. 알림 기능 추가와 함께 실시간 통신이 필요하여 해당 부분에 대한 기술적 의사 결정이 필요하게 됨.

* ⛵ 실시간 통신 방법
  * Polling
    * 주기적으로 서버에 요청을 보내 데이터 업데이트를 확인하는 방법
    * 서버의 부하를 낮추는 데 유용하지만, 실시간성은 상대적으로 낮을 수 있음
    * 따라서 데이터 업데이트가 빈번하지 않고 지연이 허용되는 경우에 적합함
    
  * Long-Polling
    * 롱 폴링은 폴링의 확장 버전으로, 서버가 새 데이터를 가용할 때까지 응답을 보류함
    * 롱 폴링은 실시간성을 향상시킬 수 있지만, 여전히 클라이언트와 서버 간에 더 많은 리소스를 사용

  * SSE (Server-Sent Event)
    * 클라이언트에서 서버로부터 데이터를 비동기적으로 수신하는 방법
    * 특히 서버에서 클라이언트로 실시간 이벤트를 푸시할 때 유용
    * SSE는 단방향 통신이므로 클라이언트에서 서버로 데이터를 보내는 데는 Web Socket보다 제한적

  * Web Socket
    * Web Socket은 양방향 실시간 통신을 지원하는 풍부한 기능을 제공
    * 클라이언트와 서버 간에 연결을 유지하고 언제든지 데이터를 교환할 수 있음
    * 따라서 실시간 채팅 애플리케이션 및 실시간 게임과 같이 양방향 통신이 필요한 시나리오에 적합함

* 결론
    1. 본 프로젝트에서 알림 기능은 가게 측이 주문 확인을 비교적 빠르게 하기 위한 실시간 통신을 위해 필요한 것
  2. 이는 간단한 정보 업데이트 및 푸시 알림이기 때문에 SSE와 롱 폴링으로도 충분할 것이라고 판단함
  3. 서버 최적화 측면에서 볼 때 SSE가 Long-Polling 보다 훨씬 효율적임
     ⇒ 서버에서 클라이언트로 데이터를 푸시하는 방식이기 때문에, 연결 수가 많더라도 각 연결에 대한 부하가 낮고, 클라이언트와의 연결을 관리하는 부담도 적다.
  4. 프로젝트 적합성과 서버 최적화 측면을 고려하여 SSE 방법을 채택하기로 결정함
  * 관련 PR: https://github.com/proLmpa/BagleMonster_BE/pull/16

</div>
</details>

<br>

<h2>06. 트러블 슈팅</h2>

<details>
<summary>주문 객체의 상태 판단</summary>
<div markdown="1">

* ❗발단

  1. 기존 Cart 객체가 회원과 가게 사이의 다대다 연관관계의 중간 테이블 역할을 수행하면서 이를 활용하는 입장에 따라 도메인이 달리 해석될 수 있음을 판단
  2. 이를 구분하기 위해 회원은 기존에 사용하던 대로 Cart를 장바구니로 사용하면서 가게는 이를 Order라는 주문 내역으로 사용하도록 구분지음
  3. 그에 따라 현재 Cart의 상태를 회원과 가게의 상태에 따라 바꿔야 된다는 문제가 제기되면서 이를 다루기 위한 방법을 트러블슈팅함

* ⛵ 전개 <br>

  1. 회원(소비자) 입장을 다룬 상태(status) 필드는 boolean 값을 통해 true면 주문 내역, false면 장바구니로 사용되도록 설정함
  2. 위와 별개로 가게(판매자) 입장을 다룬 상태(storeStatus) 필드를 정의해 상태를 NEW_ORDER(새 주문) / READ(읽음) / SOLD(판매) / CANCELED(취소)의 enumerate로 정의함
    - NEW_ORDER : 소비자가 최초 장바구니(Cart) 생성 시
    - READ : 가게가 NEW_ORDER 상태의 주문에 대해 확인 요청을 보낼 경우
    - SOLD : 상품 판매가 완료되었을 경우
    - CANCELED : 가게에서 주문 취소 요청을 보낼 경우

* ➡️ 결과

  ⇒ 동일한 도메인에 대해 사용자의 역할(role)에 따라 구별된 도메인을 제공함으로써 회원과 가게가 서로의 상태를 고려하지 않고 자유롭게 상태를 바꿀 수 있는 환경이 조성됨.
  * 관련 PR : https://github.com/proLmpa/BagleMonster_BE/pull/12

</div>
</details>

<details>
<summary>CORS</summary>
<div markdown="2">

* ❗발단

   1. 프론트엔드가 React, 백엔드가 Spring에서 각각 프로젝트를 진행함에 따라 포트 번호, 즉 오리진이 다르게 되면서 SOP를 벗어나게 됨
   2. 서로 다른 오리진 간 리소스 교환을 위한 CORS 설정이 필수적이게 됨

* ⛵ 적용 과정 <br>
   1. CORS 환경 설정 (@Configuration)
      - addMapping(”/**”) : 모든 API 경로명에 대한 접근 허용
      - allowedOrigins(”*”) : 모든 Origin으로부터의 접근 허용
      - allowedMethods(”GET”, “POST”, “PUT”, “DELETE”, “OPTIONS”) : 매개 변수로 전달된 HTTP 메서드명에 대해 접근 허용
      - allowedHeaders(”*”) : 모든 Header에 대한 접근 허용
      - maxAge(3000) : 결과가 캐시로 저장되어 있을 수 있는 시간을 3000초로 지정

   2. WebSecurityConfig
      - CORS 설정 시 Spring Security가 적용된 경우 security filter에 http.cors()로 cors를 허용해야 함

<br>

* ➡️ 결과 : React - Spring CORS 적용 완료

* 아쉬운 점
   - 프론트엔드 작업자들이 백엔드 서버로 보내는 요청들을 수용하기 위해 모든 Origin에 대한 요청을 허용했지만 이것이 좋은 방법은 아니라고 여김
   - 배포를 마친다면 allowedOrigins() 함수의 매개 변수를 프론트 배포 도메인 주소인 "https://baglemonster.twogetherwork.com" 만으로 구성할 예정이지만 여전히 부족하다고 여김
   - AWS Multi-AZ 배포를 통해 prod과 dev 환경을 별도로 구별하는 방법 등을 고민

 <br>
</div>
</details>

<details>
<summary>Redis를 이용한 데이터 조회 향상</summary>
<div markdown="3">

* ❗문제

    1. 1 백만 건 이상의 데이터 조회 발생 시 데이터베이스 과부하를 방지하기 위한 방법을 고민함
    2. AWS RDS의 Master - Slave 구조, Redis를 이용한 데이터 캐싱 중 인-메모리 DB를 통한 데이터 조회 속도 향상까지 경험하기 위해 Redis로 결정함.

* ⛵ 적용 과정
    1. Redis Configuration 추가
  2. 가게 단일 조회 기능 최초 수행 시 MySQL에서 가져온 DTO로 변환 후 Redis에 캐싱 (Lazy Loading)
  3. 가게 수정 및 상품 등록/수정/삭제 수행 시 Redis에 캐싱된 dto 삭제 로직 추가

<br>

* ➡️ 결과
  ⇒ 조건 : 상품 25개가 등록된 단일 가게에 대해 1000번 요청 수행
  * MySQL : 수행 시간(1m 40s), 평균 응답 시간(12ms)
  
    ![mysql_running_result](https://github.com/proLmpa/BagleMonster_BE/assets/52267654/5d2e4a1c-132f-4ab2-ab39-5dd0970d16f7)
  
  * Redis : 수행 시간(1m45s), 평균 응답 시간(11ms)
  
    ![redis_running_result](https://github.com/proLmpa/BagleMonster_BE/assets/52267654/32f0037d-6c81-4c67-bfdd-9ce4089fffd4)

  ⇒ 결과 : 단일 MySQL을 사용한 경우와 Redis를 적용한 경우 모두 서로 미세한 성능 차이를 보임
  ⇒ 분석 : 등록된 상품의 수가 너무 적어 성능의 차이를 비교하기 어려움. MySQL 프로시져 등을 통해 Mock 데이터를 수천 개 이상 추가할 필요가 있음
  * 관련 PR : https://github.com/proLmpa/BagleMonster_BE/pull/15
  
</div>
</details>

<br>

<h2>07. ERD 설계도 </h2>

![베이글몬스터 최종 ERD](https://github.com/proLmpa/BagleMonster_BE/assets/52267654/ccde4332-0c50-47fa-8332-fdb1d98932d6)

> ERD 원본 확인하기 : https://www.erdcloud.com/d/Pdu6txpyBqHk7oN2b
<br>

<h2>08. API 설계도 </h2>

> API 원본 확인하기 : https://docs.google.com/spreadsheets/d/16hrlJtJsRxIR2JGB27hq91LDS3BlU0y5kxHWjP2GgLA/edit?usp=sharing
<br>
