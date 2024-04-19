package eomtime;

import java.time.LocalDateTime;

public class Test {

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.of(2024,3,20,21,0);
    System.out.println(now);
    System.out.println(now.plusMinutes(7800));
    System.out.println(now.plusMinutes(22200));
  }
}
