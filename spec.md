## 0️⃣ 메인 페이지

### 헤더

- 로그인 전 : 로그인, 회원 가입 버튼
- 로그인 후 : 글쓰기, 회원 정보, 로그아웃 버튼

### 푸터

- 기타 정보


### 메인

- 블로그 글 제목만 페이징처리해서 나열
- 블로그 상세보기 버튼

<br>


![image](https://user-images.githubusercontent.com/62919440/162341194-1bdc3acd-68a7-4fd1-9ede-523af885b190.png)


<br>
<br>

## 1️⃣ 로그인 페이지

### 메인

- 아이디, 비밀번호 입력란
- 로그인 버튼, 카카오 로그인 버튼
- 카카오 OAuth 소셜 로그인 구현
- 아이디, 비밀번호 체크
- 스프링 시큐리티로 구현

<br>

![image](https://user-images.githubusercontent.com/62919440/162341219-d2e365f2-16c7-4c2a-81ea-876cb9f89496.png)


<br><br>

## 2️⃣ 회원가입 페이지

### 메인

- 아이디, 비밀번호, 이메일 입력
- 아이디 중복 체크
- 회원 가입 완료 버튼
- 회원가입 AJAX 사용

<br>

![image](https://user-images.githubusercontent.com/62919440/162341269-01d37da6-f926-44c4-9c73-8fe2dadc7aba.png)


<br>
<br>

## 3️⃣ 회원 정보 화면

### 메인

- 아이디, 이메일 변경 불가 (표시만 해줌)
- 비밀번호 변경 가능 (비밀번호는 표시하지 않음)
- 비밀 번호 변경 버튼
- 카카오 로그인 시에는 비밀번호 변경 불가 (비밀번호란이 보이지 않게 처리)

<br>

[카카오 로그인]

![image](https://user-images.githubusercontent.com/62919440/162341304-704a264f-9fec-43cd-a062-1d02cc094713.png)

[일반 로그인]

![image](https://user-images.githubusercontent.com/62919440/162341333-2c16e094-bc91-4861-9a0f-903377b082ac.png)

<br>
<br>

## 4️⃣ 글 작성 화면

### 메인

- 제목, 콘텐츠 작성란
- 글쓰기 완료 버튼
- 글쓰기 완료되면 데이터베이스로 제목, 콘텐츠, 작성자(로그인 한 사람) 저장

<br>

![image](https://user-images.githubusercontent.com/62919440/162341512-80beeb22-e24c-4f0d-b3ca-7cb7c7e4ab61.png)

<br>
<br>

## 5️⃣ 글 상세보기 화면

### 메인

- 제목, 콘텐츠 DB에서 불러와서 표시
- 수정, 돌아가기, 삭제 버튼 (수정, 삭제 버튼은 동일 사용자일 때만 표시)
- 삭제(댓글까지 함께 삭제), 수정 구현
- 댓글란 구현
- 댓글 작성 시 작성자, 댓글 내용 DB에 저장
- 댓글 삭제 버튼 (댓글 삭제 버튼은 댓글과 동일한 사용자일 때만 표시)

<br> 

![image](https://user-images.githubusercontent.com/62919440/162341552-075403ea-863e-40f2-91e2-f2692fc867bd.png)

<br><br>
