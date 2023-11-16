# BagleMonster_BE
<h2>01. 프로젝트 소개</h2>

<h3>서비스 명: BagleMonster</h3>

**BagleMonster는 전국 베이글 전문점에서 하루에 발생하는 1 백만 건 이상의 주문을 처리하기 위한 커머스 서비스입니다.**
## 목적
 > 프론트엔드와 백엔드 간 협업
## 목표
 [ 백엔드 ]
1. 프론트엔드 - 백엔드 개발자 간 협업을 위한 CORS 설정 경험
2. 대용량 트래픽을 다루기 위한 Redis 캐시 및 로드 밸런서 적용
3. 대용량 데이터를 다루기 위해 FETCH JOIN을 이용한 JPA N + 1 문제 해결 (진행 중)

 [ 프론트엔드 ]
1. 반응형 UI
2. Next.js 적용 후 리팩토링 및 최적화

## 주요 기능
### 공통
 - 회원 가입, 로그인

### 소비자
1. 가게, 상품 전체/단일 조회
2. 장바구니 CRUD

### 판매자
1. 가게 CRUD
2. 상품 CRUD
3. 주문 RUD

 > FE 깃헙 주소 : https://github.com/proLmpa/BagelMonster_FE
<br>

<h2>02. 팀 구성 및 업무 소개</h2>

| 팀 구성 | 역할        | 담당한 업무                                                                                                                                         |
|------|-----------|------------------------------------------------------------------------------------------------------------------------------------------------|
| 조해나  | 백엔드 로직 구현 | -  Store, Product, Cart, CartProduct 도메인 CRUD 구현 <br> - AWS S3 통한 이미지 등록/삭제 <br> - SSE를 활용한 알림 기능 구현                                           |
| 김희열  | AWS 배포    | - 가게 입장에서 Cart 도메인을 Order로 바꿔 Order 도메인 RUD 구현  <br> - AWS EC2, AWS Amplify를 통한 애플리케이션 배포 <br> - CORS 설정 <br> - 도메인에 대한 SSL 인증서를 발급받아 https 적용 |

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

<br>

<h2>05. 기술적 의사결정</h2>

| 기술 스택             | 사용 이유                                               |
|-------------------|-----------------------------------------------------|
| JWT               | 서버 메모리에 부담을 주지 않고 서버 확장에 용이한 인증/인가 방식               |
| AWS EC2           | 백엔드 서버 배포를 위해 사용                                    |
| AWS Amplify       | 프론트 뷰 배포를 위해 사용                                     |
| AWS Route53 & ACM | 도메인 구매 후 SSL 인증서를 발급 받아 https 적용                    |
| SSE               | 사용자 주문 완료 및 가게의 주문 취소 event를 단방향으로 프론트에게 전달하기 위해 적용 |

<br>

<h2>06. 트러블 슈팅</h2>

<br>

<h2>07. ERD 설계도 </h2>

 > ERD 원본 확인하기 : https://www.erdcloud.com/d/Pdu6txpyBqHk7oN2b
<br>

<h2>08. API 설계도 </h2>
 > API 원본 확인하기 : https://docs.google.com/spreadsheets/d/16hrlJtJsRxIR2JGB27hq91LDS3BlU0y5kxHWjP2GgLA/edit?usp=sharing
<br>
