package eomtime.util;

import java.util.Scanner;

public class Prompt {
  private static Scanner scan = new Scanner(System.in);

  public static String inputString(String title, Object... args) {
    System.out.printf(title, args);
    return scan.nextLine();
  }

  public static int inputInt(String title, Object... args) {
    return Integer.valueOf(inputString(title, args));
  }

  public static float inputFloat(String title, Object... args) {
    return Float.valueOf(inputString(title, args));
  }

  public static boolean inputBoolean(String title, Object... args) {
    return Boolean.valueOf(inputString(title, args));
  }

  public static char inputChar(String title, Object... args) {
    return inputString(title, args).charAt(0);
  }

  public static void close() {
    scan.close();
  }
}
