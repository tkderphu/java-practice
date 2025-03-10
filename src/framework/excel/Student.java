package framework.excel;

public class Student {
    @ExcelProperties(name = "Ma sinh vien")
    private String username;
    @ExcelProperties(name = "Ho va ten")
    private String fullName;
    @ExcelProperties(name = "Diem thanh phan", isDefined = Score.class)
    private Score score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
