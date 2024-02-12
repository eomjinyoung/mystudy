package eomtime;

import eomtime.handler.MemberHandler;
import eomtime.util.Prompt;

public class App {

  public static void main(String[] args) {
    String appTitle = "[엄타 서비스]";
    System.out.println(appTitle);

    printMenu();

    loop:
    while (true) {
      String command = Prompt.inputString("> ");

      switch (command) {
        case "1":
          MemberHandler.addMember();
          break;
        case "2":
          MemberHandler.detailMember();
          break;
        case "3":
          MemberHandler.listMember();
          break;
        case "4":
          MemberHandler.updateMember();
          break;
        case "5":
          MemberHandler.deleteMember();
          break;
        case "0":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    Prompt.close();
  }

  static void printMenu() {
    String title = "[회원정보]";
    System.out.println(title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 목록");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 종료");
  }
}
