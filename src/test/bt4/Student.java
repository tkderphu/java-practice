package test.bt4;

public class Student {
    private String id;
    private String name;
    private String topic;

    public Student(String id, String name, String topic) {
        this.id = id;
        this.name = name;
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }
}
