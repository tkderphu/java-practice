package code_ptit.practice.luan_an;

public class Committee implements Comparable<Committee>{
    private Topic topic;
    private Student student;

    public Committee(Topic topic, Student student) {
        this.topic = topic;
        this.student = student;
    }

    @Override
    public int compareTo(Committee o) {
        return student.getId().compareTo(o.student.getId());
//        if(o.student.getName().compareTo(student.getName()) == 0) {
//            return student.getId().compareTo(o.student.getId());
//        }
//        return student.getName().compareTo(o.student.getName());
    }

    @Override
    public String toString() {
        return student.getId() + " " + student.getName() + " " + topic.getName() + " " + topic.getTeacherInstruct();
    }

    public enum ID {
        HD1("HOI DONG 1"),
        HD2("HOI DONG 2"),
        HD3("HOI DONG 3"),
        HD4("HOI DONG 4"),
        HD5("HOI DONG 5"),
        HD6("HOI DONG 6"),
        HD7("HOI DONG 7"),
        HD8("HOI DONG 8");
        private final String value;

        ID(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
