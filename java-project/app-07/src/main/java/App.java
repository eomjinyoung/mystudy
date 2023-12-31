import java.util.Scanner;

public class App {

  static final int DEFAULT_SIZE = 3;
  static String[] studentNo = new String[DEFAULT_SIZE];
  static String[] name = new String[DEFAULT_SIZE];
  static int[] age = new int[DEFAULT_SIZE];
  static boolean[] local = new boolean[DEFAULT_SIZE];
  static char[] gender = new char[DEFAULT_SIZE];
  static float[] average = new float[DEFAULT_SIZE];
  static int size = 0;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    String appTitle = "[엄타 서비스]";
    System.out.println(appTitle);

    printMenu();

    loop:
    while (true) {

      System.out.print("> ");
      String command = scan.nextLine();

      switch (command) {
        case "1":
          addMember();
          break;
        case "2":
          detailMember();
          break;
        case "3":
          listMember();
          break;
        case "4":
          updateMember();
          break;
        case "5":
          deleteMember();
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

    scan.close();
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

  static void addMember() {
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

    studentNo[size] = promptString("학번? ");
    name[size] = promptString("이름? ");
    age[size] = promptInt("나이? ");
    local[size] = promptBoolean("내국인? ");
    gender[size] = promptChar("성별? ");
    average[size] = promptFloat("학점? ");

    size++;
  }

  static void detailMember() {
    int no = promptInt("번호? ");
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

  static void listMember() {
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s\n", i, studentNo[i], name[i], gender[i]);
    }
  }

  static void updateMember() {
    int no = promptInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }

    studentNo[no] = promptString("학번(%s)? ", studentNo[no]);
    name[no] = promptString("이름(%s)? ", name[no]);
    age[no] = promptInt("나이(%d)? ", age[no]);
    local[no] = promptBoolean("내국인(%b)? ", local[no]);
    gender[no] = promptChar("성별(%s)? ", gender[no]);
    average[no] = promptFloat("학점(%.2f)? ", average[no]);
  }

  static void deleteMember() {
    int no = promptInt("번호? ");
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

  static String promptString(String title, Object... args) {
    System.out.printf(title, args);
    return scan.nextLine();
  }

  static int promptInt(String title, Object... args) {
    return Integer.valueOf(promptString(title, args));
  }

  static float promptFloat(String title, Object... args) {
    return Float.valueOf(promptString(title, args));
  }

  static boolean promptBoolean(String title, Object... args) {
    return Boolean.valueOf(promptString(title, args));
  }

  static char promptChar(String title, Object... args) {
    return promptString(title, args).charAt(0);
  }
}
