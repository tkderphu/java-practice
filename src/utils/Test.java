package utils;

public class Test {
    public static void main(String[] args) {
        Student student = ObjectUtils.init(
                Student.class,
                "B22DCCN621", "Nguyen Quang Phu"
        );
        System.out.println(student);
    }
}
