public class App {
    public static void main(String[] args) {
        String appTitle = "[엄타 서비스]";
        String title = "[회원정보]";
        String studentNo = "2412001";
        String name = "홍길동";
        int age = 20;
        boolean local = true;
        char gender = 'M';
        float average = 3.75f;


        System.out.println(appTitle);
        System.out.println(title);
        System.out.printf("학번: %s\n", studentNo);
        System.out.printf("이름: %s\n", name);
        System.out.printf("나이: %d\n", age);
        System.out.printf("내국인: %b\n", local);
        System.out.printf("성별: %c\n", gender);
        System.out.printf("평균학점: %.2f\n", average);
    }
}
