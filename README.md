# noticeboard-v2

###  프로젝트 개요

기존에 개발한 Android 게시판 애플리케이션(noticeboard)을 리팩토링하며 코드 구조 개선과 객체 설계를 학습하기 위해 진행한 프로젝트입니다.

게시글 작성, 수정, 삭제 화면마다 반복되던 네트워크 요청 코드의 중복을 줄이고,
보다 읽기 쉽고 재사용 가능한 구조로 개선하는 것을 목표로 했습니다.


###  리팩토링 배경

기존 코드에서는 각 화면마다 유사한 네트워크 요청 로직을 반복해서 작성해야 했고 이로 인해 코드가 길어지고 가독성이 떨어지는 문제가 있었습니다.

이를 개선하기 위해 네트워크 요청 역할을 담당하는 클래스를 별도로 분리하고 생성자와 메소드를 활용해 필요한 값만 전달받도록 구조를 변경했습니다.

<img width="1000" height="600" alt="notice_v2_1" src="https://github.com/user-attachments/assets/5e1a29a9-0245-49d9-8bac-237daa1ee929" /> 
<img width="1000" height="600" alt="12 7" src="https://github.com/user-attachments/assets/d7f72cfb-fb21-4490-90a4-76bbb1a906d0" />
