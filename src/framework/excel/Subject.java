package framework.excel;

public class Subject {
    @ExcelProperties(name = "Ten mon hoc")
    private String name;
    @ExcelProperties(name = "So tin chi")
    private int credit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
