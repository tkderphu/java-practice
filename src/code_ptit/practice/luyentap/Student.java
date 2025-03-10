package code_ptit.practice.luyentap;

public class Student implements Comparable<Student>{
    private String fullName;
    private int correct;
    private int submitted;

    public Student(String fullName, int correct, int submitted) {
        this.fullName = fullName;
        this.correct = correct;
        this.submitted = submitted;
    }

    @Override
    public int compareTo(Student o) {
        if(correct == o.correct) {
            if(submitted == o.submitted) {
                return fullName.compareTo(o.fullName);
            }
            return submitted - o.submitted;
        }
        return o.correct - correct;
    }

    @Override
    public String toString() {
        return fullName + " " + correct + " " + submitted;
    }
}
