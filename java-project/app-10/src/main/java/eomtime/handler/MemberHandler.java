package eomtime.handler;

import eomtime.util.Prompt;
import eomtime.vo.Member;

public class MemberHandler {

  private static final int DEFAULT_SIZE = 3;
  private static Member[] members = new Member[DEFAULT_SIZE];
  private static int size = 0;

  public static void addMember() {
    if (size >= members.length) {
      int oldSize = members.length;
      int newSize = oldSize + (oldSize >> 1);

      Member[] newMembers = new Member[newSize];
      for (int i = 0; i < size; i++) {
        newMembers[i] = members[i];
      }
      members = newMembers;
    }

    Member m = new Member();
    m.studentNo = Prompt.inputString("학번? ");
    m.name = Prompt.inputString("이름? ");
    m.age = Prompt.inputInt("나이? ");
    m.local = Prompt.inputBoolean("내국인? ");
    m.gender = Prompt.inputChar("성별? ");
    m.average = Prompt.inputFloat("학점? ");

    members[size++] = m;
  }

  public static void detailMember() {
    int no = Prompt.inputInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }
    Member m = members[no];
    System.out.printf("학번: %s\n", m.studentNo);
    System.out.printf("이름: %s\n", m.name);
    System.out.printf("나이: %d\n", m.age);
    System.out.printf("내국인: %b\n", m.local);
    System.out.printf("성별: %c\n", m.gender);
    System.out.printf("평균학점: %.2f\n", m.average);
  }

  public static void listMember() {
    for (int i = 0; i < size; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s\n", i, m.studentNo, m.name, m.gender);
    }
  }

  public static void updateMember() {
    int no = Prompt.inputInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }

    Member m = members[no];
    m.studentNo = Prompt.inputString("학번(%s)? ", m.studentNo);
    m.name = Prompt.inputString("이름(%s)? ", m.name);
    m.age = Prompt.inputInt("나이(%d)? ", m.age);
    m.local = Prompt.inputBoolean("내국인(%b)? ", m.local);
    m.gender = Prompt.inputChar("성별(%s)? ", m.gender);
    m.average = Prompt.inputFloat("학점(%.2f)? ", m.average);
  }

  public static void deleteMember() {
    int no = Prompt.inputInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }
    for (int i = no; i < (size - 1); i++) {
      members[i] = members[i + 1];
    }
    size--;
  }
}
