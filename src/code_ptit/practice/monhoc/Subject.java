package code_ptit.practice.monhoc;

public class Subject implements Comparable<Subject>{
    private String subjectId;
    private String subjectName;
    private String testFormat;

    public Subject(String subjectId, String subjectName, String testFormat) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.testFormat = testFormat;
    }



    @Override
    public String toString() {
        return subjectId + " " + subjectName + " " + testFormat;
    }

    @Override
    public int compareTo(Subject o) {
        return subjectId.compareTo(o.subjectId);
    }
}
