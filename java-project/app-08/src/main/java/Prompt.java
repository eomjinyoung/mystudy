import java.util.Scanner;

public class Prompt {
  static Scanner scan = new Scanner(System.in);

  static String inputString(String title, Object... args) {
    System.out.printf(title, args);
    return scan.nextLine();
  }

  static int inputInt(String title, Object... args) {
    return Integer.valueOf(inputString(title, args));
  }

  static float inputFloat(String title, Object... args) {
    return Float.valueOf(inputString(title, args));
  }

  static boolean inputBoolean(String title, Object... args) {
    return Boolean.valueOf(inputString(title, args));
  }

  static char inputChar(String title, Object... args) {
    return inputString(title, args).charAt(0);
  }

  static void close() {
    scan.close();
  }
}
