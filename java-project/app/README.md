# 10. 클래스 - 데이터 타입 정의

복합 데이터를 담을 새 데이터 타입(사용자 정의 데이터 타입)을 만드는 방법

## vo(value object) 패키지 생성

- 사용자 정의 데이터 타입 클래스를 둘 eomtime.vo 패키지 생성하기

## 새 데이터 타입 클래스 정의 

- Member.java
  - 회원 데이터를 담을 메모리를 설계하기
    - eomtime.vo 패키지에 둔다.
  
## 새 데이터 타입으로 만든 메모리 사용

- MemberHandler.java
  - Member 인스턴스의 주소를 담을 레퍼런스 배열 준비하기
  - addMember(): 회원 데이터를 Member 인스턴스에 저장하기
  - detailMember()
    - Member 레퍼런스 배열에서 지정한 인덱스의 있는 레퍼런스에서 인스턴스 주소를 꺼낸다.
    - 그 인스턴스 주소를 이용하여 인스턴스 변수의 값을 꺼낸다.
  - listMember(), updateMember(), deleteMember() 도 배열 사용
  