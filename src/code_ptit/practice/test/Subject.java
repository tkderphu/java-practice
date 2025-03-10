package code_ptit.practice.test;

public class Subject {
    private String id;
    private String name;
    private String format;

    public Subject(String id, String name, String format) {
        this.id = id;
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }
}
