package code_ptit.practice.test;


import java.time.format.DateTimeFormatter;

public class TestTime implements Comparable<TestTime> {
    private TestRoom testRoom;
    private Subject subject;
    private Integer numberOfStudent;
    private String group;

    public TestTime(TestRoom testRoom, Subject subject,String group,  Integer numberOfStudent) {
        this.testRoom = testRoom;
        this.subject = subject;
        this.numberOfStudent = numberOfStudent;
        this.group = group;
    }

    @Override
    public int compareTo(TestTime o) {
        if(testRoom.getStart().compareTo(o.testRoom.getStart()) == 0) {
            return testRoom.getId().compareTo(o.testRoom.getId());
        }
        return testRoom.getStart().compareTo(o.testRoom.getStart());
    }

    @Override
    public String toString() {
        return testRoom.getStart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                + " " + testRoom.getRoomId()
                + " " + subject.getName()
                + " " + group
                + " " + numberOfStudent;
    }
}
