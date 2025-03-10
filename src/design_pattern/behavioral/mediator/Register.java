package design_pattern.behavioral.mediator;

public abstract class Register {

    protected RequestMediator request;
    protected int id;
    protected String subjectName;
    protected Student student;
    protected String groupSubject;

    public Register(RequestMediator request,
                    int id, String subjectName,
                    Student student, String groupSubject) {
        this.request = request;
        this.id = id;
        this.subjectName = subjectName;
        this.student = student;
        this.groupSubject = groupSubject;
    }

    public abstract void addTransaction(Register register);

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", student=" + student +
                ", groupSubject='" + groupSubject + '\'' +
                '}';
    }
}
