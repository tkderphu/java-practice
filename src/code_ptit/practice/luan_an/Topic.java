package code_ptit.practice.luan_an;

public class Topic {
    private String id;
    private String name;
    private String teacherInstruct;

    public Topic(int id, String name, String teacherInstruct) {
        this.id = String.format("DT%03d", id);
        this.name = name;
        this.teacherInstruct = teacherInstruct;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTeacherInstruct() {
        return teacherInstruct;
    }
}
