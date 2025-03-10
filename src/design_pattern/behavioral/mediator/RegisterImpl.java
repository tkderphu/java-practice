package design_pattern.behavioral.mediator;

public class RegisterImpl extends Register {

    public RegisterImpl(RequestMediator request,
                        int id,
                        String subjectName,
                        Student student,
                        String groupSubject) {
        super(request, id, subjectName, student, groupSubject);
    }

    @Override
    public void addTransaction(Register register) {
        request.saveRequest(register);
    }
}
