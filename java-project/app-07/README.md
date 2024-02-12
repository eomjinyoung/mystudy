# 07. 메서드 - 스태틱 메서드

재사용하기 쉽게 기능 단위로 코드를 묶어 관리하는 방법

## CRUD(Create, Read/Retrieve, Update, Delete) 기능을 메서드로 분리

- App.java
  - 메뉴를 처리하는 각 코드를 스태틱 메서드로 분리하기
    - addMember(), detailMember(), listMember(), updateMember(), deleteMember()
  - 메뉴에서 공유하는 변수는 스태틱 필드로 선언하기

## 메뉴 출력 코드를 메서드로 분리

- App.java
  - 메뉴를 출력하는 코드를 메서드로 분리하기: printMenu()

## 사용자로부터 값을 입력 받는 코드를 메서드로 분리

- App.java
  - 사용자로부터 값을 입력 받는 코드를 분리하기: prompt()

## 입력 값의 데이터 타입 변환을 자동화하기

- App.java
  - 문자열 입력 받기: promptString()
  - int 값 입력 받기: promptInt()
  - flaot 값 입력 받기: promptFloat()
  - boolean 값 입력 받기: promptBoolean()
  - char 값 입력 받기: promptChar()
  - 기존의 prompt() 메서드 삭제