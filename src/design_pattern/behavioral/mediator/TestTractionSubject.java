package design_pattern.behavioral.mediator;

public class TestTractionSubject {
    public static void main(String[] args) {
        Student phu = new Student("Nguyễn Quang Phú");
        Student nam = new Student("Tran Dinh Nam");
        Student hai = new Student("Nguyen Hoang Hai");
        Register register = new RegisterImpl(
                new RequestMediatorImpl(),
                1,
                "Xac xuat thong ke",
                phu,
                "05"
        );
        Register register1 = new RegisterImpl(
                new RequestMediatorImpl(),
                2,
                "Xac xuat thong ke",
                hai,
                "51"
        );
        Register register2 = new RegisterImpl(
                new RequestMediatorImpl(),
                3,
                "Xac xuat thong ke",
                nam,
                "08"
        );
        register.addTransaction(register1);
        register.addTransaction(register2);

        register.request.showListRequest();

    }
}
