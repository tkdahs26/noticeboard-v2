# noticeboard-v2
기존 noticeboard 리팩토링한 이유
만약 constructor_stringrequest클래스가 없다면 게시판의 글쓰기, 수정, 삭제 화면마다 똑같은 StringRequest 객체를 만들고 코드가 길어져서 가독성이 안좋음 

장점: 나만의 객체를 만들어 코드를 줄이고 캡슐화하여 내부코드를 숨기고 입력만 받음
오버로딩을 활용하여 GET 방식일때는 매개변수가 4개이고 POST방식은 5개.

같은 프로그램을 구현하기 때문에 이 레포지토리에 구동하는사진은 안만들고 construct_stringrequest클래스 코드만 올리겠습니다.

<img width="1000" height="600" alt="notice_v2_1" src="https://github.com/user-attachments/assets/5e1a29a9-0245-49d9-8bac-237daa1ee929" /> 
<img width="1000" height="600" alt="12 7" src="https://github.com/user-attachments/assets/d7f72cfb-fb21-4490-90a4-76bbb1a906d0" />
