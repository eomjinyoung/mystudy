# 08. 클래스 - 메서드 분리

관련된 메서드를 묶어 관리하는 방법

## 프롬프트 관련 메서드 분리

- Prompt.java
  - 사용자 입력을 다루는 메서드를 별도의 클래스로 분리하여 관리하기
  - promptString() => inputString() 이름 변경
  - promptInt() => inputInt() 이름 변경
  - promptFloat() => inputFloat() 이름 변경
  - promptBoolean() => inputBoolean() 이름 변경
  - promptChar() => inputChar() 이름 변경
  - Scanner 스태틱 필드 선언
  - close() 메서드 추가
- App.java
  - Prompt 클래스로 옮긴 메서드를 사용하기

## 회원 데이터 다루는 메서드 분리

- MemberHandler.java
  - 회원 데이터 관련 스태틱 필드를 App 클래스에서 가져오기
  - addMember(), detailMember(), listMember(), updateMember(), deleteMember() 메서드를 App 클래스에서 가져오기
- App.java
  - MemberHandler 클래스로 옮긴 메서드를 사용하기


