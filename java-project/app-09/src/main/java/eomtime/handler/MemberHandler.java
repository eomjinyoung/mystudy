package eomtime.handler;

import eomtime.util.Prompt;

public class MemberHandler {

  private static final int DEFAULT_SIZE = 3;
  private static String[] studentNo = new String[DEFAULT_SIZE];
  private static String[] name = new String[DEFAULT_SIZE];
  private static int[] age = new int[DEFAULT_SIZE];
  private static boolean[] local = new boolean[DEFAULT_SIZE];
  private static char[] gender = new char[DEFAULT_SIZE];
  private static float[] average = new float[DEFAULT_SIZE];
  private static int size = 0;

  public static void addMember() {
    if (size >= studentNo.length) {
      int oldSize = studentNo.length;
      int newSize = oldSize + (oldSize >> 1);

      String[] newStudentNo = new String[newSize];
      String[] newName = new String[newSize];
      int[] newAge = new int[newSize];
      boolean[] newLocal = new boolean[newSize];
      char[] newGender = new char[newSize];
      float[] newAverage = new float[newSize];

      for (int i = 0; i < size; i++) {
        newStudentNo[i] = studentNo[i];
        newName[i] = name[i];
        newAge[i] = age[i];
        newLocal[i] = local[i];
        newGender[i] = gender[i];
        newAverage[i] = average[i];
      }

      studentNo = newStudentNo;
      name = newName;
      age = newAge;
      local = newLocal;
      gender = newGender;
      average = newAverage;
    }

    studentNo[size] = Prompt.inputString("학번? ");
    name[size] = Prompt.inputString("이름? ");
    age[size] = Prompt.inputInt("나이? ");
    local[size] = Prompt.inputBoolean("내국인? ");
    gender[size] = Prompt.inputChar("성별? ");
    average[size] = Prompt.inputFloat("학점? ");

    size++;
  }

  public static void detailMember() {
    int no = Prompt.inputInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }
    System.out.printf("학번: %s\n", studentNo[no]);
    System.out.printf("이름: %s\n", name[no]);
    System.out.printf("나이: %d\n", age[no]);
    System.out.printf("내국인: %b\n", local[no]);
    System.out.printf("성별: %c\n", gender[no]);
    System.out.printf("평균학점: %.2f\n", average[no]);
  }

  public static void listMember() {
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s\n", i, studentNo[i], name[i], gender[i]);
    }
  }

  public static void updateMember() {
    int no = Prompt.inputInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }

    studentNo[no] = Prompt.inputString("학번(%s)? ", studentNo[no]);
    name[no] = Prompt.inputString("이름(%s)? ", name[no]);
    age[no] = Prompt.inputInt("나이(%d)? ", age[no]);
    local[no] = Prompt.inputBoolean("내국인(%b)? ", local[no]);
    gender[no] = Prompt.inputChar("성별(%s)? ", gender[no]);
    average[no] = Prompt.inputFloat("학점(%.2f)? ", average[no]);
  }

  public static void deleteMember() {
    int no = Prompt.inputInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }
    for (int i = no; i < (size - 1); i++) {
      studentNo[i] = studentNo[i + 1];
      name[i] = name[i + 1];
      age[i] = age[i + 1];
      local[i] = local[i + 1];
      gender[i] = gender[i + 1];
      average[i] = average[i + 1];
    }
    size--;
  }
}
